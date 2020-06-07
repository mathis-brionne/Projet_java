package model;

/**
 * The type Seance enseignant.
 */
public class Seance_Enseignant {
  private int id_seance = 0;
  private int id_enseignant = 0;


    /**
     * Instantiates a new Seance enseignant.
     *
     * @param id_seance     the id seance
     * @param id_enseignant the id enseignant
     */
    public Seance_Enseignant(int id_seance, int id_enseignant) {
    this.id_seance= id_seance;
    this.id_enseignant=id_enseignant;
    
    
    System.out.println(id_seance);
    System.out.println(id_enseignant);
  }

    /**
     * Instantiates a new Seance enseignant.
     */
    public Seance_Enseignant(){};

    /**
     * Gets id seance.
     *
     * @return the id seance
     */
    public int getId_Seance() {
    return id_seance;
  }

    /**
     * Gets id enseignant.
     *
     * @return the id enseignant
     */
    public int getId_Enseignant() {
    return id_enseignant;
  }

}