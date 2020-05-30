package controler;

import model.Utilisateur;
import view.Login;
import view.application;

public class Main {
    public static void main(String[] args) {


        DAO_Utilisateur Users = new DAO_Utilisateur();
        try{
            System.out.println(Users.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }
        Utilisateur test =new Utilisateur();
        test= Users.find("user","JDOUDI@edu.ece.fr");
        System.out.format("\nNom :%s \nPrenom :%s \nEmail :%s \nPassword :%s \nId:%d \nDroit :%d\n",test.getNom(),test.getPrenom(),test.getEmail(),test.getPassword(),test.getId(),test.getDroit());

        Enseignant_DAO Enseignants = new Enseignant_DAO();
        try{
            System.out.println(Enseignants.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Cours_DAO Cours = new Cours_DAO();
        try{
            System.out.println(Cours.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Etudiant_DAO Etudiant = new Etudiant_DAO();
        try{
            System.out.println(Etudiant.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Groupe_DAO Groupe = new Groupe_DAO();
        try{
            System.out.println(Groupe.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Promotion_DAO Promotion = new Promotion_DAO();
        try{
            System.out.println(Promotion.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Salle_DAO Salle = new Salle_DAO();
        try{
            System.out.println(Salle.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }
        

        Seance_DAO Seance = new Seance_DAO();
        try{
            System.out.println(Seance.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Seance_Enseignant_DAO Seance_Enseignant = new Seance_Enseignant_DAO();
        try{
            System.out.println(Seance_Enseignant.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Seance_Groupe_DAO Seance_Groupe = new Seance_Groupe_DAO();
        try{
            System.out.println(Seance_Groupe.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Seance_Salle_DAO Seance_Salle = new Seance_Salle_DAO();
        try{
            System.out.println(Seance_Salle.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Site_DAO Site = new Site_DAO();
        try{
            System.out.println(Site.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }

        Type_Cours_DAO Type_Cours = new Type_Cours_DAO();
        try{
            System.out.println(Type_Cours.toString());
        }catch (NullPointerException n)
        {
            System.out.println(n.getCause());
            System.out.println("Aucune donnée stocko en mémoire");
        }


       // Login l =new Login();
    }
}
