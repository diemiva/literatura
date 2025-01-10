package com.challenge.literatura.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private int id;
    private String nombre;
    private String fechaDeNacimiento;
    private List<Libro> librosDeAutor = new ArrayList<>();

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimiento();
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", librosDeAutor=" + librosDeAutor +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public List<Libro> getLibrosDeAutor() {
        return librosDeAutor;
    }

    public void setLibrosDeAutor(List<Libro> librosDeAutor) {
        this.librosDeAutor = librosDeAutor;
    }


}
