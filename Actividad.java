package modelo;
import competencias.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Actividad{

  //Atributos
  protected ArrayList<Carrera> carreras;
  protected ArrayList<Participante> listaParticipantes;
  protected ArrayList<Participante> listaGanadores;
  protected Lectura Texto_Estudiantes;
  protected ArrayList<Estudiante> lista_estudiantes;

  //Constructor

  public Actividad(){
    Texto_Estudiantes= new Lectura();
    Texto_Estudiantes.cargarEstudiantes();
    lista_estudiantes=Texto_Estudiantes.getListaEstudiantes();
    carreras= new ArrayList<Carrera>();
    listaParticipantes=new ArrayList<Participante> ();
    listaGanadores =new ArrayList<Participante>();
  }
  

  Scanner sc=new Scanner(System.in);

//Metodo que muestra todas las carreras Activas
  public void mostrarCarreras(){
    System.out.println("\n::::::CARRERAS ACTIVAS::::::");
    System.out.println("Id"+"\tFecha"+"\t\tHora"+"\tNo.Participantes" );
    for (Carrera c : carreras){
      if (c.getActiva()){
       System.out.println(c);
      }
    }
  }

  public Carrera llenarLista(int verificador, Carrera buscada){
    String id="1";
    while (!(id.equals("0")) && verificador==1){
      System.out.print("\nIngrese ID del estudiante: ");
      id=sc.next();
      boolean verificador1 =true;
      boolean ver2=true;
      for (Estudiante f: buscada.getParticipantes()){
        if (id.equals(f.getId())){
          System.out.println("El estudiante ya se encuentra en la lista de Participantes.");
          ver2 =false;
        }
      }
      for (Estudiante e:lista_estudiantes){
        if (id.equals(e.getId())){
          Participante5k novato=new Participante5k(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera(),0.0f);
          System.out.println("Estudiante "+e.getNombre()+" registrado");
          buscada.getParticipantes().add(novato) ;
          verificador1=false;
        }
      }
      if (verificador1 && ver2){
        System.out.println("\n====>Estudiante no encontrado");
      }
      }
      return buscada;
  }

  public void buscarCarrera(){
    System.out.print("\nIngrese ID de la carrera a editar: ");
    String idc=sc.next();
    int verificador =0;
    Carrera buscada=new Carrera();
    for (int i = 0; i < carreras.size(); i++) {
      if (idc.equals(carreras.get(i).id)) {
        System.out.println("\nRegistro de participantes en carrera del "+carreras.get(i).fecha);
        buscada=carreras.get(i);
        verificador=1 ;
        }
      }
    if (verificador ==0){
      System.out.println("\n====>Carrera no encontrada");
    }
    llenarLista(verificador,buscada);

  }
