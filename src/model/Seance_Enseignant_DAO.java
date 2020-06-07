package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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


   /* @Override
    public void find(String key_word) {

    }*/
    public ArrayList<Integer> finds(int Id_users){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Seance_Enseignant a :List_Seance_Enseignant) {
            if (a.getId_Enseignant() == Id_users){
                result.add(a.getId_Seance());
            }
        }
        return result ;
    }
    public int find(int Id_Seance){
        for (Seance_Enseignant a :List_Seance_Enseignant) {
            if (a.getId_Enseignant() == Id_Seance){
                return a.getId_Enseignant();
            }
        }
        return 0 ;
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

    public void delete(Seance_Enseignant seance) {
        try {
            String query = "DELETE FROM seance_ensignants WHERE ID_SEANCE = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ seance.getId_Seance());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void create(Seance_Enseignant S){
        try {
            String query = "INSERT INTO seance_ensignants (ID_SEANCE, ID_ENSEIGNANT) VALUES('"+S.getId_Seance()+"', '"+S.getId_Enseignant()+"' )";
            System.out.println(query);
            Statement st = Conn.createStatement();
            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Seance_Enseignant update(Seance_Enseignant c) {
        try {

            String query =     "UPDATE seance_enseignants SET ID_ENSEIGNANT = '" + c.getId_Enseignant() + "'"+
                    " WHERE ID = " + c.getId_Seance();
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

}