package model;

public class Seance_Salle {
  private int id_seance = 0;
  private int id_salle = 0;


  public Seance_Salle(int id_seance, int id_salle) {
    this.id_seance= id_seance;
    this.id_salle=id_salle;
    
    System.out.println(id_seance);
    System.out.println(id_salle);
  }
  public Seance_Salle(){};
     
  public int getId_Seance() {
    return id_seance;
  }

  public int getId_Salle() {
    return id_salle;
  }

}

