package org.iesalandalus.programacion.poo.intervalotiempo.modelo;

public record Fecha(int dia, int mes, int anyo) {
    private static final int DIAS_TOTALES = 31;
    private static final int MES_TOTALES = 12;
    private static final int ANYO_MINIMO = 1900;
    private static final int ANYO_MAXIMO = 2100;

    public Fecha {
        validarDia(dia);
        validarMes(mes);
        validarAnyo(anyo);
    }

    public Fecha() {
        this(0, 0, 0);
    }

    public Fecha(int dia) {
        this(dia, 0, 0);
    }

    public Fecha(int dia, int mes) {
        this(dia, mes, 0);
    }

    private void validarDia(int dia) {
        if (dia < 0 || dia >= DIAS_TOTALES) {
            throw new IllegalArgumentException("Día no válido.");
        }
    }

    private void validarMes(int mes) {
        if (mes < 0 || mes >= MES_TOTALES) {
            throw new IllegalArgumentException("Mes no válido.");
        }
    }

    private void validarAnyo(int anyo) {
        if (anyo < ANYO_MINIMO || anyo > ANYO_MAXIMO) {
            throw new IllegalArgumentException("Año no válido.");
        }
    }
    public static Fecha getMayor(){
        return new Fecha(DIAS_TOTALES, MES_TOTALES , ANYO_MAXIMO);
    }
    public static Fecha getMenor(){
        return new Fecha(1,1,ANYO_MINIMO);
    }

    public boolean menorQue(Fecha fecha) {
        if (anyo < fecha.anyo) {
            return true;
        } else if (anyo == fecha.anyo && mes < fecha.mes) {
            return true;
        } else if (anyo == fecha.anyo && mes == fecha.mes && dia < fecha.dia) {
            return true;
        } else {
            return false;
        }
    }

    public boolean mayorQue(Fecha fecha) {
        if (anyo > fecha.anyo) {
            return true;
        } else if (anyo == fecha.anyo && mes > fecha.mes) {
            return true;
        } else if (anyo == fecha.anyo && mes == fecha.mes && dia > fecha.dia) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", año=" + anyo +
                '}';
    }
}
