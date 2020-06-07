
package model;

/**
 * The type Type cours.
 */
public class Type_Cours {
  private int id_type = 0;
  private String nom = "";


    /**
     * Instantiates a new Type cours.
     *
     * @param id_type the id type
     * @param nom     the nom
     */
    public Type_Cours(int id_type, String nom ) {
    this.id_type= id_type;
    this.nom=nom;
    
    System.out.println(id_type);
    System.out.println(nom);
  }

    /**
     * Instantiates a new Type cours.
     */
    public Type_Cours(){};

    /**
     * Gets id type.
     *
     * @return the id type
     */
    public int getId_Type() {
    return id_type;
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

