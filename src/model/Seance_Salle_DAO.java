package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Seance salle dao.
 */
public class Seance_Salle_DAO extends DAO {
    private List<Seance_Salle> List_Seance_Salle;
    private Connection Conn = null;

    /**
     * Instantiates a new Seance salle dao.
     */
    public Seance_Salle_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Seance_Salle = new ArrayList<Seance_Salle>();
        this.setData();
    }

    /**
     * Gets list seance salle.
     *
     * @return the list seance salle
     */
    public List<Seance_Salle> getList_Seance_Salle() {
        return List_Seance_Salle;
    }


    /**
     * Find int.
     *
     * @param id_seance the id seance
     * @return the int
     */
/* @Override
    public void find(String key_word) {

    }*/
    public int find(int id_seance){
        for (Seance_Salle s: List_Seance_Salle) {
            if (s.getId_Seance() == id_seance){
                return s.getId_Salle();
            }
        }
        return 0;
    }
    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Seance_Salle i: List_Seance_Salle) {

            s += String.format("\nId séance :%d \nId salle:%d \n",i.getId_Seance(),i.getId_Salle());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM seance_salle";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id_seance = rs.getInt("ID_SEANCE");
                int id_salle = rs.getInt("ID_SALLE");

                Seance_Salle U = new Seance_Salle(id_seance, id_salle);
                List_Seance_Salle.add(U);
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
     * @param seance the seance
     */
    public void delete(Seance_Salle seance) {
        try {
            String query = "DELETE FROM seance_salle WHERE ID_SEANCE = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ seance.getId_Salle());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Create.
     *
     * @param S the s
     */
    public void create(Seance_Salle S) {
        try {
            String query = "INSERT INTO seance_salle (ID_SALLE, ID_SEANCE) VALUES('"+S.getId_Salle() +"', '"+S.getId_Seance()+"')";
            System.out.println(query);
            Statement st = Conn.createStatement();
            ResultSet rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update seance salle.
     *
     * @param c the c
     * @return the seance salle
     */
    public Seance_Salle update(Seance_Salle c) {
        try {

            String query =     "UPDATE seance_salle SET ID_SALLE = '" + c.getId_Salle() + "'"+
                    " WHERE ID_SEANCE = " + c.getId_Seance();
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }


}