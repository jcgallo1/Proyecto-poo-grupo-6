import modelo.*;
import java.util.*;
class Main {
  
  public static void main(String[] args) {
    Actividad a1=new Actividad(); // Creamos nuestro objeto actividad que contiene todos los métodos creados.
    a1.cargarInformacion(); // se llama el método de cargarInformacion.
    Scanner sc=new Scanner(System.in);
    String opcion="0";
    while (!(opcion.equals("4"))){
    System.out.println("\n\t\t---------MENÚ---------");
    System.out.println("1. Carrera 5K \n2. Competencia de Bandas musicales\n3. Torneo de videojuegos\n4. Salir");
    System.out.print("\nIngrese opción deseada:\n");
    opcion=sc.nextLine();
    
    if (opcion.equals("1")){
      String opcion2="0";
      while (!(opcion2.equals("3"))){
        System.out.println("\n\t\t---------Menú Carrera 5k---------");
        a1.mostrarCarreras();
        System.out.println("\n\n1. Registrar participantes\n2. Registrar ganadores\n3. Volver al menú principal");
        System.out.print("\nIngrese opción deseada:\n");
        opcion2=sc.nextLine();
        if (opcion2.equals("1")){
          a1.registrarParticipante();// se llama el método de registrarParticipante.
        }
        else if (opcion2.equals("2")){
          a1.registrarGanadores();// se llama el método de registrarGanadores.
        }
        else if (opcion2.equals("3")){
          System.out.print("\n======>Volviendo al menú principal\n ");
        }
        else {
          System.out.print("Opcion incorrecta");
        }
      }
    }
    else if (opcion.equals("2")){
      String op2="0";
       while (!(op2.equals("3"))){
          a1.mostrarMusicales();
          System.out.println("\n1.Crear nueva competencia\n2.Registrar bandas\n3.Volver al menú principal");
          System.out.print("\nIngrese opción deseada:\n");
          op2=sc.nextLine();
          if (op2.equals("1")){
            a1.crearMusical(); // se llama el método de crearMusical.
          }
          else if (op2.equals("2")){
            a1.registrarBandas();// se llama el método de registrarBandas.
          }
          else if (op2.equals("3")){
          System.out.print("\n======>Volviendo al menú principal\n ");
          }
          else {
            System.out.print("Opcion incorrecta ");
          }
       }
    }
    else if (opcion.equals("3")){
      String opcion2="0";
      while (!(opcion2.equals("3"))){
        System.out.println("\n\t\t---------Menú Torneo de videojuegos---------");
        a1.mostrarTorneos();
        System.out.println("\n\n1. Registrar participantes\n2. Registrar ganadores\n3. Volver al menú principal");
        System.out.print("\nIngrese opción deseada:\n");
        opcion2=sc.nextLine();
        if (opcion2.equals("1")){
          a1.registrarParticipanteT();// se llama el método de registrarParticipante de torneo.
        }
        else if (opcion2.equals("2")){
          a1.registrarGanadoresT(); // se llama el método de registrarGanadores de torneo.
        }
        else if (opcion2.equals("3")){
          System.out.print("\n======>Volviendo al menú principal\n ");
        }
        else {
          System.out.print("Opcion incorrecta");
        }
      }
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