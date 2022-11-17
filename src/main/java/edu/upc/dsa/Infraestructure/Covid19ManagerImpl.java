package edu.upc.dsa.Infraestructure;

import edu.upc.dsa.Domain.Covid19Manager;
import edu.upc.dsa.Domain.Entity.Exceptions.*;
import edu.upc.dsa.Domain.Entity.Laboratorio;
import edu.upc.dsa.Domain.Entity.Muestra;
import edu.upc.dsa.Domain.Entity.Persona;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;

    protected List<Laboratorio> labs;

    protected Map<String, Persona> personas;

    protected Queue<Muestra> muestras;

    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    public Covid19ManagerImpl(){
        this.labs = new ArrayList<>();
        this.personas = new HashMap<>();
        this.muestras = new LinkedList<>();
    }

    public static Covid19Manager getInstance() {
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }

    public int size() {
        int size = this.personas.size();
        logger.info("size " + size);
        return size;
    }

    public Boolean personaExisteId(String idPersona) {
        for(Persona persona : this.personas.values()){
            if(persona.getIdPersona() == idPersona){
                return true;
            }
        }
        return false;
    }

    @Override
    public void añadirPersona(String idPersona, String nombrePersona, String apellidosPersona, int edad, String saludPersona) throws PersonaYaExiste {
        logger.info("Intentando crear el usuario con id: "+idPersona+", nombre: "+nombrePersona+", apellidos:"+apellidosPersona+", edad: "+edad+" y salud: "+saludPersona+"");
        if(personaExisteId(idPersona)){
            logger.error("El usuario ya existe.");
            throw new PersonaYaExiste();
        }
        Persona persona = new Persona(idPersona,nombrePersona,apellidosPersona,edad,saludPersona);
        this.personas.put(persona.getIdPersona(),persona);
        logger.info("Se ha creado correctamente");

    }

    public Laboratorio getLabById(String idLab) {
        return this.labs.stream()
                .filter(x->idLab.equals(x.getIdLab()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void crearLab(String idLab, String nombreLab) throws LabYaExiste {
        logger.info("Intentando crear el laboratorio con id: "+idLab+" y nombre: "+nombreLab+"");
        Laboratorio lab = getLabById(idLab);
        if(lab != null){
            logger.error("El juego ya existe.");
            throw new LabYaExiste();
        }
        Laboratorio lab1 = new Laboratorio(idLab,nombreLab);
        this.labs.add(lab1);
        logger.info("Se ha creado correctamente");

    }

    @Override
    public void añadirMuestra(String idMuestra, String idClinico, String idPersona, String fecha, String idEnvio) throws MuestraYaExiste {
        logger.info("Intentando crear la muestra");
        if(getMuestraById(idMuestra) != null){
            logger.error("La muestra ya existe, cambia el id");
            throw new MuestraYaExiste();
        }
        Muestra muestra = new Muestra(idMuestra,idClinico,idPersona,fecha,idEnvio);
        this.muestras.add(muestra);
        logger.info("Se ha creado correctamente");

    }

    public Muestra getMuestraById(String idMuestra) {
        return this.muestras.stream()
                .filter(x->idMuestra.equals(x.getIdMuestra()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void extraerMuestra(Muestra muestra) throws PersonaNoExiste,LabNoExiste, MuestraYaExiste {
        logger.info("Intentando extraer muestra del usuario "+muestra.getIdPersona()+"");
        if(getPersonaById(muestra.getIdPersona()) == null){
            logger.error("La persona no existe.");
            throw new PersonaNoExiste();
        }
        if(getMuestraById(muestra.getIdMuestra()) != null){
            logger.error("Escoge otro identificador, la muestra ya existe.");
            throw new MuestraYaExiste();
        }
        if(getLabById(muestra.getIdClinico()) == null | getLabById(muestra.getIdEnvio()) == null){
            logger.error("El laboratorio no existe.");
            throw new LabNoExiste();
        }
        Laboratorio lab = getLabById(muestra.getIdEnvio());
        Queue<Muestra> muestrasPendientes = lab.getMuestrasPendientes();
        muestrasPendientes.add(muestra);
        logger.info("La muestra se ha enviado al laboratorio: "+muestra.getIdEnvio()+"");

    }

    public Persona getPersonaById(String idPersona) {
        return this.personas.values().stream()
                .filter(x->idPersona.equals(x.getIdPersona()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void procesarMuestra(String idLab) throws LabNoExiste {
        logger.info("Procesando muestra ...");
        if(getLabById(idLab) == null){
            logger.error("El laboratorio no existe.");
            throw new LabNoExiste();
        }
        Laboratorio lab = getLabById(idLab);
        Queue<Muestra> muetrasPendientes = lab.getMuestrasPendientes();
        Muestra muestraProcesada = muetrasPendientes.poll();

        Persona persona = getPersonaById(muestraProcesada.getIdPersona());
        List<Muestra> muestrasProcesadasPersona = persona.getMuestrasProcesadas();
        muestrasProcesadasPersona.add(muestraProcesada);
        logger.info("La muestra se ha procesado correctamente.");

    }

    @Override
    public List<Muestra> listaMuestrasPersonaProcesadas(String idUsuario) throws PersonaNoExiste {
        logger.info("Obteniendo lista de muestras procesadas del usuario: "+idUsuario+"");
        if(getPersonaById(idUsuario) == null){
            logger.error("La persona no existe.");
            throw new PersonaNoExiste();
        }
        Persona persona = getPersonaById(idUsuario);
        logger.info("Lista obtenida correctamente.");
        return persona.getMuestrasProcesadas();
    }

    public int numPersonas(){
        return this.personas.size();
    }
    public int numLabs(){
        return this.labs.size();
    }

    public int numMuestras(){
        return this.muestras.size();
    }

    public Queue<Muestra> listMuestras(){
        return muestras;
    }
    public List<Persona> listPersonas(){
        List<Persona> pers = new ArrayList<>(this.personas.values());
        return pers;
    }
    public List<Laboratorio> listaLabs(){
        return labs;
    }

}
