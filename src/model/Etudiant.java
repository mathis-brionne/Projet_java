
package model;
import java.util.*;
import java.io.*;



public class Etudiant {
  private int id_utilisateur = 0;
  private int numero = 0;
  private int id_groupe = 0;


  public Etudiant(int id_utilisateur, int numero, int id_groupe) {
    this.id_utilisateur = id_utilisateur;
    this.numero = numero;
    this.id_groupe= id_groupe;
    
    System.out.println(id_utilisateur);
    System.out.println(numero);
    System.out.println(id_groupe);
  }
  public Etudiant(){};
     
  public int getId_Utilisateur() {
    return id_utilisateur;
  }
  
  public int getNumero() {
    return numero;
  }
  public void setNumero(int numero) {
    this.numero = numero;
  } 

  public int getId_Groupe() {
    return id_groupe;
  }
}
