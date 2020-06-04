package controler;

import model.*;

public class Prof extends Utilisateur{
    private Planning plannig = new Planning() ;
    public Prof(Utilisateur u){
        super(u.getId(), u.getDroit(),u.getEmail(),u.getNom(),u.getPrenom(),u.getPassword());
        plannig = new Planning(new Seance_Enseignant_DAO().finds(u.getId()));
    }
}
