
package model;

public class Groupe {
  private int id_groupe = 0;
  private String nom = "";
  private int id_promotion = 0;


  public Groupe(int id_utilisateur, String nom , int id_promotion) {
    this.id_groupe = id_utilisateur;
    this.nom=nom;
    this.id_promotion= id_promotion;
    
    System.out.println(id_utilisateur);
    System.out.println(nom);
    System.out.println(id_promotion);
  }
  public Groupe(){};
     
  public int getId_Groupe() {
    return id_groupe;
  }

  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getId_Promotion() {
    return id_promotion;
  }
}
