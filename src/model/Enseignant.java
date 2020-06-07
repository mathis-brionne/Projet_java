
package model;

/**
 * The type Enseignant.
 */
public class Enseignant {
  private int id_utilisateur = 0;
  private int id_cours = 0;


    /**
     * Instantiates a new Enseignant.
     *
     * @param id_utilisateur the id utilisateur
     * @param id_cours       the id cours
     */
    public Enseignant(int id_utilisateur,  int id_cours) {
    this.id_utilisateur = id_utilisateur;
    this.id_cours= id_cours;
  }

    /**
     * Instantiates a new Enseignant.
     */
    public Enseignant(){};

    /**
     * Gets id utilisateur.
     *
     * @return the id utilisateur
     */
    public int getId_Utilisateur() {
    return id_utilisateur;
  }

    /**
     * Gets id cours.
     *
     * @return the id cours
     */
    public int getId_cours() {
    return id_cours;
  }
}

