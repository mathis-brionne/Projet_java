package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Enseignant dao.
 */
public class Enseignant_DAO extends DAO {
    private List<Enseignant> List_Enseignant;
    private Connection Conn = null;

    /**
     * Instantiates a new Enseignant dao.
     */
    public Enseignant_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Enseignant = new ArrayList<Enseignant>();
        this.setData();
    }
    public int getIDcour(int ID_user)
    {
        for (Enseignant A: List_Enseignant) {
            if (A.getId_Utilisateur()==ID_user)
                return A.getId_cours();
        }
        return 0;
    }
    /**
     * Gets list enseignant.
     *
     * @return the list enseignant
     */
    public List<Enseignant> getList_Enseignant() {
        return List_Enseignant;
    }

    /**
     * Finds array list.
     *
     * @param ID_users the id users
     * @return the array list
     */
    public ArrayList<Integer> finds(int ID_users){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Enseignant E: List_Enseignant) {
            if (ID_users == E.getId_Utilisateur()){
                result.add(E.getId_cours());
            }
        }
        return result;
    }


    //Pour le find d'un enseignant -> find utilisateur

   /* @Override
    public void find(String key_word) {

    }*/





    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Enseignant i: List_Enseignant) {

            s += String.format("\nId_Utilisateur :%d \nId_Groupe :%d \n",i.getId_Utilisateur(),i.getId_cours());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM ensignant";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id_utilisateur = rs.getInt("ID_UTILISATEUR");
                int id_groupe = rs.getInt("ID_Cours");
                Enseignant U = new Enseignant(id_utilisateur, id_groupe);
                List_Enseignant.add(U);
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
    public void delete(Enseignant user) {
        try {
            String query = "DELETE FROM enseignant WHERE id = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ user.getId_Utilisateur());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Get last id int.
     *
     * @return the int
     */
    public int getLastID(){
        int i = 0 ;
        for (Enseignant a :List_Enseignant) {
            if (a.getId_Utilisateur()>i){
                i = a.getId_Utilisateur();
            }
        }
        return i + 1;
    }

    /**
     * Create enseignant.
     *
     * @param user the user
     * @return the enseignant
     */
    public Enseignant create(Enseignant user) {
        try {
            String query = "INSERT INTO ensignant (ID_UTILISATEUR, ID_COURS) VALUES('"+user.getId_Utilisateur()+"', '"+user.getId_cours() +"')";

            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    /*
    //PAS BESOIN DE UPDATE VU QUE C'EST QUE DES ID

    public Utilisateur update(Utilisateur user) {
        try {
            System.out.println(user.getNom());
            System.out.println(user.getEmail());
            String query =     "UPDATE utilisateur SET EMAIL = '" + user.getEmail() + "',"+
                    " PASSWD = '" + user.getPassword() + "',"+
                    " NOM = '" + user.getNom() + "',"+
                    " PREMON = '" + user.getPrenom() + "',"+
                    " DROIT = '" + user.getDroit() + "'"+
                    " WHERE ID = " + user.getId();
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

}

     */


}