package controler;


import model.DaoFactory;
import model.Seance_Groupe;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Seance_Groupe_DAO extends DAO {
    private List<Seance_Groupe> List_Seance_Groupe;
    private Connection Conn = null;

    public Seance_Groupe_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Seance_Groupe = new ArrayList<Seance_Groupe>();
        this.setData();
    }

    public List<Seance_Groupe> getList_Seance_Salle() {
        return List_Seance_Groupe;
    }


   /* @Override
    public void find(String key_word) {

    }*/

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Seance_Groupe i: List_Seance_Groupe) {

            s += String.format("\nId séance :%d \nId groupe:%d \n",i.getId_Seance(),i.getId_Groupe());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM seance_groupe";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id_seance = rs.getInt("ID_SEANCE");
                int id_groupe = rs.getInt("ID_GROUPE");

                Seance_Groupe U = new Seance_Groupe(id_seance, id_groupe);
                List_Seance_Groupe.add(U);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}