package com.challenge.literatura.model;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    private int id;
    private String titulo;
    private String idiomas;
    private Double numeroDeDescargas;
    private String libroDetalles;
    private List<Autor> autores = new ArrayList<>();

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.idiomas = String.valueOf(datosLibro.idiomas());
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
        this.libroDetalles = String.valueOf(datosLibro.libroDetalles());
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", numeroDeDescargas=" + numeroDeDescargas +
                ", libroDetalles='" + libroDetalles + '\'' +
                ", autores=" + autores +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public String getLibroDetalles() {
        return libroDetalles;
    }

    public void setLibroDetalles(String libroDetalles) {
        this.libroDetalles = libroDetalles;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }


}
