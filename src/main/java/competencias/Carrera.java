package competencias;
import modelo.*;
import java.util.ArrayList;

public class Carrera{
  protected String id;
  protected String fecha;
  protected String hora;
  protected ArrayList<Participante5k> participantes;
  protected ArrayList<Participante5k> ganadores;
  protected boolean activa;

  // Constructores de un objeto tipo carrera.
  public Carrera(){
  }

  public Carrera(String id,String fecha,String hora,ArrayList<Participante5k> participantes,ArrayList<Participante5k> ganadores,boolean a){
    this.id=id;
    this.fecha=fecha;
    this.hora=hora;
    this.participantes=participantes;
    this.ganadores=ganadores;
    this.activa=a;
  }
  
  // Métodos getters y setters de los atributos de una carrera.
  public String getId(){
    return id;
  }
  public String getFecha(){
    return fecha;
  }
  public ArrayList<Participante5k> getParticipantes() {
    return participantes;
  }
  public ArrayList<Participante5k> getGanadores() {
    return ganadores;
  }
  @Override
  public String toString() {
    return  id+"\t"+fecha+"\t"+hora+"\t"+participantes.size();
  }
  public boolean getActiva() {
    return activa;
  }
  
  public void setActiva(boolean s){
    activa=s;
  }

}