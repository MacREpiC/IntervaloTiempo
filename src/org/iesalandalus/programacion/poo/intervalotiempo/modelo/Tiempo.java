package org.iesalandalus.programacion.poo.intervalotiempo.modelo;

public record Tiempo(int hora, int minuto, int segundo) {
    private static final int HORAS_TOTALES = 24;
    private static final int MINUTOS_TOTALES = 60;
    private static final int SEGUNDOS_TOTALES = 60;

    public Tiempo {
        validarHora(hora);
        validarMinutos(minuto);
        validarSegundos(segundo);
    }
    public Tiempo(){
        this(0,0,0);
    }
    public Tiempo(int hora){
        this(hora, 0,0);
    }
    public Tiempo(int hora, int minutos){
        this(hora, minutos, 0);
    }
    private void validarHora(int hora) {
        if (hora < 0 || hora >= HORAS_TOTALES) {
            throw new IllegalArgumentException("Hora no válida.");
        }
    }
    private void validarMinutos(int minutos) {
        if (minutos < 0 || minutos >= MINUTOS_TOTALES) {
            throw new IllegalArgumentException("Minutos no válidos.");
        }
    }
    private void validarSegundos(int segundos) {
        if (segundos < 0 || segundos >= SEGUNDOS_TOTALES) {
            throw new IllegalArgumentException("Segundos no válidos.");
        }
    }
    public static Tiempo getMayor(){
        return new Tiempo(MINUTOS_TOTALES - 1, HORAS_TOTALES - 1, SEGUNDOS_TOTALES - 1);
    }
    public static Tiempo getMenor(){
        return new Tiempo(0,0,0);
    }
    public Tiempo masHoras(int horas){
        int totalHoras = (hora + horas) % (HORAS_TOTALES);
        if (totalHoras < 0) {
            totalHoras += HORAS_TOTALES;
        }
        return new Tiempo(totalHoras, minuto, segundo);
    }
    public Tiempo masMinutos(int minutos){
        int horasSobrantes = (minutos + minuto) / MINUTOS_TOTALES;
        int minutosResultantes = (minutos + minuto) % MINUTOS_TOTALES;
        if (minutosResultantes < 0){
            minutosResultantes += MINUTOS_TOTALES;
            horasSobrantes--;
        }
        return new Tiempo(hora, minutosResultantes, segundo).masHoras(horasSobrantes);
    }
    public Tiempo masSegundos(int segundos){
        int minutosSobrantes = (segundo + segundos) / SEGUNDOS_TOTALES;
        int segundosResultantes = (segundos + segundos) % MINUTOS_TOTALES;
        if (segundosResultantes < 0){
            segundosResultantes += SEGUNDOS_TOTALES;
            minutosSobrantes--;
        }
        return new Tiempo(hora, minuto, segundosResultantes).masMinutos(minutosSobrantes);
    }
    public Tiempo sumar(Tiempo tiempo){
        return masSegundos(tiempo.segundo).masMinutos(tiempo.minuto).masHoras(tiempo.hora);
    }
    public Tiempo restar(Tiempo tiempo) {
        return masSegundos(-tiempo.segundo).masMinutos(-tiempo.minuto).masHoras(-tiempo.hora);
    }
    public boolean menorQue(Tiempo tiempo) {
        if (hora < tiempo.hora) {
            return true;
        } else if (hora == tiempo.hora && minuto < tiempo.minuto) {
            return true;
        } else if (hora == tiempo.hora && minuto == tiempo.minuto && segundo < tiempo.segundo) {
            return true;
        } else {
            return false;
        }
    }

    public boolean mayorQue(Tiempo tiempo) {
        if (hora > tiempo.hora) {
            return true;
        } else if (hora == tiempo.hora && minuto > tiempo.minuto) {
            return true;
        } else if (hora == tiempo.hora && minuto == tiempo.minuto && segundo > tiempo.segundo) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
}
