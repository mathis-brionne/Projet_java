package model;

import java.rmi.NoSuchObjectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cours_DAO extends DAO {
    private List<Cours> List_Course;
    private Connection Conn = null;

    public Cours_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Course = new ArrayList<Cours>();
        this.setData();
    }

    public List<Cours> getList_Course() {
        return List_Course;
    }
    public String find(int Id_cours){
        for(Cours c : List_Course){
            if(c.getId_Cours() == Id_cours){
                return  c.getNom();
            }
        }
        return "" ;
    }
    /* @Override
     public void find(String key_word) {

     }*/
    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Cours i: List_Course) {
            s += String.format("\nNom :%s \nId:%d \n",i.getNom(),i.getId_Cours());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM cours";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Cours U = new Cours(id, nom);
                List_Course.add(U);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Cours c) {
        try {
            String query = "DELETE FROM utilisateur WHERE id = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ c.getId_Cours());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cours update(Cours c) {
        try {
            System.out.println(c.getNom());

            String query =     "UPDATE cours SET NOM = '" + c.getNom() + "'"+
                    " WHERE ID = " + c.getId_Cours();
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

}
}