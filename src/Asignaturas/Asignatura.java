/*
package Asignaturas;
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

public class Asignatura implements Serializable
{
    protected String Nombre;

    protected String Profesor;
    protected int Horario;
    protected int Creditos;

    public Asignatura(String Nombre, String Profesor, int Horario, int Creditos)
    {
        this.Nombre = Nombre;
        this.Profesor = Profesor;
        this.Horario = Horario;
        this.Creditos = Creditos;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getProfesor() {
        return Profesor;
    }

    public void setProfesor(String profesor) {
        Profesor = profesor;
    }

    public int getHorario() {
        return Horario;
    }

    public void setHorario(int horario) {
        Horario = horario;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int creditos) {
        Creditos = creditos;
    }
    public static Asignatura leerArchivo (String archivo, String Profesor,  )
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
*/