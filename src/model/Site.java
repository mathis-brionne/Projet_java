
package model;

public class Site {
  private int id_site = 0;
  private String nom = "";


  public Site(int id_site, String nom ) {
    this.id_site= id_site;
    this.nom=nom;
    
    System.out.println(id_site);
    System.out.println(nom);
  }
  public Site(){};
     
  public int getId_Site () {
    return id_site;
  }

  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }

}

