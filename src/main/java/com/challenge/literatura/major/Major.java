package com.challenge.literatura.major;

import com.challenge.literatura.model.*;
import com.challenge.literatura.repository.AutorRepository;
import com.challenge.literatura.repository.LibroRepository;
import com.challenge.literatura.service.ConsumoAPI;
import com.challenge.literatura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Major {
    public static final String URL_API = "https://gutendex.com/books/?search=";
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    @Autowired
    public Major(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public Major() {

    }

    public void menuConsulta() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                     \n
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

    private Datos getDatosLibro() {
        var libroTitulo = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_API + libroTitulo.replace(" ", "+"));
        Datos datosLibro = convierteDatos.obtenerDatos(json, Datos.class);
        return datosLibro;
    }


    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar");
        Datos datos = getDatosLibro();

        if (datos.resultados().isEmpty()) {
            System.out.println("El libro no existe en la API de Gutendex, ingresa otro.");
            return;
        }

        DatosLibro datosLibro = datos.resultados().getFirst();
        DatosAutor datosAutor = datosLibro.autor().getFirst();

        Optional<Libro> libroExistente = libroRepository.findByTitulo(datosLibro.titulo());
        if (libroExistente.isPresent()) {
            System.out.println("Este libro ya se encuentra en la base de datos:");
            System.out.println(libroExistente.get());
            return;
        }

        Autor autor = obtenerORegistrarAutor(datosAutor);
        Libro nuevoLibro = crearLibro(datosLibro, autor);
        libroRepository.save(nuevoLibro);
        System.out.println(nuevoLibro);
    }

    private Autor obtenerORegistrarAutor(DatosAutor datosAutor) {
        return (Autor) autorRepository
                .findByNombreIgnoreCase(datosAutor.nombre())
                .orElseGet(() -> {
                    Autor nuevoAutor = new Autor(datosAutor);
                    return autorRepository.save(nuevoAutor);
                });
    }

    private Libro crearLibro(DatosLibro datosLibro, Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo");
        }

        Libro libro = new Libro();
        libro.setTitulo(datosLibro.titulo());
        libro.setAutor(autor); // Asignar el autor correctamente
        libro.setNombreAutor(autor.getNombre());
        libro.setIdiomas(String.valueOf(datosLibro.idiomas()));
        libro.setNumeroDeDescargas(datosLibro.numeroDeDescargas());
        libro.setLibroDetalles(String.valueOf(datosLibro.libroDetalles()));

        return libro;
    }


    private void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        if(libros.isEmpty()) {
            System.out.println("El libro no existe en la base de datos");
            return;
        }
        System.out.println("-----Listado de libros registrados-----");
        libros.stream().sorted(Comparator.comparing(Libro::getTitulo)).forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<Autor> autor = autorRepository.findAll();
        if(autor.isEmpty()) {
            System.out.println("El autor no existe en la base de datos");
            return;
        }
        System.out.println("-----Listado de autores registrados-----");
        autor.stream().sorted(Comparator.comparing(Autor::getNombre)).forEach(System.out::println);
    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Digite el año para el cual desea buscar: ");
        var ano = teclado.nextInt();
        teclado.nextLine();
        if(ano < 0){
            System.out.println("El ano no puede ser negativo");
        }
        List<Autor> autorPorAno = autorRepository.findByFechaDeNacimientoLessThanEqualAndFechaDeFallecimientoGreaterThanEqual(ano, ano);
        if(autorPorAno.isEmpty()) {
            System.out.println("No hay autores registrados para el año " + ano);
        }
        autorPorAno.stream().sorted(Comparator.comparing(Autor::getNombre)).forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
    }
}
