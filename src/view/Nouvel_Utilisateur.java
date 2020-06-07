/*package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    String[] promos = {"2020", "2021", "2022", "2023", "2024"};
    String[] groupes = {"1", "2", "3", "4", "5", "6", "7","8","9","10","11","12"};



    public Nouvel_Utilisateur()
    {

        setTitle("Ajouter un utilisateur");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        nom = new JLabel("Nom:");
        nom.setFont(new Font("Arial", Font.PLAIN, 30));
        nom.setSize(300, 30);
        nom.setLocation(300, 100);
        c.add(nom);

        nom2 = new JTextField();
        nom2.setFont(new Font("Arial", Font.PLAIN, 15));
        nom2.setSize(190, 20);
        nom2.setLocation(200, 100);
        c.add(nom2);

        prenom = new JLabel("Prenom:");
        prenom.setFont(new Font("Arial", Font.PLAIN, 30));
        prenom.setSize(300, 30);
        prenom.setLocation(300, 150);
        c.add(prenom);

        prenom2 = new JTextField();
        prenom2.setFont(new Font("Arial", Font.PLAIN, 15));
        prenom2.setSize(190, 20);
        prenom2.setLocation(200, 150);
        c.add(prenom2);

        email = new JLabel("Email:");
        email.setFont(new Font("Arial", Font.PLAIN, 30));
        email.setSize(300, 30);
        email.setLocation(300, 200);
        c.add(email);

        email2 = new JTextField();
        email2.setFont(new Font("Arial", Font.PLAIN, 15));
        email2.setSize(190, 20);
        email2.setLocation(200, 200);
        c.add(email2);

        pass = new JLabel("Password:");
        pass.setFont(new Font("Arial", Font.PLAIN, 30));
        pass.setSize(300, 30);
        pass.setLocation(300, 250);
        c.add(pass);

        pass2 = new JTextField();
        pass2.setFont(new Font("Arial", Font.PLAIN, 15));
        pass2.setSize(190, 20);
        pass2.setLocation(200, 250);
        c.add(pass2);

        dob = new JLabel("Type");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 300);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(100, 20);
        date.setLocation(200, 300);
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
                        case "Etudiant" : droit=0;
                            break;
                        case "Enseignant" :droit=1;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + (String) date.getSelectedItem());
                    }
                    int id= users.getLastId();


                    // SETTER NOM DU COURS
                    //
                    DAO_Utilisateur users = new DAO_Utilisateur();
                    Utilisateur u= new Utilisateur(id,droit,o, m,n,p);

                    if(droit==1)
                    {
                        promotion = new JLabel("Promotion");
                        promotion.setFont(new Font("Arial", Font.PLAIN, 20));
                        promotion.setSize(100, 20);
                        promotion.setLocation(300, 100);
                        c.add(promotion);

                        promo = new JComboBox(promos);
                        promo.setFont(new Font("Arial", Font.PLAIN, 15));
                        promo.setSize(100, 20);
                        promo.setLocation(300, 100);
                        c.add(promo);

                        groupe = new JLabel("Groupe");
                        groupe.setFont(new Font("Arial", Font.PLAIN, 20));
                        groupe.setSize(100, 20);
                        groupe.setLocation(300, 150);
                        c.add(groupe);

                        gp = new JComboBox(groupes);
                        gp.setFont(new Font("Arial", Font.PLAIN, 15));
                        gp.setSize(100, 20);
                        gp.setLocation(300, 150);
                        c.add(gp);



                        Promotion_DAO promos= new Promotion_DAO();
                        Promotion pro= new Promotion();
                        pro=promos.find2(promo.getSelectedItem());

                        Groupe_DAO groupes= new Groupe_DAO();
                        Groupe g=new Groupe();
                        g=groupes.find2(pro.getId());

                        Etudiant_DAO etudiants= new Etudiant_DAO();
                        Etudiant etu= new Etudiant(etudiants.getLastID(), 0, g.getId());


                    }
                    else
                    {
                        cours = new JLabel("Nom du cours:");
                        cours.setFont(new Font("Arial", Font.PLAIN, 30));
                        cours.setSize(300, 30);
                        cours.setLocation(300, 100);
                        c.add(cours);

                        cours2 = new JTextField();
                        cours2.setFont(new Font("Arial", Font.PLAIN, 15));
                        cours2.setSize(190, 20);
                        cours2.setLocation(300, 100);
                        c.add(cours2);

                        String r = cours2.getText();
                        Enseignant_DAO enseignants = new Enseignant_DAO();
                        Enseignant e = new Enseignant(id,r);
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



    public static void main(String[] args) throws Exception
    {
        Nouvel_Utilisateur f = new Nouvel_Utilisateur();
    }
}*/