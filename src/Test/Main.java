package Test;
//______________________ Importación de Paquetes propios _______________________________
import Persona.Persona;
import Profesor.Profesor;
import Funcionalidades.FuncionPrograma;

import java.io.File;
//______________________ Importación de Paquetes java __________________________________
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import Administrador.Administrador;
import Estudiante.Estudiante;
//import java.util.Date;
public class Main 
{
    //_______________________________DESARROLLO DEL MAIN________________________________
    public static void main(String[] args)
    {
        //_______________________ Declaración de variables _____________________________
        int opt = 0, opt2 = 0, ntipo = 0;
        String usuario = " ", password = " ";
        String planilla = "planillaU.obj";  //Nombre del listado de personas
        char tipo = ' ';
        //_______________________ Declaración de objetos _______________________________
        Scanner inp = new Scanner(System.in);
        Persona colaborador = null;
        Estudiante alumno = null;
        Profesor maestro = null;
        Administrador admin = null;
        File manejoArchivos = null;
        // ______________________ Desarrollo general ___________________________________
        do
        {
            try
            {
                FuncionPrograma.verficarCrearAdmin(planilla);
                FuncionPrograma.Menu();
                opt = inp.nextInt();
                System.out.println(opt);
                switch(opt)
                {
                    case 1:
                        System.out.println("Preparando ingreso de sesión...");
                        System.out.println("\n\tDigite su usuario");
                        usuario = inp.next();
                        System.out.println("\tDigite su contraseña: ");
                        password = inp.next();
                        colaborador = Persona.leerEnArchivo(planilla, usuario, password);
                        if(colaborador == null)
                        {
                            System.out.println("Volviendo al menu por fallo de login...");
                        }
                        else 
                        {
                            //-------Lectura del tipo de cuenta y claseficación---------------
                            tipo = colaborador.getTipo();
                            if(tipo == 'a')
                            {
                                ntipo = 1;
                            }
                            else if(tipo == 'p')
                            {
                                ntipo = 2;
                            }
                            else if(tipo == 'e')
                            {
                                ntipo = 3;
                            }
                            else
                            {
                                ntipo = 4;
                            }
                            //--------------------Manejo de menus de usuarios--------------------
                            switch(ntipo)
                            {
                                case 1:
                                    Administrador.Menu();
                                    do
                                    {
                                        //TODO: Opciones de menuAd:
                                        //switch()
                                        //crear usuario... llamado a metodo de administrador
                                        //crear a clase... llamado a método en administrador
                                    }while(opt2!=5);
                                    break;
                                case 2:
                                    Profesor.Menu();
                                    do
                                    {
                                        //TODO: Opciones de menuPr:
                                    }while(opt2!=6);
                                    break;
                                case 3:
                                    Estudiante.Menu();
                                    do
                                    {
                                        //TODO: Opciones de menuEs:
                                    }while(opt2!=7);
                                    break;
                                default:
                                    System.out.println("Volviendo al menú, tipo invalido...");
                                    break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Mostrando manual de usuario...");
                        break;
                    case 3:
                        System.out.println("Mostrando créditos...");
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Volviendo a mostrar...");
                        break;
                }
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
            finally
            {
                System.out.println("Finally");
            }
        }while(opt!=3);
        System.out.println("Sali del programa");
        inp.close();
    }
}
