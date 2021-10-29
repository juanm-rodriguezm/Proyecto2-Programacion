package Persona;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
//--------------------importaciones y librerías------------------
import java.util.Date;

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
    /**
     * Método para la escritura de una persona en un archivo
     * @param archivo
     * @param colaborador
     * @throws IOException
     */
    public void guardadoEnArchivo(String archivo, Persona colaborador) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(archivo,true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(colaborador);
        oos.close();
        return;
    }
    public Persona leerEnArchivo(String archivo)
    {
        Persona adquirido = null;
        FileInputStream fos = null; 
        ObjectInputStream oos = null;
        try
        {
            fos = new FileInputStream(archivo);
            oos = new ObjectInputStream(fos);
            adquirido = (Persona)oos.readObject();
        }
        catch (Exception e)
        {
            System.out.println("Mi error....");
        }
        finally
        {
            //oos.close();
        }
        return adquirido;
    }
}
