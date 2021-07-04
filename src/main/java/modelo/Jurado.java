package modelo;
public class Jurado extends Participante{ //Registrar informacion de un objeto Jurado, para ser usado en otro momento
  protected String biografia;

  // Constructor de un objeto tipo jurado.
  public Jurado(String id, String nombre, String biografia){
    super(id, nombre);
    this.biografia=biografia;
  }
}