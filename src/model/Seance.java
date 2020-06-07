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

/**
 * The type Seance.
 */
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

    /**
     * Instantiates a new Seance.
     *
     * @param id_seance   the id seance
     * @param semaine     the semaine
     * @param date        the date
     * @param creaneau    the creaneau
     * @param heure_debut the heure debut
     * @param heure_fin   the heure fin
     * @param etat        the etat
     * @param id_cours    the id cours
     * @param id_type     the id type
     */
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

    /**
     * Set afffichage.
     */
    public void setAfffichage(){
    this.Cours = new Cours_DAO().find(id_cours);
    this.salle = new Salle_DAO().finds(new Seance_Salle_DAO().find(id_seance));
    this.Prof = new DAO_Utilisateur().getname(new Seance_Enseignant_DAO().find(id_seance));
  }

    /**
     * Instantiates a new Seance.
     */
    public Seance(){}

    /**
     * Gets creaneau.
     *
     * @return the creaneau
     */
    public int getCreaneau() {
        return creaneau;
    }

    /**
     * Gets id seance.
     *
     * @return the id seance
     */
    public int getId_Seance() {
    return id_seance;
  }

    /**
     * Sets id seance.
     *
     * @param id the id
     */
    public void setId_seance(int id)
  {
    this.id_seance = id;
  }

    /**
     * Gets id cours.
     *
     * @return the id cours
     */
    public int getId_Cours() {
    return id_cours;
  }

    /**
     * Sets id cours.
     *
     * @param id the id
     */
    public void setId_cours(int id)
  {
    this.id_cours = id;
  }

    /**
     * Gets id type.
     *
     * @return the id type
     */
    public int getId_Type() {
    return id_type;
  }

    /**
     * Sets id type.
     *
     * @param id the id
     */
    public void setId_type(int id)
  {
    this.id_type = id;
  }


    /**
     * Gets semaine.
     *
     * @return the semaine
     */
    public int getSemaine() {
    return semaine;
  }

    /**
     * Sets semaine.
     *
     * @param id the id
     */
    public void setSemaine(int id)
  {
    this.semaine = id;
  }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
    return date;
  }

    /**
     * Sets date.
     *
     * @param d the d
     */
    public void setDate(Date d) {
    this.date = d;
  }


    /**
     * Gets cours.
     *
     * @return the cours
     */
    public String getCours() {
    return Cours;
  }

    /**
     * Gets salle.
     *
     * @return the salle
     */
    public String getSalle() {
    return salle;
  }

    /**
     * Gets prof.
     *
     * @return the prof
     */
    public String getProf() {
    return Prof;
  }

    /**
     * Gets heure fin.
     *
     * @return the heure fin
     */
    public String getHeure_Fin() {
    return heure_fin;
  }

    /**
     * Sets heure fin.
     *
     * @param h the h
     */
    public void setHeure_fin(String h) {
    this.heure_fin = h;
  }

    /**
     * Gets heure debut.
     *
     * @return the heure debut
     */
    public String getHeure_Debut() {
    return heure_debut; }

    /**
     * Sets heure debut.
     *
     * @param h the h
     */
    public void setHeure_debut(String h) {
    this.heure_debut = h;
  }

    /**
     * Gets etat.
     *
     * @return the etat
     */
    public int getEtat() {
    return etat;
  }

    /**
     * Sets etat.
     *
     * @param id the id
     */
    public void setEtat(int id)
  {
    this.etat = id;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}


