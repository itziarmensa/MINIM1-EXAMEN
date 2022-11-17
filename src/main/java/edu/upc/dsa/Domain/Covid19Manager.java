package edu.upc.dsa.Domain;

import edu.upc.dsa.Domain.Entity.Exceptions.PersonaYaExiste;

public interface Covid19Manager {
    public int size();
    public void añadirPersona(String idPersona, String nombrePersona, String apellidosPersona, int edad, String saludPersona) throws PersonaYaExiste;
}
