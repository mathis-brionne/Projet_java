package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Salle dao.
 */
public class Salle_DAO extends DAO {
    private List<Salle> List_Salle;
    private Connection Conn = null;

    /**
     * Instantiates a new Salle dao.
     */
    public Salle_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Salle = new ArrayList<Salle>();
        this.setData();
    }

    /**
     * Gets list salle.
     *
     * @return the list salle
     */
    public List<Salle> getList_Salle() {
        return List_Salle;
    }

    /**
     * Finds string.
     *
     * @param Id_salle the id salle
     * @return the string
     */
/* @Override
    public void find(String key_word) {

    }*/
   public String finds(int Id_salle){
       for (Salle s : List_Salle){
           if (s.getId_Salle() == Id_salle){
               return s.getNom();
           }
       }
       return "";
   }

    /**
     * Getsp id int.
     *
     * @param nom the nom
     * @return the int
     */
    public int getspId(String nom){
        for (Salle s : List_Salle){
            if (s.getNom().equals(nom)){
                return s.getId_Salle();
            }
        }
        return 0;
    }

    /**
     * Find salle.
     *
     * @param id the id
     * @return the salle
     */
    public Salle find(int id){
        for(Salle c : List_Salle){
            if(c.getId_Salle() == id){
                return  c;
            }
        }
        return null;
    }

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Salle i: List_Salle) {
            s += String.format("\nId salle:%d \nNom :%s\n Capacite :%d\n Id site :%d\n",i.getId_Salle(),i.getNom(),i.getCapacite(),i.getId_Site());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM salle";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id_salle = rs.getInt("ID");
                String nom = rs.getString("NOM");
                int capacite = rs.getInt("CAPACITE");
                int id_site = rs.getInt("ID_SITE");
                Salle U = new Salle(id_salle,nom,capacite,id_site);
                List_Salle.add(U);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}