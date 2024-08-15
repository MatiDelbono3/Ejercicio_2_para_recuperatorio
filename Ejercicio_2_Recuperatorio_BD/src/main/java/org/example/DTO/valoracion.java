package org.example.DTO;

import java.util.Date;

public class valoracion {
    private int valoracion_id;
    private int usuario_id;
    private int puntuacion;
    private String comentario;
    private Date Fecha_valoracion;

    public int getValoracion_id() {
        return valoracion_id;
    }

    public void setValoracion_id(int valoracion_id) {
        this.valoracion_id = valoracion_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_valoracion() {
        return Fecha_valoracion;
    }

    public void setFecha_valoracion(Date fecha_valoracion) {
        Fecha_valoracion = fecha_valoracion;
    }
}
