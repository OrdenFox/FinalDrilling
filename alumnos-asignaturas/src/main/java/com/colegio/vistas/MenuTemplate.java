package com.colegio.vistas;

import java.util.Scanner;

public class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    public void exportarDatos() {
        // Implementación pendiente
    }

    public void crearAlumno() {
        // Implementación pendiente
    }

    public void agregarMateria() {
        // Implementación pendiente
    }

    public void agregarNotaPasoUno() {
        // Implementación pendiente
    }

    public void listarAlumnos() {
        // Implementación pendiente
    }

    public void terminarPrograma() {
        // Implementación pendiente
    }

    public final void iniciarMenu() {
        int opcion;
        do {
            System.out.println("1. Crear Alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.print("Selección: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    agregarMateria();
                    break;
                case 4:
                    agregarNotaPasoUno();
                    break;
                case 5:
                    terminarPrograma();
                    break;
                case 6:
                    exportarDatos();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
