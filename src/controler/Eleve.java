package controler;

import model.Etudiant;
import model.Etudiant_DAO;
import model.Seance_Groupe_DAO;
import model.Utilisateur;

public class Eleve extends Utilisateur {
    private Planning plannig = new Planning();
    private int groupe;
    public Eleve(Utilisateur u){
        super(u.getId(), u.getDroit(),u.getEmail(),u.getNom(),u.getPrenom(),u.getPassword());
        groupe = new Etudiant_DAO().find(u.getId());
        plannig = new Planning(new Seance_Groupe_DAO().finds(groupe));
    }

    public Planning getPlannig() {
        return plannig;
    }

    public int getGroupe() {
        return groupe;
    }
}
