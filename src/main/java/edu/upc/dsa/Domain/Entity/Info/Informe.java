package edu.upc.dsa.Domain.Entity.Info;

public class Informe {
    String estado;
    String comentario;

    public Informe(){}

    public Informe(String estado, String comentario) {
        this.estado = estado;
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
