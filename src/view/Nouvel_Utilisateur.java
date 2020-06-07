package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.*;
import model.Utilisateur;
import model.DAO_Utilisateur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.acl.Group;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Nouvel utilisateur.
 */
class Nouvel_Utilisateur extends JFrame {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel nom;
    private JTextField nom2;
    private JLabel prenom;
    private JTextField prenom2;
    private JLabel email;
    private JTextField email2;
    private JLabel cours;
    private JTextField cours2;
    private JLabel pass;
    private JTextField pass2;
    private JLabel dob;
    private JComboBox date;
    private JLabel promotion;
    private JComboBox promo;
    private JLabel groupe;
    private JComboBox gp;

    private JButton sub;

    private JLabel res;



    private String dates[]
            = { "Etudiant","Enseignant" };
    /**
     * The Promos.
     */
    String[] promos = {"2020", "2021", "2022", "2023", "2024"};
    /**
     * The Groupes.
     */
    String[] groupes = {"1", "2", "3", "4", "5", "6", "7","8","9","10","11","12"};


    /**
     * Instantiates a new Nouvel utilisateur.
     */
    public Nouvel_Utilisateur()
    {

        setTitle("Ajouter un utilisateur");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        nom = new JLabel("Nom:");
        nom.setFont(new Font("Arial", Font.PLAIN, 20));
        nom.setSize(300, 30);
        nom.setLocation(100, 100);
        c.add(nom);

        nom2 = new JTextField();
        nom2.setFont(new Font("Arial", Font.PLAIN, 15));
        nom2.setSize(190, 20);
        nom2.setLocation(250, 100);
        c.add(nom2);

        prenom = new JLabel("Prenom:");
        prenom.setFont(new Font("Arial", Font.PLAIN, 20));
        prenom.setSize(300, 30);
        prenom.setLocation(100, 150);
        c.add(prenom);

        prenom2 = new JTextField();
        prenom2.setFont(new Font("Arial", Font.PLAIN, 15));
        prenom2.setSize(190, 20);
        prenom2.setLocation(250, 150);
        c.add(prenom2);

        email = new JLabel("Email:");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(300, 30);
        email.setLocation(100, 200);
        c.add(email);

        email2 = new JTextField();
        email2.setFont(new Font("Arial", Font.PLAIN, 15));
        email2.setSize(190, 20);
        email2.setLocation(250, 200);
        c.add(email2);

        pass = new JLabel("Password:");
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(300, 30);
        pass.setLocation(100, 250);
        c.add(pass);

        pass2 = new JTextField();
        pass2.setFont(new Font("Arial", Font.PLAIN, 15));
        pass2.setSize(190, 20);
        pass2.setLocation(250, 250);
        c.add(pass2);

        dob = new JLabel("Type");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 300);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(100, 20);
        date.setLocation(250, 300);
        c.add(date);

        sub = new JButton("Suivant");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 400);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub) {


                    String m = nom2.getText();
                    String n= prenom2.getText();
                    String o= email2.getText();
                    String p= pass2.getText();

                    int droit;

                    //String q =new String();
                    switch ((String) date.getSelectedItem()){
                        case "Etudiant" : droit=4;
                            break;
                        case "Enseignant" :droit=3;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + (String) date.getSelectedItem());
                    }



                    // SETTER NOM DU COURS
                    //
                    DAO_Utilisateur users = new DAO_Utilisateur();
                    int id= users.getLastID();
                    Utilisateur u= new Utilisateur(id,droit,o, m,n,p);
                    u = users.create(u);

                    if(droit==4)
                    {
                        Nouvel_Etudiant etudiant = new Nouvel_Etudiant(u);
                        dispose();

                    }
                    else
                    {
                        Nouveau_Prof prof = new Nouveau_Prof(u);
                        dispose();

                    }

                }
            }
        });
        c.add(sub);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);


        setVisible(true);
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception
    {
        Nouvel_Utilisateur f = new Nouvel_Utilisateur();
    }

}
