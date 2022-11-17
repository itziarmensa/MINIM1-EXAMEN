package edu.upc.dsa.Domain;

import edu.upc.dsa.Domain.Entity.Exceptions.*;
import edu.upc.dsa.Domain.Entity.Muestra;

import java.util.List;

public interface Covid19Manager {
    public int size();
    public void añadirPersona(String idPersona, String nombrePersona, String apellidosPersona, int edad, String saludPersona) throws PersonaYaExiste;
    public void crearLab(String idLab, String nombreLab) throws LabYaExiste;
    public void extraerMuestra(Muestra muestra) throws PersonaNoExiste,LabNoExiste, MuestraYaExiste;
    public void procesarMuestra(String idLab) throws LabNoExiste,PersonaNoExiste;
    public List<Muestra> listaMuestrasPersonaProcesadas(String idUsuario) throws PersonaNoExiste;
    public int numPersonas();
    public int numLabs();
}
