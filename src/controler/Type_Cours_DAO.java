package controler;
import model.DaoFactory;

import model.Type_Cours;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Type_Cours_DAO extends DAO {
    private List<Type_Cours> List_Type_Cours;
    private Connection Conn = null;

    public Type_Cours_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Type_Cours = new ArrayList<Type_Cours>();
        this.setData();
    }

    public List<Type_Cours> getList_Type_Cours() {
        return List_Type_Cours;
    }

    @Override
    public void find(String key_Word) {
    }

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Type_Cours i: List_Type_Cours) {
            s += String.format("\nNom :%s \nId:%d \n",i.getNom(),i.getId_Type());
        }
        return s;
    }

    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM type_cours";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("NOM");
                Type_Cours U = new Type_Cours(id, nom);
                List_Type_Cours.add(U);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}