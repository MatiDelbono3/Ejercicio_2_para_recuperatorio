package org.example.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="valoraciones")
public class valoraciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int valoracion_id;
    @Column(name = "usuario_id")
    private int usuario_id;
    @Column(name = "puntuacion")
    private int puntuacion;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "fecha_valoracion")
    private Date fecha_valoracion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private libros libro;

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
        return fecha_valoracion;
    }

    public void setFecha_valoracion(Date fecha_valoracion) {
        this.fecha_valoracion = fecha_valoracion;
    }

    public libros getLibro() {
        return libro;
    }

    public void setLibro(libros libro) {
        this.libro = libro;
    }
}
