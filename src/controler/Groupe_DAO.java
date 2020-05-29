
package controler;
import model.DaoFactory;
import model.Groupe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Groupe_DAO extends DAO {
    private List<Groupe> List_Group;
    private Connection Conn = null;

    public Groupe_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Group = new ArrayList<Groupe>();
        this.setData();
    }

    public List<Groupe> getList_Group() {
        return List_Group;
    }

    @Override
    public void find(String key_Word) {
    }

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Groupe i: List_Group) {
            s += String.format("\nId groupe :%d \nNom :%s \nId promotion:%d \n",i.getId_Groupe(),i.getNom(),i.getId_Promotion());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM groupe";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                int id_promo = rs.getInt("ID_PROMOTION");
                Groupe U = new Groupe(id, nom, id_promo);
                List_Group.add(U);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}