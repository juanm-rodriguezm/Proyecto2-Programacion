package Test;
//______________________ Importación de Paquetes propios _______________________________
import Persona.Persona;
import Profesor.Profesor;
import Funcionalidades.FuncionPrograma;
//______________________ Importación de Paquetes java __________________________________
import java.util.Scanner;

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
        String planilla = "planillaU.obj";
        char tipo = ' ';
        //_______________________ Declaración de objetos _______________________________
        Scanner inp = new Scanner(System.in);
        Persona colaborador = null;
        Estudiante alumno = null;
        Profesor maestro = null;
        Administrador admin = null;
        // ______________________ Desarrollo general ___________________________________
        do
        {
            try
            {
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
                        colaborador = Persona.leerEnArchivo(planilla, usuario);
                        switch(ntipo)
                        {
                            case 1:
                                Administrador.Menu();
                                do
                                {
                                    //TODO: Opciones de menuAd:
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
                                System.out.println("Volviendo al menú");
                                break;
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
