package model;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Seance dao.
 */
public class Seance_DAO extends DAO{

    private List<Seance> List_Seance;
    private Connection Conn = null;

    /**
     * Instantiates a new Seance dao.
     */
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

    /**
     * Finds seance.
     *
     * @param semaine   the semaine
     * @param jours     the jours
     * @param crenaux   the crenaux
     * @param Id_seance the id seance
     * @return the seance
     */
    public Seance finds(int semaine , int jours,int crenaux  , int Id_seance){
        Seance result = new Seance() ;
        for (Seance l: List_Seance) {
            if(l.getSemaine() == semaine && Id_seance == l.getId_Seance() && l.getDate().getDay()-1 == jours && l.getCreaneau() == crenaux ){
                return l;
            }
        }        return result;

    }

    /**
     * Find 2 seance.
     *
     * @param a the a
     * @return the seance
     */
    public Seance find2(int a){
        int A = - 1 ;
        Seance s = new Seance();
        for (Seance i: List_Seance) {

            if(a ==i.getId_Seance()){
                return i;
            }
        }
        return s;
    }

    /**
     * Get last id int.
     *
     * @return the int
     */
    public int getLastID(){
        int i = 0 ;
        for (Seance a :List_Seance) {
            if (a.getId_Seance()>i){
                i = a.getId_Seance();
            }
        }
        return i + 1;
    }

    /**
     * Gets list seance.
     *
     * @return the list seance
     */
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
            ///s += String.format("\nid_seance :%d \nsemaine :%d \nheure_debut :%s \nheure_fin :%s \netat:%d \nid_cours :%d \nid_type :%d\n",i.getId_Seance(),i.getSemaine(),i.getHeure_Debut(),i.getHeure_Fin(),i.getEtat(),i.getId_Cours(),i.getId_Type());
            ///   pb ave la date
            Date indate;
            indate = i.getDate();
            String dateString = null;
            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
            dateString = sdfr.format(indate);

            s += String.format("\nid_seance :%d \nsemaine :%d \nDate:%s \nheure_debut :%s \nheure_fin :%s \netat:%d \nid_cours :%d \nid_type :%d\n",i.getId_Seance(),i.getSemaine(),dateString,i.getHeure_Debut(),i.getHeure_Fin(),i.getEtat(),i.getId_Cours(),i.getId_Type());
        }
        return s;
    }

    /**
     * Find seance.
     *
     * @param id the id
     * @return the seance
     */
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
                Seance S = new Seance(id_seance, semaine,date,a , heure_debut, heure_fin, etat, id_cours, id_type);
                List_Seance.add(S);
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
     * @param seance the seance
     */
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

    /**
     * Update seance.
     *
     * @param user the user
     * @return the seance
     */
    public Seance update(Seance user) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String query =     "UPDATE seance SET SEMAINE = '" + user.getSemaine() + "',"+
                    " DATE = '" + format.format(user.getDate()) + "',"+
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

    /**
     * Add.
     *
     * @param user the user
     */
    public void add(Seance user) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String query =  String.format("INSERT INTO `seance` (`ID`, `SEMAINE`, `DATE`, `HEURE_DEBUT`, `HEURE_FIN`, `ETAT`, `ID_COURS`, `ID_TYPE`) VALUES (%d, '%d', '%s', '%s', '%s', '%d', '%d', '%d');",user.getId_Seance(),user.getSemaine(), format.format(user.getDate()), user.getHeure_Debut() , user.getHeure_Fin() , user.getEtat(), user.getId_Cours() , user.getId_Type()) ;
            System.out.println(query);
            Statement st = Conn.createStatement();
            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Create.
     *
     * @param S the s
     */
    public void create(Seance S) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String query = "INSERT INTO seance (ID, SEMAINE, DATE, HEURE_DEBUT, HEURE_FIN, ETAT, ID_COURS, ID_TYPE) VALUES('"+S.getId_Seance() +"', '"+S.getSemaine()+"', '"+format.format(S.getDate())+"', '"+S.getHeure_Debut()+"', '"+S.getHeure_Fin()+"', '"+ S.getEtat()+"', '"+S.getId_Cours()+"', '"+S.getId_Type()+"')";
            System.out.println(query);
            Statement st = Conn.createStatement();
            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Ajout.
     *
     * @param S the s
     */
    public void ajout(Seance S)
    {
        List_Seance.add(S);
    }

}


