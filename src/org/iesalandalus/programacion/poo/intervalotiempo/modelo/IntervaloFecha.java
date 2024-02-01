package org.iesalandalus.programacion.poo.intervalotiempo.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public record IntervaloFecha(Fecha inicio, Fecha fin) {
    public IntervaloFecha {
        Objects.requireNonNull(inicio, "El inicio no puede ser nulo");
        Objects.requireNonNull(fin, "El fin no puede ser nulo");

        if (!fin.mayorQue(inicio)) {
            throw new IllegalArgumentException("El tiempo de fin debe ser posterior al tiempo de inicio.");
        }
    }

    @Override
    public String toString() {
        return "[" + inicio + " - " + fin + "]";
    }
}