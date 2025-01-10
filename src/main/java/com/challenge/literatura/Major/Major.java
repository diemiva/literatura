package com.challenge.literatura.Major;

import com.challenge.literatura.model.Datos;
import com.challenge.literatura.model.DatosLibro;
import com.challenge.literatura.service.ConsumoAPI;
import com.challenge.literatura.service.ConvierteDatos;

import java.util.Optional;
import java.util.Scanner;

public class Major {
    public static final String URL_API = "https://gutendex.com/books/";
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void menuConsulta() {
//        var json = consumoAPI.obtenerDatos(URL_API);
//        System.out.println(json);
//        var datos = convierteDatos.obtenerDatos(json, Datos.class);
//        System.out.println(datos);

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                     1- Buscar libro por titulo
                     2- Listar libros registrados
                     3- Listar autores registrados
                     4- Listar autores vivos en un determinado año
                     5- Listar libros por idioma
                     0- Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosPorAno();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Gracias por usar esta aplicacion.... Saliendo");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        //Busqueda de libros por nombre

        System.out.println("Ingrese el nombre del libro");
        var tituloLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_API + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = convierteDatos.obtenerDatos(json, Datos.class);

        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void listarLibrosRegistrados() {
    }

    private void listarAutoresRegistrados() {
    }

    private void listarAutoresVivosPorAno() {
    }

    private void listarLibrosPorIdioma() {
    }
}
