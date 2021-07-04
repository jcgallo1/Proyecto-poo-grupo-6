package modelo;
import java.util.ArrayList;
public class Banda extends Participante{
  protected String cancion;
  protected ArrayList<IntegranteBanda> integrantes;
  
  // Constructor de un objeto tipo banda.
  public Banda (String id, String nombre,String c,ArrayList<IntegranteBanda> i ){
    super(id, nombre);
    cancion=c;
    integrantes=i;
  }
  
  // Métodos getters de los atributos de una banda.
  public String getId(){
    return id;
  }
  public String getNombre(){
    return nombre;
  }
  public ArrayList<IntegranteBanda> getIntegrantes(){
    return integrantes;
  }
  // Método toString que muestra infomación de la banda.
  @Override
  public String toString() {
    return  id+"\t"+nombre;
  }
}