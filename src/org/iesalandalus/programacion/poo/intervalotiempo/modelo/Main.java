package org.iesalandalus.programacion.poo.intervalotiempo.modelo;

import org.iesalandalus.programacion.poo.intervalotiempo.modelo.vista.Consola;

public class Main {
    public static void main(String[] args) {
        Tiempo tiempo = Consola.leerTiempoHora();
        System.out.println(tiempo);
        System.out.println();
    }
}
