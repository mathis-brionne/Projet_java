/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
import java.util.List;

public class Seance extends Object {
  private int id_seance = 0;
  private int semaine = 0;
  //chekcer si ça fonctionne bien
  private Date date;
  private String heure_debut ;
  private int creaneau ;
  private String heure_fin = "";
  private int etat = 0;
  private int id_cours = 0;
  private int id_type = 0;
  private String Prof ="";
  private String salle = "";
  private String Cours = "";
  public Seance(int id_seance, int semaine ,Date date, int creaneau, String heure_debut, String heure_fin, int etat, int id_cours , int id_type , String salle , String cours, String Prof ) {
    this.id_seance = id_seance;
    this.semaine=semaine;
    this.date=date;
    this.heure_debut = heure_debut;
    this.heure_fin = heure_fin;
    this.etat=etat;
    this.id_cours=id_cours;
    this.id_type=id_type;
    this.creaneau = creaneau ;
    this.Prof=Prof;
    this.salle = salle;
    this.Cours = cours;
  }
  public Seance(){}
    public int getCreaneau() {
        return creaneau;
    }
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

  public String getCours() {
    return Cours;
  }

  public String getSalle() {
    return salle;
  }

  public String getProf() {
    return Prof;
  }

  public String getHeure_Fin() {
    return heure_fin;
  }

  public int getEtat() {
    return etat;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}


