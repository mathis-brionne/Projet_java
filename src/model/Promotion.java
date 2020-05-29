
package model;

public class Promotion {
  private int id_promotion = 0;
  private String nom = "";


  public Promotion(int id_promotion, String nom ) {
    this.id_promotion = id_promotion;
    this.nom=nom;
    
    System.out.println(id_promotion);
    System.out.println(nom);

  }
  public Promotion(){};
     
  public int getId_Promotion() {
    return id_promotion;
  }

  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
}
