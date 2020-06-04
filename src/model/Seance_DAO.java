package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Seance_DAO extends DAO{

    private List<Seance> List_Seance;
    private Connection Conn = null;

    public Seance_DAO() {
        try{
            Conn = DaoFactory.getInstance().getConnection();
        }
        catch(SQLException SQLe){
            SQLe.getErrorCode();
        }
        List_Seance = new ArrayList<Seance>();
        this.setData();
    }
    public Seance finds(int semaine , int Id_seance){
        Seance result = new Seance() ;
        for (Seance l: List_Seance) {
            if(l.getSemaine() == semaine && Id_seance == l.getId_Seance()){
                result = l;
            }
        }
        return result;
    }

    public List<Seance> getList_Seance() {
        return List_Seance;
    }

   /* @Override
    public void find(String key_word) {

    }*/

    @Override
    public String toString()throws NullPointerException {
        String s =null;
        for (Seance i: List_Seance) {
            s += String.format("\nid_seance :%d \nsemaine :%d \nheure_debut :%d \nheure_fin :%d \netat:%d \nid_cours :%d \nid_type :%d\n",i.getId_Seance(),i.getSemaine(),i.getHeure_Debut(),i.getHeure_Fin(),i.getEtat(),i.getId_Cours(),i.getId_Type());
        }
        return s;
    }


    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM seance ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id_seance = rs.getInt("ID");
                int semaine = rs.getInt("SEMAINE");
                /// DATE
                String heure_debut = rs.getString("HEURE_DEBUT");
                String heure_fin = rs.getString("HEURE_FIN");
                int etat = rs.getInt("ETAT");
                int id_cours = rs.getInt("ID_COURS");
                int id_type = rs.getInt("ID_TYPE");
                Seance S = new Seance(id_seance, semaine, heure_debut, heure_fin, etat, id_cours, id_type);
                List_Seance.add(S);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
