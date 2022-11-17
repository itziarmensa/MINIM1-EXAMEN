package edu.upc.dsa.Domain.Entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Laboratorio {
    String idLab;
    String nombreLab;

    Queue<Muestra> muestrasPendientes;

    public Laboratorio(){
        this.muestrasPendientes = new LinkedList<>();
    }

    public Laboratorio(String idLab, String nombreLab) {
        this.idLab = idLab;
        this.nombreLab = nombreLab;
        this.muestrasPendientes = new LinkedList<>();
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

    public Queue<Muestra> getMuestrasPendientes() {
        return muestrasPendientes;
    }

    public void setMuestrasPendientes(Queue<Muestra> muestrasPendientes) {
        this.muestrasPendientes = muestrasPendientes;
    }
}
