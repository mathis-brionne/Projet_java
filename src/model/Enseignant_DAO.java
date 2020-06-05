package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Enseignant_DAO extends DAO {
    private List<Enseignant> List_Enseignant;
    private Connection Conn = null;

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

    public List<Enseignant> getList_Enseignant() {
        return List_Enseignant;
    }

    public ArrayList<Integer> finds(int ID_users){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Enseignant E: List_Enseignant) {
            if (ID_users == E.getId_Utilisateur()){
                result.add(E.getId_cours());
            }
        }
        return result;
    }
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