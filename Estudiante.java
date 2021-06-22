
package modelo;

public class Estudiante {
    protected String id;
    protected String nombre;
    protected char genero;
    protected String carrera;

    public Estudiante(String id, String nombre, char genero, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    public String getnombre(){
        return this.nombre;
    }
    public String getId(){
        return this.id;
    }
}
