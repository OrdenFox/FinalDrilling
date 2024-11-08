package com.colegio.servicios;

import com.colegio.modelos.Alumno;
import com.colegio.modelos.Materia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ArchivoServicio {
    private PromedioServicioImp promedioServicioImp = new PromedioServicioImp();

    public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        File directorio = archivo.getParentFile();
        
        // Verificar si el directorio existe, si no, crearlo
        if (directorio != null && !directorio.exists()) {
            directorio.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno : " + alumno.getRut() + " - " + alumno.getNombre() + "\n");
                for (Materia materia : alumno.getMaterias()) {
                    double promedio = promedioServicioImp.calcularPromedio(materia.getNotas());
                    writer.write("Materia : " + materia.getNombre() + " - Promedio : " + promedio + "\n");
                }
            }
            System.out.println("Datos exportados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

