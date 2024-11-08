package com.colegio.servicios;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromedioServicioImpTest {
    private PromedioServicioImp promedioServicioImp = new PromedioServicioImp();

    @Test
    public void calcularPromedioTest() {
        List<Double> notas = Arrays.asList(4.0, 5.0, 6.0);
        double promedio = promedioServicioImp.calcularPromedio(notas);
        assertEquals(5.0, promedio);
    }
}

