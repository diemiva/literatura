//package com.challenge.literatura.service;
//
//import com.challenge.literatura.model.Autor;
//import com.challenge.literatura.model.Libro;
//import com.challenge.literatura.repository.AutorRepository;
//import com.challenge.literatura.repository.LibroRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ServicioLibro {
//    private final LibroRepository libroRepository;
//    private final AutorRepository autorRepository;
//
//
//    public ServicioLibro(LibroRepository libroRepository, AutorRepository autorRepository) {
//        this.libroRepository = libroRepository;
//        this.autorRepository = autorRepository;
//    }
//
//    public Libro registrarLibro(Libro libro) {
//        if (!libroRepository.existsByTitulo(libro.getTitulo())) {
//            // Asociar autores al libro y guardar relaciones
//            libro.getAutores().forEach(autor -> {
//                if (!autorRepository.existsById(autor.getId())) {
//                    autorRepository.save(autor);
//                }
//            });
//
//            return libroRepository.save(libro);
//        }
//        return null;
//    }
//
//
//    public List<Libro> listarLibros() {
//        return libroRepository.findAll();
//    }
//
//    public List<Autor> listarAutores() {
//        return autorRepository.findAll();
//    }
//
//    public List<Autor> listarAutoresVivosEnAno(String year) {
//        return autorRepository.findByFechaDeNacimientoContaining(year);
//    }
//
//    public List<Libro> listarLibrosPorIdioma(String idioma) {
//        return libroRepository.findByIdiomasContaining(idioma);
//    }
//}
