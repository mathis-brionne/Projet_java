package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Etudiant dao.
 */
public class Etudiant_DAO extends DAO {
    private List<Etudiant> List_Etudiant;
    private Connection Conn = null;

    /**
     * Instantiates a new Etudiant dao.
     */
    public Etudiant_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Etudiant = new ArrayList<Etudiant>();
        this.setData();
    }

    /**
     * Gets list etudiant.
     *
     * @return the list etudiant
     */
    public List<Etudiant> getList_Etudiant() {
        return List_Etudiant;
    }

    /**
     * Find int.
     *
     * @param ID_utilisateur the ID_utilisateur
     * @return the int
     */
//find un etudiant - > find un utilisateur
   /* @Override
    public void find(String key_word) {

    }*/
   public int find(int ID_utilisateur){
       int A = - 1 ;
       for (Etudiant i: List_Etudiant) {
           if(ID_utilisateur ==i.getId_Utilisateur()){
               A = i.getId_Groupe() ;
           }
       }
       return A ;
   }

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Etudiant i: List_Etudiant) {
            s += String.format("\nId Utilisateur:%d \nNumero :%d\n Id Groupe :%d\n",i.getId_Utilisateur(),i.getNumero(),i.getId_Groupe());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM etudiant";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id_utilsateur = rs.getInt("ID_UTILISATEUR");
                int numero = rs.getInt("NUMERO");
                int id_groupe = rs.getInt("ID_GROUPE");
                Etudiant U = new Etudiant(id_utilsateur,numero,id_groupe);
                List_Etudiant.add(U);
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
    public void delete(Etudiant user) {
        try {
            String query = "DELETE FROM etudiant WHERE ID = ";
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
        for (Etudiant a :List_Etudiant) {
            if (a.getId_Utilisateur()>i){
                i = a.getId_Utilisateur();
            }
        }
        return i + 1;
    }

    /**
     * Create etudiant.
     *
     * @param user the user
     * @return the etudiant
     */
    public Etudiant create(Etudiant user) {
        try {
            String query = "INSERT INTO etudiant (ID_UTILISATEUR, NUMERO, ID_GROUPE) VALUES('"+user.getId_Utilisateur()+"', '"+user.getNumero()+"', '"+user.getId_Groupe() +"')";

            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
    /*
//IMPOSSIBLE DE UPDATE
    public Utilisateur update(Utilisateur user) {
        try {
            System.out.println(user.getNom());
            System.out.println(user.getEmail());
            String query =     "UPDATE etudiant SET NUMERO = '" + user.getEmail() + "',"+
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