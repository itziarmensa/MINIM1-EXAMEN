package edu.upc.dsa.Domain;

import edu.upc.dsa.Domain.Entity.Exceptions.*;
import edu.upc.dsa.Domain.Entity.Laboratorio;
import edu.upc.dsa.Domain.Entity.Muestra;
import edu.upc.dsa.Domain.Entity.Persona;

import java.util.List;
import java.util.Queue;

public interface Covid19Manager {
    public int size();

    public void añadirPersona(String idPersona, String nombrePersona, String apellidosPersona, int edad, String saludPersona) throws PersonaYaExiste;

    public void crearLab(String idLab, String nombreLab) throws LabYaExiste;

    public void extraerMuestra(Muestra muestra) throws PersonaNoExiste, LabNoExiste, MuestraYaExiste;

    public void procesarMuestra(String idLab) throws LabNoExiste, PersonaNoExiste;

    public List<Muestra> listaMuestrasPersonaProcesadas(String idUsuario) throws PersonaNoExiste;

    public int numPersonas();

    public int numLabs();

    public int numMuestras();

    public void añadirMuestra(String idMuestra, String idClinico, String idPersona, String fecha, String idEnvio) throws MuestraYaExiste;

    public Queue<Muestra> listMuestras();

    public List<Persona> listPersonas();

    public List<Laboratorio> listaLabs();

}

