package com.challenge.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name="libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @Column(name="idiomas")
    private String idiomas;
    private Double numeroDeDescargas;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(name="nombre_autor")
    private String nombreAutor;

    private String libroDetalles;



    public Libro(DatosLibro datosLibro, Autor autor) {
        this.titulo = datosLibro.titulo();
        setIdiomas(String.valueOf(datosLibro.idiomas()));
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
        this.nombreAutor = autor.getNombre();
        this.libroDetalles = String.valueOf(datosLibro.libroDetalles());
        this.autor = autor;
    }
    public Libro() {

    }

    @Override
    public String toString() {
        return "\n" + "-----Libro----" + "\n" +
                "Titulo: " + titulo + "\n" +
                "Autor: " + nombreAutor + "\n" +
                "Idioma: " + idiomas + "\n" +
                "Numero de descargas: " + numeroDeDescargas + "\n";
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getLibroDetalles() {
        return libroDetalles;
    }

    public void setLibroDetalles(String libroDetalles) {
        this.libroDetalles = libroDetalles;
    }
}
