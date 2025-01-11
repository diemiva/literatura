package com.challenge.literatura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int fechaDeNacimiento;
    private int fechaDeFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros= new ArrayList<>();


    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimiento();
        this.fechaDeFallecimiento = datosAutor.fechaDeFallecimiento();
    }

    public Autor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(int fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(int fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        StringBuilder tituloLibros = new StringBuilder();
        for (Libro libro : libros) {
            tituloLibros.append(libro.getTitulo()+", ");
        }

        if(tituloLibros.length()>0){
            tituloLibros.deleteCharAt(tituloLibros.length()-1);
        }
        return "\n" + "-----------Autor-----------" + "\n" +
                "Autor: " + nombre + "\n" +
                "fecha De Nacimiento: " + fechaDeNacimiento + "\n" +
                "fecha De Fallecimiento:  " + fechaDeFallecimiento + "\n" +
                "libros: " + "[" + tituloLibros + "]\n" ;
    }


}
