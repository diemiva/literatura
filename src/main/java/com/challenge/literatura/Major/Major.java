package com.challenge.literatura.Major;

import com.challenge.literatura.model.Datos;
import com.challenge.literatura.service.ConsumoAPI;
import com.challenge.literatura.service.ConvierteDatos;

import java.util.Scanner;

public class Major {
    public static final String URL_API = "https://gutendex.com/books/";
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void menuConsulta() {
        var json = consumoAPI.obtenerDatos(URL_API);
        System.out.println(json);
        var datos = convierteDatos.obtenerDatos(json, Datos.class);
        System.out.println(datos);
    }
}
