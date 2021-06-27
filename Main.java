import modelo.*;
import java.util.*;
class Main {
  
  public static void main(String[] args) {
    Actividad a1=new Actividad();
    a1.cargarInformacionCarreras();
    Scanner sc=new Scanner(System.in);
    String opcion="0";
    while (!(opcion.equals("4"))){
    System.out.println("\n\t\t---------MENÚ---------");
    System.out.println("1. Carrera 5K \n2. Competencia de Bandas musicales\n3. Torneo de videojuegos\n4. Salir");
    System.out.print("\nIngrese opción deseada: ");
    opcion=sc.nextLine();
    
    if (opcion.equals("1")){
      String opcion2="0";
      while (!(opcion2.equals("3"))){
        System.out.println("\n\t\t---------Menú Carrera 5k---------");
        a1.mostrarCarreras();
        System.out.println("\n\n1. Registrar participantes\n2. Registrar ganadores\n3. Volver al menú principal");
        System.out.print("\nIngrese opción deseada: ");
        opcion2=sc.nextLine();
        if (opcion2.equals("1")){
          a1.registrarParticipante();
        }
        else if (opcion2.equals("2")){
          a1.registrarGanadores();
        }
        else if (opcion2.equals("3")){
          System.out.print("\n======>Volviendo al menú principal\n ");
        }
        else {
          System.out.print("Opcion incorrecta ");
        }
      }
    }
    else if (opcion.equals("2")){
      System.out.println("\n1.Crear nueva competencia\n2.Registrar bandas\n3.Volver al menú principal");
      System.out.print("\nIngrese opción deseada: ");
      String op2=sc.next();
      if (op2.equals("1")){}
    
    }
    else if (opcion.equals("3")){
      }
    else if (opcion.equals("4")){
      System.out.print("\n======>Cerrando Programa\n ");
    }
    else {
          System.out.print("Opcion incorrecta ");
        } 
  }  
  } 
}
