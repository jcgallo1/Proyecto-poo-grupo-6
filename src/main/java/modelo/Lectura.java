package modelo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Lectura {

    public ArrayList<Estudiante> listaEstudiantes;

    public Lectura() {//crea la lista
        listaEstudiantes = new ArrayList<>();
    }
    @Override
    public String toString() { // Método toString para presentar la lista de estudiantes.
        return "Lista"+listaEstudiantes;
    }
    public ArrayList<Estudiante> getListaEstudiantes() {//Get de la lista de estudiantes
        return listaEstudiantes;
    }
    //Método que carga el archivo donde se encuentra la informacion de los estudiantes.
    public void cargarEstudiantes() {
        //se crea inputstream con el metodo getresourceastream para que funcione con el jar
        InputStream input = getClass().getClassLoader().getResourceAsStream("archivos/ESTUDIANTES.csv");

        
        BufferedReader br = null;
        try {
            String linea = null;
            br = new BufferedReader(new InputStreamReader(input));
            linea = br.readLine();//saltar la primera linea
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(",");//separar los datos por coma
                //crear objeto y agregar a la lista
                listaEstudiantes.add(new Estudiante(info[0],info[1],info[2].charAt(0),info[3]));
                        
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        } finally {
            try {
                if (br!=null)
                br.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el archivo");
            }
        }
        
   
    }
    //public static void main(String[] args) {
        //crear el objeto para cargar los estudiantes a la lista
        //Lectura ej = new Lectura();
        //ej.cargarEstudiantes();
        //System.out.println(ej.listaEstudiantes);
    //}
}
