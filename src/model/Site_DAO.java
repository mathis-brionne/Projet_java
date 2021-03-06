package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Site dao.
 */
public class Site_DAO extends DAO {
    private List<Site> List_Site;
    private Connection Conn = null;

    /**
     * Instantiates a new Site dao.
     */
    public Site_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Site = new ArrayList<Site>();
        this.setData();
    }

    /**
     * Gets list site.
     *
     * @return the list site
     */
    public List<Site> getList_Site() {
        return List_Site;
    }

   /* @Override
    public void find(String key_word) {

    }*/

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Site i: List_Site) {
            s += String.format("\nNom :%s \nId:%d \n",i.getNom(),i.getId_Site());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM site";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Site U = new Site(id, nom);
                List_Site.add(U);
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
     * @param s the s
     */
//PAS BESOIN
    public void delete(Site s) {
        try {
            String query = "DELETE FROM site WHERE ID = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ s.getId_Site());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}