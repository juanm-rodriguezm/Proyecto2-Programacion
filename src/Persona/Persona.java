package Persona;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
//--------------------importaciones y librerías------------------
import java.util.Date;
import java.util.Scanner;

/**
 * Clase que posee los atributos básicos de una persona natural
 */
public class Persona implements Serializable
{
    protected String usuario;
    protected String contrasena;
    protected int edad;
    protected Date creacion;
    protected char tipo;
    /**
     * Constructor único de la clase Persona
     * @param usuario
     * @param edad
     * @param creacion
     * @param contrasena
     */
    public Persona(String usuario, int edad, Date creacion, String contrasena)
    {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.edad = edad;
        this.creacion = creacion;
    }
    public Persona(String usuario, int edad, Date creacion, String contrasena, char tipo)
    {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.edad = edad;
        this.creacion = creacion;
        this.tipo = tipo;
    }
     public String getUsuario() {
        return usuario;
    }
    /**
     * Set para fijar el nombre del usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Obtener el nombre del usuario
     * @return contrasena
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Set para modificar las contraseñas del usuario
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    /**
     * Obtener la edad del usuario
     * @return
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Set para modificar la edad del usuario
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * Obtener la fecha cuando fue creada la cuenta del usuario
     * @return
     */
    public Date getCreacion() {
        return creacion;
    }
    /**
     * Set para modificar la fecha de cracion de la cuenta del usuario
     * @param creacion
     */
    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
    /**
     * Obtener el tipo de cuenta del usuario
     * @return 
     */
    public char getTipo() {
        return tipo;
    }
    /**
     * Método para la escritura de una persona en un archivo
     * @param archivo
     * @param colaborador
     * @throws IOException
     */
    public static void guardadoEnArchivo(String archivo, Persona colaborador) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(archivo,true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(colaborador);
        oos.close();
        return;
    }
    /**
     * Lectura de archivo de usuario para cargar login
     * @param archivo
     * @param usuario
     * @return Persona leida  o null en caso no encontrado
     */
    public static Persona leerEnArchivo(String archivo, String usuario)
    {
        boolean bandera = true;
        Persona adquirido = null;
        FileInputStream fos = null; 
        ObjectInputStream oos = null;
        try 
        {//En esta función cargamos las dos variables y generamos una bandera para entrar a un ciclo infinito 
        //comparanado los archivos con el que nos acaban de dar con los que tenemos en los archivos
            fos = new FileInputStream(archivo);
            oos = new ObjectInputStream(fos);
            while(bandera)
            {
                adquirido = (Persona)oos.readObject();
                if( adquirido.getUsuario() == usuario )
                {
                    oos.close();
                    return adquirido;
                }
            }
            oos.close();
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
    /**
     * Lectura de archivo de usuario para cargar usuario tras validación de contraseña
     * @param archivo
     * @param usuario
     * @param contrasena
     * @return Persona validada o null si no es encontrado o contraseña incorrecta
     */
    public static Persona leerEnArchivo(String archivo, String usuario, String contrasena)
    {
        boolean bandera = true;
        int con = 0;
        Scanner inp = new Scanner(System.in);
        Persona adquirido = null;
        FileInputStream fos = null; 
        ObjectInputStream oos = null;
        try
        {
            fos = new FileInputStream(archivo);
            oos = new ObjectInputStream(fos);
            while(bandera)
            {
                adquirido = (Persona)oos.readObject();
                if( adquirido.getUsuario().equals(usuario))
                {
                    oos.close();
                    while(con<3)
                    {
                        if(adquirido.getContrasena().equals(contrasena))
                        {
                            bandera = !bandera;
                            break;
                        }
                        System.out.println("Contraseña incorrecta...\nDigite nuevamente: ");
                        contrasena = inp.next();
                        con++;
                    }
                    inp.close();
                    if(bandera)
                    {
                        return adquirido;
                    }
                    else
                    {
                        return null;
                    }
                    
                }
            }
            oos.close();
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
    @Override
    public String toString() 
    {
        String cadena = "";
        cadena = "Usuario: " + this.usuario + "\nContraseña: " + this.contrasena;
        cadena += "\nCreacion: " + this.creacion + "\nTipo: " + this.tipo;
        return cadena;
    }

}
