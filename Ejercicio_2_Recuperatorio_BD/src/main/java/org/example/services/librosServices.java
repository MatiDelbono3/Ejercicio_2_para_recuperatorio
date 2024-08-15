package org.example.services;

import org.example.DTO.libro;
import org.example.connections.HibernateUtil;
import org.example.entities.libros;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class librosServices {
public List<libro> librosDeUnGenero(String genero){
    Session session= HibernateUtil.getSession();
    List<libros>librosDelGeneroDeseado=new ArrayList<>();
    List<libro>C1 = new ArrayList<>();
    try{
    session.beginTransaction();
    String hql = "SELECT DISTINCT l FROM Libro l " +
            "JOIN l.valoraciones v " +
            "WHERE l.genero = :genero " +
            "AND l.publicacion > '2010' " +
            "AND v.puntuacion > 3";
    Query Consulta1 = session.createQuery(hql);
    Consulta1.setParameter("genero", genero);
    librosDelGeneroDeseado=Consulta1.getResultList();
    for (libros l : librosDelGeneroDeseado){
        C1.add(new libro(l));
        session.getTransaction().commit();
    }
    return C1;

} finally {
        session.close();
    }
    }
public List<libro>ObtenerLibrosDeUnAutor(String autor, String publicacion){
    Session session= HibernateUtil.getSession();
    List<libros>librosDelAutorDeseado=new ArrayList<>();
    List<libro>C2 = new ArrayList<>();
    try {
        session.beginTransaction();
        String hql = "SELECT DISTINCT l FROM libros l " +
                "JOIN l.valoraciones v " +
                "WHERE (l.autor = :autor OR l.publicacion < :publicacion) " +
                "AND v.puntuacion = 5";

        Query Consulta2 = session.createQuery(hql);
        Consulta2.setParameter("autor", autor);
        Consulta2.setParameter("publicacion", String.valueOf(publicacion));  // Suponiendo que publicacion es String
        librosDelAutorDeseado=Consulta2.getResultList();
        for (libros l : librosDelAutorDeseado){
            C2.add(new libro(l));
            session.getTransaction().commit();
        }
        return C2;
    } finally {
        session.close();
    }
}
}
