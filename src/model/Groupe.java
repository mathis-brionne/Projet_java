
package model;

/**
 * The type Groupe.
 */
public class Groupe {
  private int id_groupe = 0;
  private String nom = "";
  private int id_promotion = 0;


    /**
     * Instantiates a new Groupe.
     *
     * @param id_utilisateur the id utilisateur
     * @param nom            the nom
     * @param id_promotion   the id promotion
     */
    public Groupe(int id_utilisateur, String nom , int id_promotion) {
    this.id_groupe = id_utilisateur;
    this.nom=nom;
    this.id_promotion= id_promotion;
    
    System.out.println(id_utilisateur);
    System.out.println(nom);
    System.out.println(id_promotion);
  }

    /**
     * Instantiates a new Groupe.
     */
    public Groupe(){};

    /**
     * Gets id groupe.
     *
     * @return the id groupe
     */
    public int getId_Groupe() {
    return id_groupe;
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
     * Gets id promotion.
     *
     * @return the id promotion
     */
    public int getId_Promotion() {
    return id_promotion;
  }
}
