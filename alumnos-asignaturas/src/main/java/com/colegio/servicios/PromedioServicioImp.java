package com.colegio.servicios;

import java.util.List;

public class PromedioServicioImp {
    public double calcularPromedio(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}
