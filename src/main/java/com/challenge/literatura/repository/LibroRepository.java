package com.challenge.literatura.repository;

import com.challenge.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository  extends JpaRepository<Libro, Integer> {
    boolean libroExistentePorTitulo(String titulo);

    List<Libro> findByIdiomasContaining(String idioma);
}
