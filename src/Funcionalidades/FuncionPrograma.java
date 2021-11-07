package Funcionalidades;
//_________________________Importaciones de Java_____________________________
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import Persona.Persona;

public class FuncionPrograma 
{
    public static void Menu()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|            MENÚ DE INICIO           |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Iniciar sesión                   |");
        System.out.println("| 2) Manual de Usuario                |");
        System.out.println("| 3) Créditos                         |");
        System.out.println("| 4) Salir                            |");
        System.out.println("+-------------------------------------+");
        return;
    }
    /**
     * Verfica que exista el archivo y plantilla de personal, sino crea un master
     * @param plantilla
     * @throws IOException
     */
    public static void verficarCrearAdmin(String plantilla) throws IOException
    {
        File nuevo = new File(plantilla);
        if(!nuevo.exists())
        {
            Date creacion = new Date();
            Persona admin = new Persona("master",30,creacion,"master",'a');
            if(nuevo.createNewFile())
            {
                Persona.guardadoEnArchivo(plantilla, admin);
            }
        }
        return;
    }
    /**
     * Metodo para leer una opcion con un menú dado previamente
     * @return opcion numérica
     */
    public static int leerOpcion()
    {
        int opt = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite su opción: ");
        entrada.nextLine();
        opt = entrada.nextInt();
        entrada.close();
        return opt;
    }
}
