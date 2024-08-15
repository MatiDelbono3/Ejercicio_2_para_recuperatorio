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
}
