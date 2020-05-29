package model;

public class Seance_Groupe {
  private int id_seance = 0;
  private int id_groupe = 0;


  public Seance_Groupe(int id_seance, int id_groupe) {
    this.id_seance= id_seance;
    this.id_groupe=id_groupe;
    
    System.out.println(id_seance);
    System.out.println(id_groupe);
  }
  public Seance_Groupe(){};
     
  public int getId_Seance() {
    return id_seance;
  }

  public int getId_Groupe() {
    return id_groupe;
  }

}

