package Administrador;

import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;
import java.io.File;

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
        System.out.println("| 1) Crear una nueva cuenta           |");
        System.out.println("| 2) Crear una asignatura             |");
        System.out.println("| 3) Eliminar una asignatura          |");
        System.out.println("| 4) Modificar una asignatura         |");
        System.out.println("| 5) Salir                            |");
        System.out.println("+-------------------------------------+");
        return;
    }
    Scanner inp = new Scanner(System.in);
    //TODO:método de creación de usuario
    public void Crear(File file){
    String usuario,contrasena;
    Date creacion;
    int edad,tipochar;
    char tipo;
        System.out.println("Ingrese su nombre de usuario: ");
        usuario=in.next;
         System.out.println("Ingrese la contraseña: ");
        contrasena=in.next;
         Date dat= new Date();
         System.out.println("Ingrese la edad del usuario: ");
        edad=in.nextInt;
        do{
        System.out.println("+-------------------------------------+");
        System.out.println("|         MENÚ Tipo de Persona        |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Administrador                    |");
        System.out.println("| 2) Profesor                         |");
        System.out.println("| 3) Estudiante                       |");
        System.out.println("+-------------------------------------+");
        tipochar=in.nextInt;
        switch(tipochar){
            case 1:
            tipo='a';
            break;
            case 2:
            tipo='p';
            break;
            case 3:
            tipo=' ';
            break;
        }
        }while(true);
        Persona persona = new Persona(usuario, edad, dat, contrasena);
        ObjectOutputStream oos = null;
        if(file.length()==0){
                oos= new ObjectOutputStream(new FileOutputStream(file));
        }
        else{
            oos = new ObjectOutputStream(new FileOutputStream(file,true));
        }
        oos.writeObject(persona);

    }
    //TODO: Método de creación de clase
}
