package modelo;
public class Participante5k extends Estudiante{
  private float tiempo;

  // Constructor de un objeto tipo participante de carrera5K
  public Participante5k(String id, String nombre,char genero, String carrera, float tiempo){
    super(id, nombre,genero,carrera);
    this.tiempo=tiempo;   
  }
  
}