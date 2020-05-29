
package model;

public class Enseignant {
  private int id_utilisateur = 0;
  private int id_groupe = 0;


  public Enseignant(int id_utilisateur,  int id_groupe) {
    this.id_utilisateur = id_utilisateur;
    this.id_groupe= id_groupe;
    
    System.out.println(id_utilisateur);
    System.out.println(id_groupe);
  }
  public Enseignant(){};
     
  public int getId_Utilisateur() {
    return id_utilisateur;
  }

  public int getId_Groupe() {
    return id_groupe;
  }
}

