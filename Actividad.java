package modelo;
import competencias.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Actividad{

  //Atributos
  protected ArrayList<Carrera> carreras;
  protected ArrayList<Musical> musicales;
  protected ArrayList<Torneo> torneos;
  protected ArrayList<Participante> listaParticipantes;
  protected ArrayList<Participante> listaGanadores;
  protected Lectura Texto_Estudiantes;
  protected ArrayList<Estudiante> lista_estudiantes;

  //Constructor
  // Se inicializan las listas y competencias respectivas.
  public Actividad(){
    Texto_Estudiantes= new Lectura();
    Texto_Estudiantes.cargarEstudiantes();
    lista_estudiantes=Texto_Estudiantes.getListaEstudiantes();
    carreras= new ArrayList<Carrera>();
    musicales= new ArrayList<Musical>();
    torneos=new ArrayList<Torneo>();
    listaParticipantes=new ArrayList<Participante> ();
    listaGanadores =new ArrayList<Participante>();
  }
  

  Scanner sc=new Scanner(System.in);

//Método que muestra todas las carreras Activas
  public void mostrarCarreras(){
    System.out.println("\n::::::CARRERAS ACTIVAS::::::");
    System.out.println("Id"+"\tFecha"+"\t\tHora"+"\tNo.Participantes" );
    for (Carrera c : carreras){
      if (c.getActiva()){
       System.out.println(c);
      }
    }
  }
  public void mostrarBandas(ArrayList<Banda> bandas){ // Método que muestra las bandas.
    System.out.println("\n::::::BANDAS::::::");
    System.out.println("Id"+"\tNombre" );
    for (Banda b : bandas){
       System.out.println(b);
    }
  }
  public void mostrarMusicales(){ // Método que muestra todos los musicales(concurso de bandas)Activos.
    System.out.println("\n::::::MUSICALES::::::");
    System.out.println("Id"+"\tFecha"+"\t\tHora"+"\tNo.Bandas" );
    for (Musical m : musicales){
      if (m.getActiva()){
       System.out.println(m);
      }
    }
  }
  public void mostrarTorneos(){ // Método que muestra todos los torneos Activos.
    System.out.println("\n::::::TORNEOS::::::");
    System.out.println("Id"+"\tFecha"+"\t\tHora"+"\tVideojuego" );
    for (Torneo t : torneos){
       if (t.getActiva()){
       System.out.println(t);
      }
    }
  }

  public Carrera llenarLista(int verificador, Carrera buscada){ // Método que llena una carrera con los participantes que
    String id="1";                                              // se solicitan mediante elid del estudiante. 
    while (!(id.equals("0")) && verificador==1){
      System.out.print("\nIngrese ID del estudiante:\n");
      id=sc.nextLine();
      boolean verificador1 =true;
      boolean ver2=true;
      for (Estudiante f: buscada.getParticipantes()){
        if (id.equals(f.getId())){ // Validación para que el participante no se duplique en una misma carrera.
          System.out.println("El estudiante ya se encuentra en la lista de Participantes.");
          ver2 =false;
        }
      }
      for (Estudiante e:lista_estudiantes){
        if (id.equals(e.getId()) && (ver2)){
          Participante5k novato=new Participante5k(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera(),0.0f);
          System.out.println("Estudiante "+e.getNombre()+" registrado");
          buscada.getParticipantes().add(novato) ;
          verificador1=false;
        }
      }
      if (verificador1 && ver2 && (!(id.equals("0")))){ 
        System.out.println("\n====>Estudiante no encontrado");
      }
      }
      return buscada;
  }
  // Método que registra los participantes en el torneo de videojuegos(igual al registros de participantes en carreras).
  public void registrarParticipanteT(){
    System.out.print("\nIngrese ID el Torneo a editar:\n");
    String idc=sc.nextLine();
    int verificador =0;
    Torneo buscada=new Torneo();
    for (int i = 0; i < torneos.size(); i++) {
      if (idc.equals(torneos.get(i).getId())) {
        System.out.println("\nRegistro de participantes en el torneo de "+torneos.get(i).getVideojuego());
        buscada=torneos.get(i);
        verificador=1 ;
        }
      }
    if (verificador ==0){ // Validación de que se ingrese el id correcto del torneo.
      System.out.println("\n====>Torneo no encontrado");
    }
    String id="1";
    while (!(id.equals("0")) && verificador==1){
      System.out.print("\nIngrese ID del estudiante:\n");
      id=sc.nextLine();
      boolean verificador1 =true;
      boolean ver2=true;
      for (Estudiante f: buscada.getParticipantes()){
        if (id.equals(f.getId())){ // Validación para que no se dupliquen participantes en un mismo torneo.
          System.out.println("El estudiante ya se encuentra en la lista de Participantes.");
          ver2 =false;
        }
      }
      for (Estudiante e:lista_estudiantes){
        if (id.equals(e.getId()) && (ver2)){
          Estudiante novato=new Estudiante(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera());
          System.out.println("Estudiante "+e.getNombre()+" registrado");
          buscada.getParticipantes().add(novato) ;
          verificador1=false;
        }
      }
      if (verificador1 && ver2 && (!(id.equals("0")))){ // Validacion de que el participante sea un estudiante.
        System.out.println("\n====>Estudiante no encontrado");
      }
      }

  }
  // Método que registra los ganadores de un torneo.(Igual que el métodod de registrar ganadores de una carrera.)
  public int registrarGanadoresT(){ // Se aplican las mismas validaciones en todo el método.
    System.out.print("\nIngrese ID del Torneo a editar:\n");
    String idc=sc.nextLine();
    int verificador =0;
    Torneo buscada= new Torneo();
    for (int i = 0; i < torneos.size(); i++) {
      if (idc.equals(torneos.get(i).getId())) {
        if (torneos.get(i).getParticipantes().size()<3){
          System.out.println("\nEl torneo seleccionado no cuenta con participantes suficientes");
          return -1;
        }
        System.out.println("\nRegistro de ganadores en torneo de "+torneos.get(i).getVideojuego());
        buscada=torneos.get(i);
        verificador=1 ;
        }
      }
    if (verificador ==0){
      System.out.println("\n====>Torneo no encontrado");
    }
    else{
      int n=0;
      boolean ver;
      boolean ver2;
      while (n<3){
        ver=true;
        ver2=true;
        System.out.println("\nIngreso del "+(n+1)+" lugar:\n");
        System.out.print("ID del estudiante:\n");
        String id=sc.nextLine();
        for (Estudiante f: buscada.getGanadores()){
              if (id.equals(f.getId())){
                System.out.println("El estudiante ya se encuentra en la lista de Ganadores.");
                ver2 =false;
              }
          }
        for (Estudiante e: buscada.getParticipantes()){
          if (id.equals(e.getId()) && (ver2)){
            ver=false;
            Estudiante novato= new Estudiante(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera());
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
