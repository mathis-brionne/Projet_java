package controler;


import model.DaoFactory;
import model.Seance_Enseignant;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Seance_Enseignant_DAO extends DAO {
    private List<Seance_Enseignant> List_Seance_Enseignant;
    private Connection Conn = null;

    public Seance_Enseignant_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Seance_Enseignant = new ArrayList<Seance_Enseignant>();
        this.setData();
    }

    public List<Seance_Enseignant> getList_Seance_Enseignant() {
        return List_Seance_Enseignant;
    }


    @Override
    public void find(String key_word) {

    }

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Seance_Enseignant i: List_Seance_Enseignant) {

            s += String.format("\nId groupe :%d \nId promotion:%d \n",i.getId_Enseignant(),i.getId_Seance());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM seance_ensignants";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id_seance = rs.getInt("ID_SEANCE");
                int id_enseignant = rs.getInt("ID_ENSEIGNANT");

                Seance_Enseignant U = new Seance_Enseignant(id_seance, id_enseignant);
                List_Seance_Enseignant.add(U);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}