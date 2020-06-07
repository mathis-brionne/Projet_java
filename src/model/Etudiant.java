
package model;
import java.util.*;
import java.io.*;


/**
 * The type Etudiant.
 */
public class Etudiant {
  private int id_utilisateur = 0;
  private int numero = 0;
  private int id_groupe = 0;


    /**
     * Instantiates a new Etudiant.
     *
     * @param id_utilisateur the id utilisateur
     * @param numero         the numero
     * @param id_groupe      the id groupe
     */
    public Etudiant(int id_utilisateur, int numero, int id_groupe) {
    this.id_utilisateur = id_utilisateur;
    this.numero = numero;
    this.id_groupe= id_groupe;
    
    System.out.println(id_utilisateur);
    System.out.println(numero);
    System.out.println(id_groupe);
  }

    /**
     * Instantiates a new Etudiant.
     */
    public Etudiant(){};

    /**
     * Gets id utilisateur.
     *
     * @return the id utilisateur
     */
    public int getId_Utilisateur() {
    return id_utilisateur;
  }

    /**
     * Gets numero.
     *
     * @return the numero
     */
    public int getNumero() {
    return numero;
  }

    /**
     * Sets numero.
     *
     * @param numero the numero
     */
    public void setNumero(int numero) {
    this.numero = numero;
  }

    /**
     * Gets id groupe.
     *
     * @return the id groupe
     */
    public int getId_Groupe() {
    return id_groupe;
  }
}
