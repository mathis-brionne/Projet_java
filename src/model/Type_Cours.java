
package model;

public class Type_Cours {
  private int id_type = 0;
  private String nom = "";


  public Type_Cours(int id_type, String nom ) {
    this.id_type= id_type;
    this.nom=nom;
    
    System.out.println(id_type);
    System.out.println(nom);
  }
  public Type_Cours(){};
     
  public int getId_Type() {
    return id_type;
  }

  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }

}

