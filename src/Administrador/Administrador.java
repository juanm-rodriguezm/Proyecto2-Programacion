package Administrador;


import java.util.Date;
import java.util.Scanner;

import Estudiante.Estudiante;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Persona.Persona;
import Profesor.Profesor;

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

    public void crearCuenta(String planilla)
    throws IOException, ClassNotFoundException, FileNotFoundException
    {
        boolean novalido = true;
        String usuario,contrasena;
        Scanner inp = new Scanner(System.in);
        int edad = 0,tipochar = 0;
        char tipo = ' ';
        File formato = null;
        ObjectOutputStream oos = null;
        System.out.println("Ingrese su nombre de usuario: ");
        usuario=inp.next();
        System.out.println("Ingrese la contraseña: ");
        contrasena=inp.next();
        Date dat= new Date();
        System.out.println("Ingrese la edad del usuario: ");
        edad=inp.nextInt();
        do
        {
            System.out.println("+-------------------------------------+");
            System.out.println("|         MENÚ Tipo de Persona        |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 1) Administrador                    |");
            System.out.println("| 2) Profesor                         |");
            System.out.println("| 3) Estudiante                       |");
            System.out.println("+-------------------------------------+");
            tipochar=inp.nextInt();
            switch(tipochar)
            {
                case 1:
                    tipo='a';
                    novalido = !novalido;
                    break;
                case 2:
                    tipo='p';
                    novalido = !novalido;
                    break;
                case 3:
                    tipo='e';
                    novalido = !novalido;
                    break;
                default:
                    tipo =' '; 
                    System.out.println("Digite un tipo válido: ");
                    break;
            }
        }while(novalido);
        Persona persona = new Persona(usuario, edad, dat, contrasena,tipo);
        formato = new File(planilla);
        if(formato.length()==0)
        {
            oos= new ObjectOutputStream(new FileOutputStream(formato));
            oos.writeObject(persona);
        }
        else
        {
            super.guardadoEnArchivo(planilla, persona);
        }
        oos.close();
        inp.close();
    }
    public void CrearUnaAsignatura(Profesor profe, Estudiante[] estudiante, int cantidadestudiantes,String archivo){
        Persona persona=null,perso;
        String NombreProfe,NombreAsignatura;
        Scanner inp = new Scanner(System.in);
        int creditos;
        System.out.println("Ingrese el nombre de la asignatura a crear ");
        NombreAsignatura=inp.next();
        if(Persona.leerEnArchivo(archivo,profe.getUsuario())!=null)
        {
            perso=Persona.leerEnArchivo(archivo, profe.getUsuario());
            if(perso.getTipo()=='p')
            {
                System.out.println("el usuario esta autorizado para impartir la asignatura ");
                NombreProfe=perso.getUsuario();
            }
        }
        System.out.println("Ingrese la cantidad de creditos de la asignatura ");
        creditos=inp.nextInt();
        //funcion para ingresar las asignaturas que recibe nombre profesor, nombre asignatura y cantidad de creditos
    }
}
