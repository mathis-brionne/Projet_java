package model;

/**
 * The type Seance salle.
 */
public class Seance_Salle {
  private int id_seance = 0;
  private int id_salle = 0;


    /**
     * Instantiates a new Seance salle.
     *
     * @param id_seance the id seance
     * @param id_salle  the id salle
     */
    public Seance_Salle(int id_seance, int id_salle) {
    this.id_seance= id_seance;
    this.id_salle=id_salle;
    
    System.out.println(id_seance);
    System.out.println(id_salle);
  }

    /**
     * Instantiates a new Seance salle.
     */
    public Seance_Salle(){};

    /**
     * Gets id seance.
     *
     * @return the id seance
     */
    public int getId_Seance() {
    return id_seance;
  }

    /**
     * Gets id salle.
     *
     * @return the id salle
     */
    public int getId_Salle() {
    return id_salle;
  }

}

