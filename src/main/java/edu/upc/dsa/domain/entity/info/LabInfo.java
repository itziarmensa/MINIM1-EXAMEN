package edu.upc.dsa.domain.entity.info;

public class LabInfo {
    String idLab;
    String nombreLab;

    public LabInfo(){}

    public LabInfo(String idLab, String nombreLab) {
        this.idLab = idLab;
        this.nombreLab = nombreLab;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getNombreLab() {
        return nombreLab;
    }

    public void setNombreLab(String nombreLab) {
        this.nombreLab = nombreLab;
    }
}
