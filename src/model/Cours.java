
package model;

public class Cours {
  private int id_cours = 0;
  private String nom = "";


  public Cours(int id_cours, String nom ) {
    this.id_cours= id_cours;
    this.nom=nom;
    
    System.out.println(id_cours);
    System.out.println(nom);
  }
  public Cours(){};
     
  public int getId_Cours() {
    return id_cours;
  }
  public void setId(int id) {
    this.id_cours = id;
  }

  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }


}
