package model;

import java.rmi.NoSuchObjectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Cours dao.
 */
public class Cours_DAO extends DAO {
    private List<Cours> List_Course;
    private Connection Conn = null;

    /**
     * Instantiates a new Cours dao.
     */
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

    /**
     * Gets list course.
     *
     * @return the list course
     */
    public List<Cours> getList_Course() {
        return List_Course;
    }

    /**
     * Find string.
     *
     * @param Id_cours the id cours
     * @return the string
     */
    public String find(int Id_cours){
        for(Cours c : List_Course){
            if(c.getId_Cours() == Id_cours){
                return  c.getNom();
            }
        }
        return "" ;
    }

    /**
     * Getsp id int.
     *
     * @param Nom the nom
     * @return the int
     */
    public int getspId(String Nom){
        for (Cours c: List_Course) {
            if (c.getNom().equals(Nom))
                return c.getId_Cours();
        }
        return 0;
    }

    /**
     * Find 2 cours.
     *
     * @param id_cours the id cours
     * @return the cours
     */
    public Cours find2(int id_cours){
        for(Cours c : List_Course){
            if(c.getId_Cours() == id_cours){
                return  c;
            }
        }
        return null;
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

    /**
     * Delete.
     *
     * @param c the c
     */
    public void delete(Cours c) {
        try {
            String query = "DELETE FROM cours WHERE id = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ c.getId_Cours());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update cours.
     *
     * @param c the c
     * @return the cours
     */
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

    /**
     * Get last id int.
     *
     * @return the int
     */
    public int getLastID(){
        int i = 0 ;
        for (Cours a :List_Course) {
            if (a.getId_Cours()>i){
                i = a.getId_Cours();
            }
        }
        return i + 1;
    }

    /**
     * Create cours.
     *
     * @param user the user
     * @return the cours
     */
    public Cours create(Cours user) {
        try {
            String query = "INSERT INTO cours (ID, NOM) VALUES('"+user.getId_Cours()+"', '"+user.getNom() +"')";

            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }


    /**
     * Ajout.
     *
     * @param c the c
     */
    public void ajout(Cours c)
    {
        List_Course.add(c);
    }

}
