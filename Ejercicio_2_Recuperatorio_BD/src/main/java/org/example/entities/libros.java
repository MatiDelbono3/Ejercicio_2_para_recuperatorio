package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="libros")
public class libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libro_id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "genero")
    private String genero;
    @Column(name = "publicacion")
    private String publicacion;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<valoraciones> valoraciones;

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

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public List<org.example.entities.valoraciones> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<org.example.entities.valoraciones> valoraciones) {
        this.valoraciones = valoraciones;
    }
}
