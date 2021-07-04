package modelo;
public class IntegranteBanda extends Estudiante{
  private RolBanda rol ;
  
  // Constructor de un objet tipo inegrante de banda.
  public IntegranteBanda( String id, String nombre,char genero, String carrera,RolBanda rol){
    super(id, nombre,genero,carrera);
    this.rol= rol;
  }
}