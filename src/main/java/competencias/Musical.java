package competencias;
import modelo.*;
import java.util.ArrayList;

public class Musical{
  protected String id;
  protected String fecha;
  protected String hora;
  protected boolean activa;
  protected ArrayList<String> premios;
  protected ArrayList<Banda> bandas;
  protected ArrayList<Jurado> jurados;
  
  // Constructores de objetos tipo musicales(concurso de bandas musicales).
  public Musical(){
  }

  public Musical(String id,String fecha,String hora,ArrayList<String> premios,ArrayList<Jurado> jurados,boolean activa){
    this.id=id;
    this.fecha=fecha;
    this.hora=hora;
    this.premios=premios;
    this.jurados=jurados;
    bandas=new ArrayList<>(); // se crea un arraylist de bandas.
    this.activa=activa;
  }
  // Métodos getters y setters de los atributos de un musical.
  public String getId(){
    return id;
  }
  public String getFecha(){
    return fecha;
  }
  @Override
  public String toString() {
    return  id+"\t"+fecha+"\t"+hora+"\t"+bandas.size();
  }
  public ArrayList<Banda> getBandas(){
    return bandas;
  }
  public int numBandas(){ // Método que retorna el número de bandas.
    return bandas.size();
  }
  public boolean getActiva() {
    return activa;
  }
  public void setActiva(boolean s){
    activa=s;
  }
}