package org.example.DTO;

import org.example.entities.libros;

import java.util.Date;

public class libro {
    private int libro_id;
    private String titulo;
    private String autor;
    private String genero;
    private Date publicacion;
    public libro(libros l) {
        int id=l.getLibro_id();
        String titulo=l.getTitulo();
        String autor=l.getAutor();
        String genero=l.getGenero();
        Date fechaPublicacion=new Date();
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Date publicacion) {
        this.publicacion = publicacion;
    }
}
