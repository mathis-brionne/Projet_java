
package model;

/**
 * The type Cours.
 */
public class Cours {
  private int id_cours = 0;
  private String nom = "";


    /**
     * Instantiates a new Cours.
     *
     * @param id_cours the id cours
     * @param nom      the nom
     */
    public Cours(int id_cours, String nom ) {
    this.id_cours= id_cours;
    this.nom=nom;
    
    System.out.println(id_cours);
    System.out.println(nom);
  }

    /**
     * Instantiates a new Cours.
     */
    public Cours(){};

    /**
     * Gets id cours.
     *
     * @return the id cours
     */
    public int getId_Cours() {
    return id_cours;
  }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
    this.id_cours = id;
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
