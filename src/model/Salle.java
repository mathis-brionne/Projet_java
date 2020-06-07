
package model;

/**
 * The type Salle.
 */
public class Salle {
  private int id_salle = 0;
  private String nom = "";
  private int capacite = 0;
  private int id_site = 0;


    /**
     * Instantiates a new Salle.
     *
     * @param id_salle the id salle
     * @param nom      the nom
     * @param capacite the capacite
     * @param id_site  the id site
     */
    public Salle(int id_salle, String nom , int capacite, int id_site) {
    this.id_salle= id_salle;
    this.nom=nom;
    this.capacite=capacite;
    this.id_site=id_site;
  }

    /**
     * Instantiates a new Salle.
     */
    public Salle(){};

    /**
     * Gets id salle.
     *
     * @return the id salle
     */
    public int getId_Salle () {
    return id_salle;
  }

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

    /**
     * Gets capacite.
     *
     * @return the capacite
     */
    public int getCapacite() {
    return capacite;
  }

    /**
     * Sets capacite.
     *
     * @param capacite the capacite
     */
    public void setCapacite(int capacite) {
    this.capacite = capacite;
  }

}

