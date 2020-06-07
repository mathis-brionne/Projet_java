package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Promotion dao.
 */
public class Promotion_DAO extends DAO {
    private List<Promotion> List_Promo;
    private Connection Conn = null;

    /**
     * Instantiates a new Promotion dao.
     */
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

    /**
     * Gets list promo.
     *
     * @return the list promo
     */
    public List<Promotion> getList_Promo() {
        return List_Promo;
    }

    /**
     * Getsp id int.
     *
     * @param Nom the nom
     * @return the int
     */
/* @Override
     public void find(String key_word) {

     }*/
    public int getspID(String Nom){
        for (Promotion a : List_Promo) {
            return  a.getId_Promotion();
        }
        return 0;
    }
    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Promotion i: List_Promo) {
            s += String.format("\nNom :%s \nId:%d \n",i.getNom(),i.getId_Promotion());
        }
        return s;
    }

    /**
     * Find promotion.
     *
     * @param id the id
     * @return the promotion
     */
    public Promotion find(int id){
        for(Promotion c : List_Promo){
            if(c.getId_Promotion() == id){
                return  c;
            }
        }
        return null;
    }

    /**
     * Find 2 promotion.
     *
     * @param nom the nom
     * @return the promotion
     */
    public Promotion find2(String nom ){
        for(Promotion c : List_Promo){
            if(c.getNom() == nom){
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

    /**
     * Delete.
     *
     * @param user the user
     */
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