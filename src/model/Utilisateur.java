package model;
import java.util.*;
import java.io.*;


/**
 * The type Utilisateur.
 */
public class Utilisateur {
  private int id = 0;
  private int droit = 0;
  private String email = "";
  private String nom = "";
  private String prenom = "";
  private String password = "";

    /**
     * Instantiates a new Utilisateur.
     *
     * @param id       the id
     * @param droit    the droit
     * @param email    the email
     * @param nom      the nom
     * @param prenom   the prenom
     * @param password the password
     */
    public Utilisateur(int id, int droit, String email ,String nom, String prenom, String password) {
    this.id = id;
    this.droit=droit;
    this.email=email;
    this.nom = nom;
    this.prenom = prenom;
    this.password=password;
  }

    /**
     * Instantiates a new Utilisateur.
     */
    public Utilisateur(){};

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
    return id;
  }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
    this.id = id;
  }

    /**
     * Gets droit.
     *
     * @return the droit
     */
    public int getDroit() {
    return droit;
  }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
    return email;
  }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
    this.email = email;
  }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
    return nom;
  }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
    this.nom = nom;
  }

    /**
     * Gets prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
    return prenom;
  }

    /**
     * Sets prenom.
     *
     * @param prenom the prenom
     */
    public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
    return password;
  }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
    this.password = password;
  }  
}
