package controler;

import model.*;

/**
 * The type Prof.
 */
public class Prof extends Utilisateur{
    private Planning plannig = new Planning() ;

    /**
     * Instantiates a new Prof.
     *
     * @param u the u
     */
    public Prof(Utilisateur u){
        super(u.getId(), u.getDroit(),u.getEmail(),u.getNom(),u.getPrenom(),u.getPassword());
        System.out.println("------------------>"+ new Seance_Enseignant_DAO().finds(u.getId()));
        plannig = new Planning(new Seance_Enseignant_DAO().finds(u.getId()));
    }

    /**
     * Gets plannig.
     *
     * @return the plannig
     */
    public Planning getPlannig() {
        return plannig;
    }
}
