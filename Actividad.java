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
  // Metodo para registrar participantes
  public void registrarParticipante(){buscarCarrera();}
    
    
    
    public int registrarGanadores(){
      System.out.print("\nIngrese ID de la carrera a editar: ");
      String idc=sc.next();
      int verificador =0;
      Carrera buscada= new Carrera();
      for (int i = 0; i < carreras.size(); i++) {
        if (idc.equals(carreras.get(i).id)) {
          if (carreras.get(i).getParticipantes().size()<3){
            System.out.println("\nLa carrera seleccionada no cuenta con participantes suficientes");
            return -1;
          }
          System.out.println("\nRegistro de ganadores en carrera del "+carreras.get(i).fecha);
          buscada=carreras.get(i);
          verificador=1 ;
          }
        }
      if (verificador ==0){
        System.out.println("\n====>Carrera no encontrada");
      }
      else{
        int n=0;
        boolean ver;
        boolean ver2;
        while (n<3){
          ver=true;
          ver2=true;
          System.out.println("\nIngreso del "+(n+1)+" lugar: ");
          System.out.print("ID del estudiante: ");
          String id=sc.next();
          for (Estudiante f: buscada.getGanadores()){
                if (id.equals(f.getId())){
                  System.out.println("El estudiante ya se encuentra en la lista de Ganadores.");
                  ver2 =false;
                }
            }
          for (Estudiante e: buscada.getParticipantes()){
            if (id.equals(e.getId()) && (ver2)){
              ver=false;
              System.out.print("Tiempo: ");
              float t=sc.nextFloat();
              Participante5k novato= new Participante5k(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera(),t);
              System.out.println("\nEstudiante "+e.getNombre()+" registrado");
              buscada.getGanadores().add(novato) ;
              n+=1;
            }
          }
          if (ver && ver2){
            System.out.print("El estudiante no existe en la lista de participantes");
          }
        }
        buscada.setActiva(false);

      }
    return 1;  
    }
    public void cargarInformacionCarreras(){
    
      String d="27/6/2021";
      String h="09:00";
      ArrayList<Participante5k> p=new ArrayList<Participante5k>();
      ArrayList<Participante5k> g=new ArrayList<Participante5k>();
      Carrera c=new Carrera("1",d,h,p,g,true);
      carreras.add(c);
      

      d="29/11/2021";
      h="10:00";
      ArrayList<Participante5k> p2=new ArrayList<Participante5k>();
      ArrayList<Participante5k> g2=new ArrayList<Participante5k>();
      Carrera c2=new Carrera("2",d,h,p2,g2,true);
      carreras.add(c2);
    }
  }
