
package model;

public class Salle {
  private int id_salle = 0;
  private String nom = "";
  private int capacite = 0;
  private int id_site = 0;


  public Salle(int id_salle, String nom , int capacite, int id_site) {
    this.id_salle= id_salle;
    this.nom=nom;
    this.capacite=capacite;
    this.id_site=id_site;
  }
  public Salle(){};

  public int getId_Salle () {
    return id_salle;
  }
     
  public int getId_Site () {
    return id_site;
  }

  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getCapacite() {
    return capacite;
  }
  public void setCapacite(int capacite) {
    this.capacite = capacite;
  }

}

