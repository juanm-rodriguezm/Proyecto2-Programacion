
package Asignaturas;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
//--------------------importaciones y librerías------------------

import java.util.Scanner;

import Estudiante.Estudiante;
import Persona.Persona;

public class Asignatura implements Serializable
{
    protected String nombre;
    protected String profesor;
    protected int creditos;
    public static final int MS = 15;
    protected Estudiante [] alumnos = new Estudiante [MS];
    /**
     * Constructor de asignatura con los siguientes parámetros:
     * @param Nombre
     * @param Profesor
     * @param Creditos
     */
    public Asignatura(String Nombre, String Profesor, int Creditos)
    {
        this.nombre = Nombre;
        this.profesor = Profesor;
        this.creditos = Creditos;
    }
    /**
     * setter de estudiantes por posición
     * @param pos
     * @param siguiente
     */
    public void setEstudiantes(int pos, Estudiante siguiente)
    {
        this.alumnos[pos] = siguiente;
        return;
    }
    /**
     * Getter del nombre
     * @return
     */
    public String getNombre() 
    {
        return nombre;
    }
    /**
     * Setter del nombre
     * @param nombre
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
        return;
    }
    /**
     * Getter del profesor
     * @return
     */
    public String getProfesor() 
    {
        return profesor;
    }
    /**
     * Setter del profesor
     * @param profesor
     */
    public void setProfesor(String profesor) 
    {
        this.profesor = profesor;
        return;
    }
    /**
     * Getter del numero de créditos
     * @return
     */
    public int getCreditos() 
    {
        return creditos;
    }
    /**
     * Setter de créditos
     * @param creditos
     */
    public void setCreditos(int creditos) 
    {
        this.creditos = creditos;
        return;
    }
    /**
     * Leer un asignatura del archivo de materias disponibles
     * @param archivo
     * @param Profesor
     * @return
     */
    public static Asignatura leerArchivo (String archivo, String Profesor)
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
                if(true)
                {
                    oos.close();
                    /*while(con<3)
                    {
                        if(adquirido.getContrasena().equals(contrasena))
                        {
                            bandera = !bandera;
                            break;
                        }
                        System.out.println("Contraseña incorrecta...\nDigite nuevamente: ");
                        contrasena = inp.next();
                        con++;
                    }*/
                    inp.close();
                    if(bandera)
                    {
                        return null;
                    }
                    else
                    {
                        return null;
                    }
                    
                }
            }
            System.out.println(con);
            System.out.println(adquirido);
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
        return null;
    }
    /**
     * Guardar una asignatura en un archivo de clases
     * @param listado
     * @param tuClase
     * @throws IOException
     */
    public void guardarClaseArchivo(String listado, Asignatura tuClase) throws IOException
    {
        File flujo = new File(listado);
        FileOutputStream fos = new FileOutputStream(flujo, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tuClase);
        oos.close();
        return;
    }
}
