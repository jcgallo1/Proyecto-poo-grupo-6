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

  

 // Método para registrar participantes en una carrera mediante su id de carerra y para esto se usa el metodo llenarLista.
  public void registrarParticipante(){ 
    System.out.print("\nIngrese ID de la carrera a editar:\n");
    String idc=sc.nextLine();
    int verificador =0;
    Carrera buscada=new Carrera();
    for (int i = 0; i < carreras.size(); i++) {
      if (idc.equals(carreras.get(i).getId())) {
        System.out.println("\nRegistro de participantes en carrera del "+carreras.get(i).getFecha());
        buscada=carreras.get(i);
        verificador=1 ;
        }
      }
    if (verificador ==0){ // Validación de que se ingrese el id correcto de una carerra.
      System.out.println("\n====>Carrera no encontrada");
    }
    llenarLista(verificador,buscada);
  }
    
  
  // Método que registra los ganadores en una carrera.
  public int registrarGanadores(){
    System.out.print("\nIngrese ID de la carrera a editar:\n");
    String idc=sc.nextLine();
    Carrera buscada= new Carrera();
    int verificador =0;
    for (int i = 0; i < carreras.size(); i++) {
      if (idc.equals(carreras.get(i).getId())) {
        if (carreras.get(i).getParticipantes().size()<3){ // Validación de participantes suficientes, mínimo 3.
          System.out.println("\nLa carrera seleccionada no cuenta con participantes suficientes");
          return -1;
        }
        System.out.println("\nRegistro de ganadores en carrera del "+carreras.get(i).getFecha());
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
        System.out.println("\nIngreso del "+(n+1)+" lugar:\n");
        System.out.print("ID del estudiante:\n");
        String id=sc.nextLine();
        for (Estudiante f: buscada.getGanadores()){ // Validación para que no hayan 2 ganadores iguales.
              if (id.equals(f.getId())){
                System.out.println("El estudiante ya se encuentra en la lista de Ganadores.");
                ver2 =false;
              }
          }  
        for (Estudiante e: buscada.getParticipantes()){
          if (id.equals(e.getId()) && (ver2)){
            ver=false;
            System.out.print("Tiempo:\n");
            float t=Float.valueOf(sc.nextLine());
            Participante5k novato= new Participante5k(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera(),t);
            System.out.println("\nEstudiante "+e.getNombre()+" registrado");
            buscada.getGanadores().add(novato) ;
            n+=1;
          }
        }
        if (ver && ver2){ // Validación de que el ganador sea un participante.
          System.out.println("El estudiante no existe en la lista de participantes");
        }
      }
      buscada.setActiva(false);

    }
  return 1;  
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




// Método que crea un musical(concurso de bandas musicales) con la informacion requerida del concurso y el jurado.
  public void crearMusical(){
    String pos[]={"Primer","Segundo","Tercer"};
    ArrayList<Jurado> jur=new ArrayList<>();
    ArrayList<String> prem=new ArrayList<>();
    System.out.println("\nCreación de competencia de bandas musicales.");
    System.out.print("\nFecha (dd/mm/yyyy):\n");
    String fecha=sc.nextLine();
    System.out.print("Hora(hh:mm):\n");
    String hora=sc.nextLine();
    for (int i = 0; i <3; i++) { 
      System.out.print("\nPremio del "+pos[i]+" lugar:\n");
      String p=sc.nextLine();
      prem.add(p);
    }
    for (int i = 0; i <3; i++) { 
      System.out.println("\n"+pos[i]+" jurado:\n");
      System.out.print("Id:\n");
      String id=sc.nextLine();
      System.out.print("Nombre:\n");
      String n=sc.nextLine();
      System.out.print("Biografía:\n");
      String b=sc.nextLine();
      Jurado j=new Jurado(id,n,b);
      jur.add(j);
    }
    String codigo =String.valueOf(musicales.size()+1); // generación del id del concurso para cuando
    Musical m=new Musical(codigo,fecha,hora,prem,jur,true);// se cree uno nuevo.
    musicales.add(m);
  }


// Método que registra bandas en los concursos musicales con la información requerida.
  public void registrarBandas(){
    int verificador =0;
    ArrayList<IntegranteBanda> integrantes=new ArrayList<>();
    System.out.print("\nIngrese ID del concurso a editar:\n");
    String idc=sc.nextLine();
    Musical buscada=new Musical();
    
    for (int i = 0; i < musicales.size(); i++) {
      if (idc.equals(musicales.get(i).getId())) {
        buscada=musicales.get(i);
        mostrarBandas(buscada.getBandas());
        System.out.println("\nRegistro de Bandas:\n");
        verificador=1 ;
        }
      }
    if (verificador ==0){ // Validación de que el id del concurso sea correcto.
      System.out.println("\n====>Concurso no encontrado");
    }
    String otra="s";
    while (!(otra.equals("n")) && verificador==1){
      System.out.print("\nIngrese nombre de la banda:\n");
      String nombre=sc.nextLine();
      System.out.print("Cancion a interpretar:\n");
      String cancion=sc.nextLine();
      System.out.print("Ingrese número de integrantes:\n");
      int num=Integer.parseInt(sc.nextLine());
      int i =0;
      while(i<num){
        boolean ver1=true;
        boolean ver2=true;
        System.out.print("\nID Integrante "+(i+1)+":\n");
        String id=sc.nextLine();
        for (Banda b:buscada.getBandas()){ // Validación de que un estudiante no este en varias bandas al mismo tiempo.
          for (IntegranteBanda e:b.getIntegrantes()){
            if (id.equals(e.getId())){
              ver2=false;
              System.out.println("El estudiante ya se encuentra registrado en una banda.");
              ver1=false;
            }
          }
        }
        for (Estudiante e:lista_estudiantes){
          if (id.equals(e.getId()) && (ver2)){
            System.out.println("Estudiante "+e.getNombre()+" registrado");
            System.out.print("Rol(CANTANTE, GUITARRISTA, BAJISTA, BATERISTA, OTRO):\n");
            String rol=sc.nextLine().toUpperCase();
            IntegranteBanda novato=new IntegranteBanda(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera(),RolBanda.valueOf(rol));
            boolean ver3=true;
            for (Banda bn:buscada.getBandas()){
              if (bn.getNombre().equals(nombre)){
                bn.getIntegrantes().add(novato);
                ver3=false;
                ver1=false;
                i++;
              }
            }
            if(ver3){
              integrantes.add(novato) ;
              String codigo =String.valueOf(buscada.getBandas().size()+1);
              Banda b=new Banda(codigo,nombre,cancion, integrantes);
              buscada.getBandas().add(b);
              ver1=false;
              i++;
            }
          }
        }
        if (ver1){ // Validación de que los integrantes de bandas sean estudiantes.
        System.out.println("\n====>Estudiante no encontrado");
        }
      }
      
      System.out.println("\n¿Desea registrar otra banda (s/n)?:\n");
      otra=sc.nextLine();
    }
  }

// Metodo que carga la información respectiva para cada una de las competencias. (2 comptencias activas)
  public void cargarInformacion(){
    //CARRERAS
    String d="30/11/2021";
    String h1="09:00";
    ArrayList<Participante5k> p1=new ArrayList<Participante5k>();
    ArrayList<Participante5k> g1=new ArrayList<Participante5k>();
    Carrera c=new Carrera("1",d,h1,p1,g1,true);
    carreras.add(c);
    d="29/11/2021";
    String h="10:00";
    ArrayList<Participante5k> p2=new ArrayList<Participante5k>();
    ArrayList<Participante5k> g2=new ArrayList<Participante5k>();
    Carrera c2=new Carrera("2",d,h,p2,g2,true);
    carreras.add(c2);




    //TORNEOS 
    ArrayList<Estudiante> p3=new ArrayList<Estudiante>();
    ArrayList<Estudiante> g3=new ArrayList<Estudiante>();
    ArrayList<Estudiante> p4=new ArrayList<Estudiante>();
    ArrayList<Estudiante> g4=new ArrayList<Estudiante>();
    Torneo t1=new Torneo("1",d,h,"Halo",p3,g3,true);
    Torneo t2=new Torneo("2",d,h1,"FIFA 21",p4,g4,true);
    torneos.add(t1);
    torneos.add(t2);

    //BANDAS
    ArrayList<String> pr=new ArrayList<>();
    ArrayList<Jurado> jr=new ArrayList<>();
    ArrayList<String> pr1=new ArrayList<>();
    ArrayList<Jurado> jr1=new ArrayList<>();
    Musical m1= new Musical("1",d,h,pr,jr,true);
    Musical m2= new Musical("2",d,h1,pr1,jr1,true);
    musicales.add(m1);
    musicales.add(m2);
  }
}