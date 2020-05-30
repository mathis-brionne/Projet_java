package controler;


import model.DaoFactory;
import model.Enseignant;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Enseignant_DAO extends DAO {
    private List<Enseignant> List_Enseignant;
    private Connection Conn = null;

    public Enseignant_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Enseignant = new ArrayList<Enseignant>();
        this.setData();
    }

    public List<Enseignant> getList_Enseignant() {
        return List_Enseignant;
    }


   /* @Override
    public void find(String key_word) {

    }*/

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Enseignant i: List_Enseignant) {

            s += String.format("\nId_Utilisateur :%d \nId_Groupe :%d \n",i.getId_Utilisateur(),i.getId_Groupe());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM ensignant";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id_utilisateur = rs.getInt("ID_UTILISATEUR");
                int id_groupe = rs.getInt("ID_SEANCE");
                Enseignant U = new Enseignant(id_utilisateur, id_groupe);
                List_Enseignant.add(U);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}