
package modelo;
public class Estudiante extends Participante{
  protected String carrera;
  protected char genero;

  // constructor Estudiante
  public Estudiante(String id, String nombre,char genero, String carrera){
    super(id, nombre);
    this.genero=genero;
    this.carrera=carrera;
  }


  // Métodos getters 
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
    // Método toString que retorna el id y nombre del estudiante.
    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
