package Test;
//______________________ Importación de Paquetes propios _______________________________
import Persona.Persona;
import Profesor.Profesor;
import Funcionalidades.FuncionPrograma;
import Administrador.Administrador;
import Estudiante.Estudiante;
//______________________ Importación de Paquetes java __________________________________
import java.util.Scanner;
import java.lang.Exception;
//import java.io.File;
import java.io.IOException;
import java.util.Date;
public class Main 
{
    //_______________________________DESARROLLO DEL MAIN________________________________
    public static void main(String[] args)
    {
        //_______________________ Declaración de variables _____________________________
        int opt = 0,opt2 = 0, ntipo = 0, edad = 0;
        String usuario = " ", password = " ", aux = " ";
        String planilla = "planillaU.obj";  //Nombre del listado de personas
        char tipo = ' ';
        //_______________________ Declaración de objetos _______________________________
        Scanner inp = null;
        Persona colaborador = null;
        Estudiante alumno = null;
        Profesor maestro = null;
        Administrador admin = null;
        //File manejoArchivos = null;
        Date creacion = null;
        // ______________________ Desarrollo general ___________________________________
        do
        {
            
            try
            {
                inp = new Scanner(System.in);
                FuncionPrograma.verficarCrearAdmin(planilla);
                FuncionPrograma.Menu();
                aux = inp.nextLine();
                opt = Integer.parseInt(aux);
                switch(opt)
                {
                    case 1:
                        System.out.println("Preparando ingreso de sesión...");
                        System.out.println("\n\tDigite su usuario: ");
                        usuario = inp.nextLine();
                        System.out.println("\tDigite su contraseña: ");
                        password = inp.nextLine();
                        colaborador = Persona.leerEnArchivo(planilla, usuario, password);
                        if(colaborador == null)
                        {
                            System.out.println("Volviendo al menu por fallo de login...");
                        }
                        else 
                        {
                            //-------Lectura del tipo de cuenta y clasificación---------------
                            tipo = colaborador.getTipo();
                            System.out.println("Tipo: " + tipo);
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
                            System.out.println("Ntipo: " + ntipo);
                            //--------------------Manejo de menus de usuarios--------------------
                            usuario = colaborador.getUsuario();
                            edad = colaborador.getEdad();
                            creacion = colaborador.getCreacion();
                            password = colaborador.getContrasena();
                            switch(ntipo)
                            {
                                case 1:
                                    Administrador.Menu();
                                    admin = new Administrador(usuario, edad, creacion, password);
                                    do
                                    {
                                        System.out.println("Digite su opcion admin: ");
                                        opt2 = FuncionPrograma.leerOpcion();
                                        switch(opt2)
                                        {
                                            case 1:
                                                System.out.println("Cargando instrucciones para crear cuenta....");    
                                                admin.crearCuenta(planilla);
                                                break;
                                            case 2:
                                                System.out.println("Cargando y preparando la creación de clase....");
                                                break;
                                            case 3:
                                                System.out.println("Cargando clases existentes....");
                                                break;
                                            case 4:
                                                System.out.println("Buscando clases existentas para modificar...");
                                                break;
                                            case 5:
                                                System.out.println("Volviendo al menú general del programa....");
                                                break;
                                            default:
                                                System.out.println("Volviendo a desplegar menú del admin...");
                                                break;
                                        }
                                    }while(opt2 != 5);
                                    break;
                                case 2:
                                    Profesor.Menu();
                                    maestro = new Profesor(usuario, edad, creacion, password);
                                    do
                                    {
                                        opt2 = FuncionPrograma.leerOpcion();
                                        switch(opt2)
                                        {
                                            case 1:
                                                System.out.println("Viendo proyectos activos...");    
                                                admin.crearCuenta(planilla);
                                                break;
                                            case 2:
                                                System.out.println("Cargando opción de mensajería...");
                                                break;
                                            case 3:
                                                System.out.println("Cargando opción de brindar orientación ...");
                                                break;
                                            case 4:
                                                System.out.println("Mirando estudiantes en todas las clases...");
                                                break;
                                            case 5:
                                                System.out.println("Listando clases ...");
                                                break;
                                            case 6:
                                                System.out.println("Saliendo de la sesión...");
                                                break;
                                            default:
                                                System.out.println("Volviendo a mostrar el menú...");
                                                break;
                                        }
                                        System.out.println(maestro);
                                    }while(opt2!=6);
                                    System.out.println(alumno);
                                    break;
                                case 3:
                                    Estudiante.Menu();
                                    alumno = new Estudiante(usuario, edad, creacion, password);
                                    do
                                    {
                                        System.out.println("Digite su opcion admin: ");
                                        opt2 = FuncionPrograma.leerOpcion();
                                        switch(opt2)
                                        {
                                            case 1:
                                                System.out.println("Cargar cursos...");    
                                                admin.crearCuenta(planilla);
                                                break;
                                            case 2:
                                                System.out.println("Cargando proyectos...");
                                                break;
                                            case 3:
                                                System.out.println("Buscando mensajería pendiente ...");
                                                break;
                                            case 4:
                                                System.out.println("Mirando cursos...");
                                                break;
                                            case 5:
                                                System.out.println("Mirando y cargando sus cursos...");
                                                break;
                                            case 6:
                                                System.out.println("Saliendo de la sesión...");
                                                break;
                                            default:
                                                System.out.println("Volviendo a mostrar el menú...");
                                                break;
                                        }
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
            catch(IOException io)
            {
                System.out.println("Ha ocurrido un problema con el flujo del archivo:\n" + io.getMessage());
                System.out.println(io.getStackTrace());    
            }
            catch(ClassNotFoundException cnfe)
            {
                System.out.println("Verifique que está ejecutando el problema, junto a los paqueetes requridos:");
                System.out.println(cnfe.getMessage());
            }
            catch(Exception exp)
            {
                System.out.println("Error " + exp.getMessage());
                System.out.println(exp.getStackTrace());
            }
            finally
            {
                System.out.println("Finally");
                inp.close();
                opt = 3;
            }
        } while(opt!=3);
        System.out.println("Sali del programa");
        
    }
}
