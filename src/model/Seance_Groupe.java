package model;

/**
 * The type Seance groupe.
 */
public class Seance_Groupe {
  private int id_seance = 0;
  private int id_groupe = 0;


    /**
     * Instantiates a new Seance groupe.
     *
     * @param id_seance the id seance
     * @param id_groupe the id groupe
     */
    public Seance_Groupe(int id_seance, int id_groupe) {
    this.id_seance= id_seance;
    this.id_groupe=id_groupe;
    
    System.out.println(id_seance);
    System.out.println(id_groupe);
  }

    /**
     * Instantiates a new Seance groupe.
     */
    public Seance_Groupe(){};

    /**
     * Gets id seance.
     *
     * @return the id seance
     */
    public int getId_Seance() {
    return id_seance;
  }

    /**
     * Gets id groupe.
     *
     * @return the id groupe
     */
    public int getId_Groupe() {
    return id_groupe;
  }

}

