package edu.upc.dsa.domain.entity.info;

public class Informe {
    String idMuestra;
    String estado;
    String comentario;

    public Informe(){}

    public Informe(String idMuestra, String estado, String comentario) {
        this.idMuestra = idMuestra;
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

    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }
}
