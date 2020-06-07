package controler;

import model.Etudiant;
import model.Etudiant_DAO;
import model.Seance_Groupe_DAO;
import model.Utilisateur;

/**
 * The type Eleve.
 */
public class Eleve extends Utilisateur {
    private Planning plannig = new Planning();
    private int groupe;

    /**
     * Instantiates a new Eleve.
     *
     * @param u the u
     */
    public Eleve(Utilisateur u){
        super(u.getId(), u.getDroit(),u.getEmail(),u.getNom(),u.getPrenom(),u.getPassword());
        groupe = new Etudiant_DAO().find(u.getId());
        plannig = new Planning(new Seance_Groupe_DAO().finds(groupe));
    }

    /**
     * Gets plannig.
     *
     * @return the plannig
     */
    public Planning getPlannig() {
        return plannig;
    }

    /**
     * Gets groupe.
     *
     * @return the groupe
     */
    public int getGroupe() {
        return groupe;
    }
}
