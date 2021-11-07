package Administrador;
//_________________________ IMPORTACIÓN DE PAQUETES DE JAVA___________________________________
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectOutputStream;
//_________________________ IMPORTACIÓN DE PAQUETES PROPIOS___________________________________
import Estudiante.Estudiante;
import Persona.Persona;
import Profesor.Profesor;

/**
 * Clase de administrador para manejo del sistema
 */
public class Administrador extends Persona
{
    /**
     * Constructor único de la clase constructor
     * @param usuario
     * @param edad
     * @param creacion
     * @param contrasena
     */
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
    /**
     * Creación de nueva cuenta por parte de un administrador 
     * @param planilla
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     */
    public void crearCuenta(String planilla)
    throws IOException, ClassNotFoundException, FileNotFoundException
    {
        boolean novalido = true;
        String usuario, contrasena;
        Scanner inp = new Scanner(System.in);
        int edad = 0,tipochar = 0;
        char tipo = ' ';
        File formato = null;
        ObjectOutputStream oos = null;
        System.out.println("Ingrese su nombre de usuario: ");
        usuario=inp.next();
        System.out.println("Ingrese la contraseña: ");
        contrasena=inp.next(); //Lectura de datos de nueva cuenta
        Date dat= new Date();
        System.out.println("Ingrese la edad del usuario: ");
        edad=inp.nextInt();
        do  //Ciclo de validación de tipo a crear
        {
            System.out.println("+-------------------------------------+");
            System.out.println("|         MENÚ Tipo de Persona        |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 1) Administrador                    |");
            System.out.println("| 2) Profesor                         |");
            System.out.println("| 3) Estudiante                       |");
            System.out.println("+-------------------------------------+");
            tipochar=inp.nextInt();
            switch(tipochar)  //Asignación de tipo
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
        Persona persona = new Persona(usuario, edad, dat, contrasena,tipo);  //Creación de nueva persona (Constructor protegido)
        formato = new File(planilla); //Apertura de flujo
        if(formato.length()==0 || !formato.exists() )  //Si el archivo está vació o no existe
        {
            oos= new ObjectOutputStream(new FileOutputStream(formato));
            oos.writeObject(persona);  //Escritura en modo write
        }
        else
        {
            super.guardadoEnArchivo(planilla, persona); // Escritura en modo append
        }
        oos.close();
        inp.close(); //cierre de fuljos
    }
    /**
     * Crear una asignatura con plantilla(cuando se conoce profesor y estudiantes)
     * @param profe
     * @param estudiante
     * @param cantidadestudiantes
     * @param archivo
     */
    public void CrearUnaAsignatura(String ListaAsignaturas, String planilla)
    {
        {
            boolean bandera = true;
            int con = 0;
            Scanner in = new Scanner(System.in);
            Persona adquirido = null;
            FileInputStream asg = null; 
            ObjectInputStream ng = null;
            String nombreAsignatura={" "};
            int CantiCredi;
            char tip ='p';
            System.out.println("Digite el nombre del profesor ");
            String comprobar= in.nextLine();
            try
            {
                asg = new FileInputStream(planilla);
                ng = new ObjectInputStream(asg);
                while(bandera)
                {
                    adquirido = (Persona)ng.readObject();
                    if(adquirido.getTipo().equals(tipo))
                    {
                        ng.close();
                        for(int i=0;i<planilla.length(); i++)
                        {
                            if(adquirido.getUsuario().equals(comprobar))
                            {
                                System.out.println("Conseguido:...");
                                bandera = true;
                                break;
                            }
                            System.out.println("Nombre no encontrado...\nDigite nuevamente: ");
                            comprobar = in.nextLine();
                            bandera = false;
                            i++;
                        }
                        ng.close();
                        if(bandera)
                        {
                            System.out.println("Profesor es Valido...");
                            System.out.println("Ingrese Nombre de la asignatura ");
                            nombreAsignatura=in.nextLine();
                            System.out.println("Ingrese la cantidad de creditos de la asignatura ");
                            CantiCredi=in.nextInt();
                            Asignatura asignatura= new Asignatura(nombreAsignatura,comprobar,CantiCredi);
                            Fiis = new FileInputStream(ListaAsignaturas);
                            Oiis = new ObjectInputStream(Fiis);
                            Oiis.writeObject(asignatura);    
                            Oiis.close();
                        }
                        else
                        {
                            System.out.println("Fallo en la validación, no existe el profesor...");
                            return null;
                        }   
                    }
                }
                ng.close();
            }
            catch (EOFException eof) //Excepción de lectura completa de archivo
            {
                System.out.println("Se ha finalizado la lectura del archivo");
            }
            catch (ClassNotFoundException cnfe)  //Error en caso de clase inexistente o no encontrada
            {
                System.out.println("Ha ocurrido un problema con la definición de la clase");
            }
            catch (FileNotFoundException fnfe)  //Error con el archivo en ruta especificada
            {
                System.out.println("No se ha encontrado el archivo.");
            }
            catch (IOException io)  //Error con el flujo de entrada y salida
            {
                System.out.println("Error en el flujo del sistema");
            }
            catch (Exception e)  //Manejo de otras excepciones
            {
                System.out.println("Ha ocurrido una imprevisto: " + e.getMessage());
            }
            finally
            {
                System.out.println("Lectura finalizada");
            }
            return adquirido;
        }
}
