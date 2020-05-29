/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  

public class Seance {
  private int id_seance = 0;
  private int semaine = 0;
  //chekcer si ça fonctionne bien
  private Date date;
  private int heure_debut = 0;
  private int heure_fin = 0;
  private int etat = 0;
  private int id_cours = 0;
  private int id_type = 0;

  public Seance(int id_seance, int semaine ,int heure_debut, int heure_fin, int etat, int id_cours , int id_type ) {
    this.id_seance = id_seance;
    this.semaine=semaine;
    ///this.date=date;
    this.heure_debut = heure_debut;
    this.heure_fin = heure_fin;
    this.etat=etat;
    this.id_cours=id_cours;
    this.id_type=id_type;
    
    System.out.println(id_seance);
    System.out.println(semaine);
    System.out.println(date);
    System.out.println(heure_debut);
    System.out.println(heure_fin);
    System.out.println(etat);
    System.out.println(id_cours);
    System.out.println(id_type);
  }
  public Seance(){};
     
  public int getId_Seance() {
    return id_seance;
  }

  public int getId_Cours() {
    return id_cours;
  }

  public int getId_Type() {
    return id_type;
  }

  public int getSemaine() {
    return semaine;
  }

  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }  

  public int getHeure_Debut() {
    return heure_debut;
  }
  public void setHeure_Debut(int heure_debut) {
    this.heure_debut = heure_debut;
  }  
  public int getHeure_Fin() {
    return heure_fin;
  }
  public void setHeure_Fin(int heure_fin) {
    this.heure_fin = heure_fin;
  } 

  public int getEtat() {
    return etat;
  }
  public void setEtat(int etat) {
    this.etat = etat;
  } 
}

