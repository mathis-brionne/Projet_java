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
         
         /// Test class utilisateur  
         int id = 4;
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
        
   
         int heure_debut= 16;
         int heure_fin = 18;
         int etat= 1;
         int id_cours_5= 0;
         int id_type= 2;
         
         Seance S_1 = new Seance ( id_seance, semaine,  heure_debut, heure_fin, etat, id_cours_5 ,id_type);   /// sans la Date
        /// Seance S_1 = new Seance ( id_seance, semaine,date,  heure_debut, heure_fin, etat, id_cours_5 ,id_type);   Avec la Date
         
         
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
         
    }
    public void display(String a , String b){
         System.out.print(a+b);
    }
    
}

