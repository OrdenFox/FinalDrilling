package com.colegio.servicios;

import com.colegio.modelos.Alumno;
import com.colegio.modelos.Materia;
import com.colegio.modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class AlumnoServicioTest {
    private AlumnoServicio alumnoServicio;
    private AlumnoServicio alumnoServicioMock;
    private Materia matematicas;
    private Materia lenguaje;
    private Alumno alumno;

    @BeforeEach
    public void setup() {
        alumnoServicio = new AlumnoServicio();
        alumnoServicioMock = Mockito.mock(AlumnoServicio.class);
        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
        alumno = new Alumno("1.111.111-1", "Milton", "P.", "Casita 1");
    }

    @Test
    public void crearAlumnoTest() {
        alumnoServicio.crearAlumno(alumno);
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertEquals(1, alumnos.size());
        assertEquals(alumno, alumnos.get("1.111.111-1"));
    }

    @Test
    public void agregarMateriaTest() {
        alumnoServicio.crearAlumno(alumno);
        alumnoServicio.agregarMateria("1.111.111-1", matematicas);
        List<Materia> materias = alumnoServicio.materiasPorAlumnos("1.111.111-1");
        assertEquals(1, materias.size());
        assertEquals(matematicas, materias.get(0));
    }

    @Test
    public void materiasPorAlumnosTest() {
        when(alumnoServicioMock.materiasPorAlumnos("1.111.111-1")).thenReturn(List.of(matematicas, lenguaje));
        List<Materia> materias = alumnoServicioMock.materiasPorAlumnos("1.111.111-1");
        assertEquals(2, materias.size());
        assertEquals(matematicas, materias.get(0));
        assertEquals(lenguaje, materias.get(1));
    }

    @Test
    public void listarAlumnosTest() {
        alumnoServicio.crearAlumno(alumno);
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertEquals(1, alumnos.size());
        assertEquals(alumno, alumnos.get("1.111.111-1"));
    }
}
