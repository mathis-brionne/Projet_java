package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * The type Dao utilisateur.
 */
public class DAO_Utilisateur extends DAO {
    private List<Utilisateur> List_User;
    private Connection Conn = null;

    /**
     * Instantiates a new Dao utilisateur.
     */
    public DAO_Utilisateur() {

        try{
            System.out.println("OK");
            Conn = DaoFactory.getInstance().getConnection();

        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_User = new ArrayList<Utilisateur>();
        this.setData();
    }

    /**
     * Gets list user.
     *
     * @return the list user
     */
    public List<Utilisateur> getList_User() {
        return List_User;
    }

    public List<Utilisateur> findq(String nom , String prenom ){
        List<Utilisateur> utilisateur = new ArrayList<>();
        for (Utilisateur i:List_User) {
            if (i.getNom().equals(nom) && i.getPrenom().equals(prenom))
                utilisateur.add(i);
        }
        return utilisateur;
    }

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Utilisateur i: List_User) {
            s += String.format("\nNom :%s \nPrenom :%s \nEmail :%s \nPassword :%s \nId:%d \nDroit :%d\n",i.getNom(),i.getPrenom(),i.getEmail(),i.getPassword(),i.getId(),i.getDroit());
        }
        return s;
    }

    /**
     * Find utilisateur.
     *
     * @param categorie the categorie
     * @param key_Word  the key word
     * @return the utilisateur
     * @throws NullPointerException the null pointer exception
     */
    public Utilisateur find(String categorie, String key_Word) throws NullPointerException {
        switch (categorie)
        {
            case "user":
                for(Utilisateur i: List_User)
                {
                    if(i.getEmail().equals(key_Word))
                    {
                        return i;
                    }
                }
                break;
            case "nom":
                for(Utilisateur i: List_User)
                {
                    if(i.getNom().equals(key_Word))
                    {
                        return i;
                    }
                }
            default:
                System.out.println("");
                break;
        }
        return null;
    }

    /**
     * Find id utilisateur.
     *
     * @param utilisateur the utilisateur
     * @return the utilisateur
     */
    public Utilisateur findId(int utilisateur){

        for(Utilisateur i: List_User)
        {
            if(i.getId() == utilisateur)
            {
                return i;
            }
        }
        return null;
    }

    /**
     * Getname string.
     *
     * @param Id_users the id users
     * @return the string
     */
    public String getname(int Id_users){
        for (Utilisateur u: List_User) {

            if (u.getId()==Id_users){
                return u.getNom();
            }
        }
        return "";
    }
    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM utilisateur";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String email = rs.getString("EMAIL");
                String passwd = rs.getString("PASSWD");
                String nom = rs.getString("NOM");
                String premon = rs.getString("PREMON");
                int droit = rs.getInt("DROIT");
                Utilisateur U = new Utilisateur(id, droit, email, nom, premon, passwd);
                List_User.add(U);
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
    public void delete(Utilisateur user) {
        try {
            String query = "DELETE FROM utilisateur WHERE id = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ user.getId());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update utilisateur.
     *
     * @param user the user
     * @return the utilisateur
     */
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

    /**
     * Create utilisateur.
     *
     * @param user the user
     * @return the utilisateur
     */
    public Utilisateur create(Utilisateur user) {
        try {
            System.out.println(user.getNom());
            System.out.println(user.getEmail());
            String query = "INSERT INTO utilisateur (EMAIL, PASSWD, NOM, PREMON, DROIT) VALUES('"+user.getEmail()+"', '"+user.getPassword()+"', '"+user.getNom()+"', '"+user.getPrenom()+"', '"+user.getDroit()+"')";

            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    /**
     * Get last id int.
     *
     * @return the int
     */
    public int getLastID(){
        int i = 0 ;
        for (Utilisateur a :List_User) {
            if (a.getId()>i){
                i = a.getId();
            }
        }
        return i + 1;
    }


    /**
     * Ajout.
     *
     * @param nouv the nouv
     */
    public void ajout(Utilisateur nouv)
    {
        List_User.add(nouv);
    }

}
