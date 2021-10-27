package Persona;
//--------------------importaciones y librerías------------------
import java.util.Date;

/**
 * Clase que posee los atributos básicos de una persona natural
 */
public class Persona 
{
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected Date creacion;
    /**
     * Constructor completo de la clase Persona
     * @param nombre
     * @param apellido
     * @param edad
     * @param creacion
     */
    public Persona(String nombre, String apellido, int edad, Date creacion)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.creacion = creacion;
    }
}
