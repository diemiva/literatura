package com.challenge.literatura.repository;

import com.challenge.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository  extends JpaRepository<Libro, Integer> {

    List<Libro> findByIdiomasContaining(String idiomas);

    Optional<Libro> findByTitulo(String titulo);
}
