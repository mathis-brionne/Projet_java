
package model;

/**
 * The type Site.
 */
public class Site {
  private int id_site = 0;
  private String nom = "";


    /**
     * Instantiates a new Site.
     *
     * @param id_site the id site
     * @param nom     the nom
     */
    public Site(int id_site, String nom ) {
    this.id_site= id_site;
    this.nom=nom;
    
    System.out.println(id_site);
    System.out.println(nom);
  }

    /**
     * Instantiates a new Site.
     */
    public Site(){};

    /**
     * Gets id site.
     *
     * @return the id site
     */
    public int getId_Site () {
    return id_site;
  }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
    return nom;
  }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
    this.nom = nom;
  }

}

