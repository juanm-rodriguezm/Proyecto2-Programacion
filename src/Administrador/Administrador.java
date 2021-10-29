package Administrador;

import java.util.Date;

import Persona.Persona;

/**
 * Clase de administrador para manejo del sistema
 */
public class Administrador extends Persona
{
    public Administrador(String usuario, int edad, Date creacion, String contrasena)
    {
        super(usuario, edad, creacion, contrasena);
        super.tipo = 'a';
    }
    /** 
     * Menu con las funcionalidades del administrador
     */
    public static void Menu()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|         MENÚ DE ADMINISTRADOR       |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Crar una nueva cuenta            |");
        System.out.println("| 2) Crear una asignatura             |");
        System.out.println("| 3) Eliminar una asignatura          |");
        System.out.println("| 4) Modificar una asignatura         |");
        System.out.println("| 5) Salir                            |");
        System.out.println("+-------------------------------------+");
        return;
    }
}
