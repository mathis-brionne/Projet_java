package controler;

import model.DaoFactory;
import model.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Etudiant_DAO extends DAO {
    private List<Etudiant> List_Etudiant;
    private Connection Conn = null;

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

    public List<Etudiant> getList_Etudiant() {
        return List_Etudiant;
    }

    @Override
    public void find(String key_Word) {
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
                int id_utilsateur = rs.getInt("ID_UTILSATEUR");
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
}