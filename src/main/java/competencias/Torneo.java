package competencias;
import modelo.*;
import java.util.ArrayList;


public class Torneo{
  protected String id;
  protected String fecha;
  protected String hora;
  protected String videojuego;
  protected boolean activa;
  protected ArrayList<Estudiante> participantes;
  protected ArrayList<Estudiante> ganadores;

  // Constructores de objetos tipo torneo ( torneos de videjuegos).
  public Torneo(){
  }

  public Torneo(String id,String fecha,String hora,String videojuego,ArrayList<Estudiante> participantes,ArrayList<Estudiante> ganadores,boolean activa){
    this.id=id;
    this.fecha=fecha;
    this.hora=hora;
    this.videojuego=videojuego;
    this.participantes=participantes;
    this.ganadores=ganadores;
    this.activa=activa;
  }
  
  // Métodos getters y setters de los atributos de un torneo.
  public boolean getActiva() {
    return activa;
  }
  public void setActiva(boolean s){
    activa=s;
  }
  public String getId(){
    return id;
  }
  public String getFecha(){
    return fecha;
  }
  public String getVideojuego(){
    return videojuego;
  }
  public ArrayList<Estudiante> getParticipantes() {
    return participantes;
  }
  public ArrayList<Estudiante> getGanadores() {
    return ganadores;
  }
  // Método toString con la informacion del torneo
  @Override
  public String toString() {
    return  id+"\t"+fecha+"\t"+hora+"\t"+videojuego;
  }
}