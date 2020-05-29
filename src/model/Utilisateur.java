package model;
import java.util.*;
import java.io.*;



public class Utilisateur {
  private int id = 0;
  private int droit = 0;
  private String email = "";
  private String nom = "";
  private String prenom = "";
  private String password = "";

  public Utilisateur(int id, int droit, String email ,String nom, String prenom, String password) {
    this.id = id;
    this.droit=droit;
    this.email=email;
    this.nom = nom;
    this.prenom = prenom;
    this.password=password;
    
    System.out.println(id);
    System.out.println(droit);
    System.out.println(email);
    System.out.println(nom);
    System.out.println(prenom);
    System.out.println(password);
  }
  public Utilisateur(){};
     
  public int getId() {
    return id;
  }

  public int getDroit() {
    return droit;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  } 

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }  
}
