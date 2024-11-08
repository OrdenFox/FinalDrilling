package com.colegio.vistas;


import com.colegio.modelos.Alumno;
import com.colegio.modelos.Materia;
import com.colegio.modelos.MateriaEnum;
import com.colegio.servicios.AlumnoServicio;
import com.colegio.servicios.ArchivoServicio;

import java.util.List;
import java.util.Map;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();

    @Override
    public void exportarDatos() {
        System.out.print("Ingresa la ruta en donde se exportará el archivo promedios.txt: ");
        String rutaArchivo = scanner.nextLine();
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), "C:/promedios.txt");
    }


    @Override
    public void crearAlumno() {
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();
        alumnoServicio.crearAlumno(new Alumno(rut, nombre, apellido, direccion));
        System.out.println("--- ¡Alumno agregado! ---");
    }

    @Override
    public void agregarMateria() {
        System.out.print("Ingresa rut del Alumno: ");
        String rut = scanner.nextLine();
        System.out.println("1. MATEMATICAS");
        System.out.println("2. LENGUAJE");
        System.out.println("3. CIENCIA");
        System.out.println("4. HISTORIA");
        System.out.print("Selecciona una Materia: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        MateriaEnum materiaEnum = MateriaEnum.values()[opcion - 1];
        alumnoServicio.agregarMateria(rut, new Materia(materiaEnum));
        System.out.println("--- ¡Materia agregada! ---");
    }

    @Override
    public void agregarNotaPasoUno() {
        System.out.print("Ingresa rut del Alumno: ");
        String rut = scanner.nextLine();
        System.out.println("Alumno tiene las siguientes materias agregadas:");
        List<Materia> materias = alumnoServicio.materiasPorAlumnos(rut);
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + ". " + materias.get(i).getNombre());
        }
        System.out.print("Seleccionar materia: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        Materia materia = materias.get(opcion - 1);
        System.out.print("Ingresar nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        materia.getNotas().add(nota);
        System.out.println("--- ¡Nota agregada a " + materia.getNombre() + "! ---");
    }

    @Override
    public void listarAlumnos() {
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        for (Alumno alumno : alumnos.values()) {
            System.out.println("Datos Alumno");
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("Materias");
            if (alumno.getMaterias() != null) {
                for (Materia materia : alumno.getMaterias()) {
                    System.out.println(materia.getNombre());
                    System.out.println("Notas:");
                    System.out.println(materia.getNotas());
                }
            } else {
                System.out.println("No hay materias asignadas.");
            }
        }
    }


    @Override
    public void terminarPrograma() {
        System.out.println("Finalizando programa...");
        System.exit(0);
    }
}
