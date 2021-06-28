package competencias;
import modelo.*;
import java.util.ArrayList;
public class Carrera{
  public String id;
  public String fecha;
  public String hora;
  public ArrayList<Participante5k> participantes;
  public ArrayList<Participante5k> ganadores;
  public boolean activa;

  // Constructores
  public Carrera(){}

  public Carrera(String id,String fecha,String hora,ArrayList<Participante5k> participantes,ArrayList<Participante5k> ganadores,boolean a){
    this.id=id;
    this.fecha=fecha;
    this.hora=hora;
    this.participantes=participantes;
    this.ganadores=ganadores;
    this.activa=a;
  }
  
  public String getId(){
    return id;
  }
  public ArrayList<Participante5k> getParticipantes() {
    return participantes;
  }
  public ArrayList<Participante5k> getGanadores() {
    return ganadores;
  }
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
