package modelo;
public class Estudiante extends Participante{
  protected String carrera;
  protected char genero;

// Constructor de un objeto tipo estudiante.
  public Estudiante(String id, String nombre,char genero, String carrera){
    super(id, nombre);
    this.genero=genero;
    this.carrera=carrera;
  }


 // Métodos getters de los atributos del objeto estudiante.
  public String getId(){
      return id;
    }
    public String getNombre(){
      return nombre;
    }
    public char getGenero(){
      return genero;
    }
    public String getCarrera(){
      return carrera;
    }
// Método toString que muestra cierta información del estudiante.
    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}