
package com.ef.poo.poo_ef_1.model;
public class Entrevista {
    private int id;
    private int postulanteId;
    private String fecha;
    private String tipo;
    private double puntaje;
    private String comentarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostulanteId() {
        return postulanteId;
    }

    public void setPostulanteId(int postulanteId) {
        this.postulanteId = postulanteId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Entrevista{" +
                "id=" + id +
                ", postulanteId=" + postulanteId +
                ", fecha='" + fecha + '\'' +
                ", tipo='" + tipo + '\'' +
                ", puntaje=" + puntaje +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
