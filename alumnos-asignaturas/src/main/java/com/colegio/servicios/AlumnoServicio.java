package com.colegio.servicios;

import com.colegio.modelos.Alumno;
import com.colegio.modelos.Materia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos = new HashMap<>();

    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    public void agregarMateria(String rutAlumno, Materia materia) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            alumno.getMaterias().add(materia);
        }
    }

    public List<Materia> materiasPorAlumnos(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        return alumno != null ? alumno.getMaterias() : null;
    }

    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}
