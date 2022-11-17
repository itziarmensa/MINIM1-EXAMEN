package edu.upc.dsa.Domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    String idPersona;
    String nombrePersona;
    String apellidosPersona;
    int edadPersona;
    String saludPersona;
    List<Muestra> muestrasProcesadas;

    public Persona(){this.muestrasProcesadas = new ArrayList<>();}

    public Persona(String idPersona, String nombrePersona, String apellidosPersona, int edadPersona, String saludPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
        this.edadPersona = edadPersona;
        this.saludPersona = saludPersona;
        this.muestrasProcesadas = new ArrayList<>();
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    public String getSaludPersona() {
        return saludPersona;
    }

    public void setSaludPersona(String saludPersona) {
        this.saludPersona = saludPersona;
    }

    public List<Muestra> getMuestrasProcesadas() {
        return muestrasProcesadas;
    }

    public void setMuestrasProcesadas(List<Muestra> muestrasProcesadas) {
        this.muestrasProcesadas = muestrasProcesadas;
    }
}
