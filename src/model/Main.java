/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.*;
import java.io.*;


import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 

public class Main {
      
     public static void main(String[] args) {


         /// afficher les users
         /*
         DAO_Utilisateur Users = new DAO_Utilisateur();
         try{
             System.out.println(Users.toString());
         }catch (NullPointerException n)
         {
             System.out.println(n.getCause());
             System.out.println("Aucune donnée stocko en mémoire");
         }
          */


         /// créer un user
          /*
         Utilisateur testcreate = new Utilisateur(0,0,"testcreate@c.com","Math","math","1234");
         Users.ajout(testcreate);
         System.out.println(testcreate.getId()+" "+testcreate.getEmail());
         Users.create(testcreate);
          */


         /// update un user envoyé en parametre
          /*
         Utilisateur U = Users.find("user","test@gmails.com");
         System.out.println(U.getNom());
         String R = "Mathilde";
         U.setNom(R);
         System.out.println(U.getId());
         U = Users.update(U);
         */

         /// afficher les users et regarder si le user choisi a bien été sup ou update
         /*
         DAO_Utilisateur Users2 = new DAO_Utilisateur();
         try{
             System.out.println(Users2.toString());
         }catch (NullPointerException n)
         {
             System.out.println(n.getCause());
             System.out.println("Aucune donnée stocko en mémoire");
         }
          */



         /// afficher les cours
         /*

         Cours_DAO cou = new Cours_DAO();
         try{
             System.out.println(cou.toString());
         }catch (NullPointerException n)
         {
             System.out.println(n.getCause());
             System.out.println("Aucune donnée stocko en mémoire");
         }

          */



         /// créer un cours
         /*

         Cours courscreate= new Cours(0, "Chinois");
         cou.ajout(courscreate);
         cou.create(courscreate);

          */


         /// suprimer un cours envoyé en parametre
         /*
         /*int x= 2;
         ///Cours C = list <Cours>(2);
         ///Cours C = List<Cours>(2);
         Cours C = cou.find2(x);

         System.out.println(C.getId_Cours());
         cou.delete(C);
         */

         /// update un cours envoyé en parametre
         /*
         Cours C = cou.find2(3);
         System.out.println(C.getNom());
         String R = "Anglais";
         C.setNom(R);
         System.out.println(C.getId_Cours());
         C = cou.update(C);
          */


         /// afficher les cours
         /*

         Cours_DAO cou2 = new Cours_DAO();
         try{
             System.out.println(cou2.toString());
         }catch (NullPointerException n)
         {
             System.out.println(n.getCause());
             System.out.println("Aucune donnée stocko en mémoire");
         }

          */


         /// afficher les séances


         Seance_DAO sea = new Seance_DAO();
         try{
             System.out.println(sea.toString());
         }catch (NullPointerException n)
         {
             System.out.println(n.getCause());
             System.out.println("Aucune donnée stocko en mémoire");
         }

         /// update une séance
         Seance C = sea.find(1);
         System.out.println(C.getSemaine());
         Integer R = 12;
         C.setSemaine(R);
         System.out.println(C.getSemaine());
         C = sea.update(C);

         /// afficher les séances


         Seance_DAO sea2 = new Seance_DAO();
         try{
             System.out.println(sea2.toString());
         }catch (NullPointerException n)
         {
             System.out.println(n.getCause());
             System.out.println("Aucune donnée stocko en mémoire");
         }







         /// Test class utilisateur   ----------------------------------------------------------------------------
         /*int id = 4;
         int droit= 0;
         String email="johan.croc@gmail.com";
         String nom="Croc";
         String prenom="Johan";
         String password="toto";
         Utilisateur U1 = new Utilisateur (id, droit, email , nom,  prenom, password);
         
         
         /// Test class Etudiant
         int id_utilisateur= 2;
         int numero = 437594;
         int id_groupe = 8;
         Etudiant ET1 = new Etudiant (id_utilisateur, numero, id_groupe);
         
         /// Test class Enseignant
         int id_utilisateur_2= 23;
         int id_groupe_2 = 8;
         Enseignant EN1 = new Enseignant (id_utilisateur_2, id_groupe_2);
         
         /// Test class Groupe
         int id_utilisateur_3= 234;
         String nom_groupe="Groupe des meilleurs élèves";
         int id_promotion = 2022;
         Groupe G1 = new Groupe (id_utilisateur_3,  nom_groupe ,  id_promotion);
         
         /// Test class Promotion
         int id_promotion_2 = 0;
         String nom_promo = "La meilleur promo";
         Promotion P1 = new Promotion (id_promotion_2,  nom_promo);
         
         /// Test class Cours
         int id_cours = 0;
         String nom_cours = "cours de Mathématique";
         Cours C1 = new Cours (id_cours,  nom_cours);
         
         /// Test class Seance_Groupe
         int id_seance_groupe = 3;
         int id_groupe_3 = 4;
         Seance_Groupe S1 = new Seance_Groupe (id_seance_groupe,  id_groupe_3);
         
         
         /// Test class Seance_Enseignant
         int id_seance_enseignant = 33;
         int id_enseignant = 44;
         Seance_Enseignant S_E1 = new Seance_Enseignant (id_seance_enseignant, id_enseignant);
         
   
         /// Test class Seance_Salle
         int id_seance_salle = 333;
         int id_salle = 444;
         Seance_Salle S_S1 = new Seance_Salle (id_seance_salle, id_salle);
         
         /// Test class Seance
         int id_seance = 0;
         int semaine= 16;
         
        Date date = new Date(); 
        DateFormat mediumDateFormatEN = DateFormat.getDateTimeInstance
        (
            DateFormat.MEDIUM,
            DateFormat.MEDIUM, new Locale("EN","en")
        );
        System.out.println(mediumDateFormatEN.format(date));
        
   

         
         /// Test class Type_cours
         int id_type_cours = 3;
         String nom_type_cours = "cours de dodo";
         Type_Cours T_C1 = new Type_Cours (id_type_cours, nom_type_cours);
         
         /// Test class Site
         int id_site = 4;
         String nom_site = "Eiffel 4";
         Site Site1 = new Site (id_site, nom_site);
         
         /// Test class Salle
         int id_salle1= 305;
         String nom_salle = "P305"; 
         int capacite = 36; 
         int id_site_salle = 4;
         Salle Salle1 = new Salle (id_salle1, nom_salle, capacite, id_site_salle);

          */

         
    }
    public void display(String a , String b){
         System.out.print(a+b);
    }
    
}

