package com.challenge.literatura.repository;

import com.challenge.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByFechaDeNacimientoLessThanEqualAndFechaDeFallecimientoGreaterThanEqual(int anioInicial, int anioFinal);

    <T> Optional<T> findByNombreIgnoreCase(String nombre);
}
