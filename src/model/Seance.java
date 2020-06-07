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
  public Seance(int id_seance, int semaine ,Date date, int creaneau, String heure_debut, String heure_fin, int etat, int id_cours , int id_type) {
    this.id_seance = id_seance;
    this.semaine=semaine;
    this.date=date;
    this.heure_debut = heure_debut;
    this.heure_fin = heure_fin;
    this.etat=etat;
    this.id_cours=id_cours;
    this.id_type=id_type;
    this.creaneau = creaneau ;
  }
  public void setAfffichage(){
    this.Cours = new Cours_DAO().find(id_cours);
    this.salle = new Salle_DAO().finds(new Seance_Salle_DAO().find(id_seance));
    this.Prof = new DAO_Utilisateur().getname(new Seance_Enseignant_DAO().find(id_seance));
  }
  public Seance(){}
    public int getCreaneau() {
        return creaneau;
    }
    public int getId_Seance() {
    return id_seance;
  }
  public void setId_seance(int id)
  {
    this.id_seance = id;
  }

  public int getId_Cours() {
    return id_cours;
  }
  public void setId_cours(int id)
  {
    this.id_cours = id;
  }

  public int getId_Type() {
    return id_type;
  }
  public void setId_type(int id)
  {
    this.id_type = id;
  }


  public int getSemaine() {
    return semaine;
  }
  public void setSemaine(int id)
  {
    this.semaine = id;
  }

  public Date getDate() {
    return date;
  }
  public void setDate(Date d) {
    this.date = d;
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
  public void setHeure_fin(String h) {
    this.heure_fin = h;
  }
  public String getHeure_Debut() {
    return heure_debut; }
  public void setHeure_debut(String h) {
    this.heure_debut = h;
  }
  public int getEtat() {
    return etat;
  }
  public void setEtat(int id)
  {
    this.etat = id;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}


