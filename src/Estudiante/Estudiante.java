package Estudiante;

import java.util.Date;

import Persona.Persona;

/**
 * Clase con las funcionalidades básica de estudiantes
 */
public class Estudiante extends Persona
{
    private String carrera;
    private int semestre;
    public Estudiante(String nombre, String apellido, int edad, Date creacion, String carrera, int semestre)
    {
        super(nombre, apellido, edad, creacion);
        this.carrera = carrera;
        this.semestre = semestre;
    }
    public static void Menu()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|           MENÚ DE ESTUDIANTE        |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Ver cursos                       |");
        System.out.println("| 2) Enviar proyectos                 |");
        System.out.println("| 3) Buzón de mensajería              |");
        System.out.println("| 4) Inscribir un curso               |");
        System.out.println("| 5) Cancelar un curso                |");
        System.out.println("| 6) Listar cursos                    |");
        System.out.println("| 5) Salir                            |");
        System.out.println("+-------------------------------------+");
        return;
    }
}
