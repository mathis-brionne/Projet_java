package model;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public Seance finds(int semaine , int jours,int crenaux  , int Id_seance){
        Seance result = new Seance() ;
        for (Seance l: List_Seance) {
            if(l.getSemaine() == semaine && Id_seance == l.getId_Seance() && l.getDate().getDay()-1 == jours && l.getCreaneau() == crenaux ){
                return l;
            }
        }        return result;

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
            s += String.format("\nid_seance :%d \nsemaine :%d \nheure_debut :%s \nheure_fin :%s \netat:%d \nid_cours :%d \nid_type :%d\n",i.getId_Seance(),i.getSemaine(),i.getHeure_Debut(),i.getHeure_Fin(),i.getEtat(),i.getId_Cours(),i.getId_Type());
            ///   pb ave la date         s += String.format("\nid_seance :%d \nsemaine :%d \nDate:%date \nheure_debut :%s \nheure_fin :%s \netat:%d \nid_cours :%d \nid_type :%d\n",i.getId_Seance(),i.getSemaine(),i.getDate(),i.getHeure_Debut(),i.getHeure_Fin(),i.getEtat(),i.getId_Cours(),i.getId_Type());
        }
        return s;
    }

    public Seance find(int id){
        for(Seance c : List_Seance){
            if(c.getId_Seance() == id){
                return  c;
            }
        }
        return null;
    }


    @Override
    public void setData() {
        try {
            String query = "SELECT * FROM seance ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int a = -1 ;
                int id_seance = rs.getInt("ID");
                int semaine = rs.getInt("SEMAINE");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date=null;
                date=  rs.getDate("DATE");
                String heure_debut = rs.getString("HEURE_DEBUT");
                String heure_fin = rs.getString("HEURE_FIN");
                switch (heure_debut){
                    case "08:30:00" : a = 0;
                        break;
                    case "10:15:00" : a= 1;
                        break;
                    case "12:00:00" : a= 2;
                        break;
                    case "13:45:00" : a= 3;
                        break;
                    case "15:30:00" : a= 4;
                        break;
                    case "17:15:00" : a= 5;
                        break;
                    case "19:00:00" : a= 6;
                        break;
                }
                int etat = rs.getInt("ETAT");
                int id_cours = rs.getInt("ID_COURS");
                int id_type = rs.getInt("ID_TYPE");
                int Id_salle = new Seance_Salle_DAO().find(id_seance);
                String cours = new Cours_DAO().find(id_cours);
                String salle = new Salle_DAO().finds(Id_salle);
                String Prof = new DAO_Utilisateur().getname(new Seance_Enseignant_DAO().find(id_seance));
                Seance S = new Seance(id_seance, semaine,date,a , heure_debut, heure_fin, etat, id_cours, id_type,  salle ,  cours , Prof );
                List_Seance.add(S);
            }
            st.close();
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Seance seance) {
        try {
            String query = "DELETE FROM seance WHERE id = ";
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query+ seance.getId_Seance());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Seance update(Seance user) {
        try {
            String query =     "UPDATE utilisateur SET SEMAINE = '" + user.getSemaine() + "',"+
                    " DATE = '" + user.getDate() + "',"+
                    " HEURE_DEBUT = '" + user.getHeure_Debut() + "',"+
                    " HEURE_FIN = '" + user.getHeure_Fin() + "',"+
                    " ETAT = '" + user.getEtat() + "'"+
                    " WHERE ID = " + user.getId_Seance();
            System.out.println(query);
            Statement st = Conn.createStatement();

            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

}


