package controler;

import model.DaoFactory;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Utilisateur extends DAO {
    private List<Utilisateur> List_User;
    private Connection Conn = null;

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

    public List<Utilisateur> getList_User() {
        return List_User;
    }

    @Override
    public void find(String key_Word) {
    }

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Utilisateur i: List_User) {
            s += String.format("\nNom :%s \nPrenom :%s \nEmail :%s \nPassword :%s \nId:%d \nDroit :%d\n",i.getNom(),i.getPrenom(),i.getEmail(),i.getPassword(),i.getId(),i.getDroit());
        }
        return s;
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


}
