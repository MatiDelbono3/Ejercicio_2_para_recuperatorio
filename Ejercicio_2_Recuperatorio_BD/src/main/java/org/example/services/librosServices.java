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
    List<libro> librosDelGeneroDeseado=new ArrayList<>();
    List<libro>C1 = new ArrayList<>();
    try{
    session.beginTransaction();
    String hql1 = "SELECT DISTINCT l.libro_id, l.titulo, l.autor, l.genero, l.publicacion\n" +
            "FROM libros l\n" +
            "JOIN valoraciones v ON l.libro_id = v.libro_id\n" +
            "WHERE l.genero = 'Fantasía'\n" +
            "AND l.publicacion > 2010\n" +
            "AND v.puntuacion > 3;";
    Query<libro> Consulta1 = session.createQuery(hql1, libro.class);
    Consulta1.setParameter("genero", genero);
    librosDelGeneroDeseado=Consulta1.getResultList();
    return librosDelGeneroDeseado;

} finally {
        session.close();
    }
    }
public List<libro>ObtenerLibrosDeUnAutor(String autor, String publicacion){
    Session session= HibernateUtil.getSession();
    List<libro> librosDelAutorDeseado=new ArrayList<>();
    try {
        session.beginTransaction();
        String hql2 = "SELECT DISTINCT l.libro_id, l.titulo, l.autor, l.genero, l.publicacion\n" +
                "FROM libros l\n" +
                "JOIN valoraciones v ON l.libro_id = v.libro_id\n" +
                "WHERE (l.autor = :autor OR l.publicacion < :anio)\n" +
                "AND v.puntuacion = 5";

        Query<libro> Consulta2 = session.createQuery(hql2, libro.class);
        Consulta2.setParameter("autor", autor);
        Consulta2.setParameter("publicacion", String.valueOf(publicacion));  // Suponiendo que publicacion es String
        librosDelAutorDeseado=Consulta2.getResultList();

        return librosDelAutorDeseado;
    } finally {
        session.close();
    }
}
public List<libro>ObtenerLibrosConPuntuacionMayor4(){
    Session session=HibernateUtil.getSession();
    List<libro>libroConPuntuacionIndicada=new ArrayList<>();
    try {
        session.beginTransaction();
        String hql3 = "SELECT l.libro_id, l.titulo, l.autor, l.genero, l.publicacion"+
        "FROM libros l" +
        "JOIN valoraciones v ON l.libro_id = v.libro_id" +
        "GROUP BY l.libro_id, l.titulo, l.autor, l.genero, l.publicacion" +
        "HAVING AVG(v.puntuacion) >= 4 AND COUNT(v.valoracion_id) >= 4";
        Query<libro>Consulta3= session.createQuery(hql3, libro.class);
        libroConPuntuacionIndicada=Consulta3.getResultList();
        return libroConPuntuacionIndicada;
    }finally {
        session.close();
    }
}
}
