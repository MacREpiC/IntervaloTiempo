package org.iesalandalus.programacion.poo.intervalotiempo.modelo.vista;

import org.iesalandalus.programacion.poo.intervalotiempo.modelo.Fecha;
import org.iesalandalus.programacion.poo.intervalotiempo.modelo.IntervaloFecha;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola(){
    }

    public static Fecha leerFechaAnyo(){
        Fecha fecha = null;
        do{
            try {
                fecha = new Fecha(leerAnyo());
            } catch (IllegalArgumentException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        } while(fecha == null);
        return fecha;
    }

    private static int leerAnyo(){
        System.out.println("Dime el año: ");
        return Entrada.entero();
    }

    public static Fecha leerFechaAnyoMes(){
        int anyo = 0;
        int mes = 0;
        System.out.println("Dime el año: ");
        anyo = Entrada.entero();
        System.out.println("Dime el mes: ");
        mes = Entrada.entero();
        return new Fecha(anyo, mes);
    }

    private int leerMes(){
        System.out.println("Dime el mes: ");
        return Entrada.entero();
    }

    private static Fecha leerFechaCompleta(){
        int anyo = 0;
        int mes = 0;
        int dia = 0;
        System.out.println("Dime el año: ");
        anyo = Entrada.entero();
        System.out.println("Dime el mes: ");
        mes = Entrada.entero();
        System.out.println("Dime el día: ");
        dia = Entrada.entero();
        return new Fecha(anyo, mes, dia);
    }

    private static int leeDia(){
        System.out.println("Dime el día: ");
        return Entrada.entero();
    }

    private IntervaloFecha leerIntervalo(){
        IntervaloFecha intervaloFecha = null;
        do{
            System.out.println("Dime el inicio: ");
            Fecha inicio = leerFechaCompleta();
            System.out.println("Dime el fin: ");
            Fecha fin = leerFechaAnyo();
            try {
                intervaloFecha = new IntervaloFecha(inicio, fin);
            } catch (IllegalArgumentException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (intervaloFecha == null);
        return intervaloFecha;
    }
}
