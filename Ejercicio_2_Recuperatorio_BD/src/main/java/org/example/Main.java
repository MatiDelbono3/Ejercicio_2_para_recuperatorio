package org.example;

import org.example.DTO.libro;
import org.example.services.librosServices;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        librosServices ServicioLibro = new librosServices();
        Scanner scanner = new Scanner(System.in);
        int Opcion;
        do {
            System.out.println("Lea una opción");
            Opcion = scanner.nextInt();
            switch (Opcion) {
                case 1:
                    System.out.println("retornar libros de un genero determinado");
                    String genero = scanner.nextLine();
                    List<libro> LibrosDeUnGenero = ServicioLibro.librosDeUnGenero(genero);
                    LibrosDeUnGenero.forEach(libro -> System.out.println("ID " + libro.getLibro_id() + "Autor  " + libro.getAutor() + "titulo " + libro.getTitulo() + "genero" + libro.getGenero() + "fecha publicacion" + libro.getPublicacion()));
                case 2:
                    System.out.println("retornar libros por autor o anio");
                    String Autor = scanner.nextLine();
                case 3:
                    System.out.println("retornar libros con la puntuacion indicada");

            }
            System.out.println("Lea una opción");
            Opcion = scanner.nextInt();
        } while (Opcion != -1);

    }
}