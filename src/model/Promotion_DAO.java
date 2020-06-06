package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Promotion_DAO extends DAO {
    private List<Promotion> List_Promo;
    private Connection Conn = null;

    public Promotion_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Promo = new ArrayList<Promotion>();
        this.setData();
    }

    public List<Promotion> getList_Promo() {
        return List_Promo;
    }

    /* @Override
     public void find(String key_word) {

     }*/
    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Promotion i: List_Promo) {
            s += String.format("\nNom :%s \nId:%d \n",i.getNom(),i.getId_Promotion());
        }
        return s;
    }

    public Promotion find(int id){
        for(Promotion c : List_Promo){
            if(c.getId_Promotion() == id){
                return  c;
            }
        }
        return null;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM promotion";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Promotion U = new Promotion(id, nom);
                List_Promo.add(U);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(Promotion user) {
        try {
            String query = "DELETE FROM promotion WHERE id = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ user.getId_Promotion());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}