package edu.upc.dsa.Domain.Entity;

public class Muestra {
    String idMuestra;
    String idClinico;
    String idPersona;
    String fechaMuestra;
    String idEnvio;

    public Muestra(){}

    public Muestra(String idMuestra, String idClinico, String idPersona, String fechaMuestra, String idEnvio) {
        this.idMuestra = idMuestra;
        this.idClinico = idClinico;
        this.idPersona = idPersona;
        this.fechaMuestra = fechaMuestra;
        this.idEnvio = idEnvio;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getFechaMuestra() {
        return fechaMuestra;
    }

    public void setFechaMuestra(String fechaMuestra) {
        this.fechaMuestra = fechaMuestra;
    }

    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }
}
