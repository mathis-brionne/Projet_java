
package model;

/**
 * The type Promotion.
 */
public class Promotion {
  private int id_promotion = 0;
  private String nom = "";


    /**
     * Instantiates a new Promotion.
     *
     * @param id_promotion the id promotion
     * @param nom          the nom
     */
    public Promotion(int id_promotion, String nom ) {
    this.id_promotion = id_promotion;
    this.nom=nom;
    
    System.out.println(id_promotion);
    System.out.println(nom);

  }

    /**
     * Instantiates a new Promotion.
     */
    public Promotion(){};

    /**
     * Gets id promotion.
     *
     * @return the id promotion
     */
    public int getId_Promotion() {
    return id_promotion;
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
