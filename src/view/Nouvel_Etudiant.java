package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.acl.Group;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Nouvel etudiant.
 */
class Nouvel_Etudiant extends JFrame {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel promotion;
    private JComboBox promo;
    private JLabel groupe;
    private JComboBox gp;

    private JButton sub;

    private JLabel res;


    /**
     * The Promos.
     */
    String[] promos = {"2020", "2021", "2022", "2023", "2024"};
    /**
     * The Groupes.
     */
    String[] groupes = {"TD1", "TD2", "TD3", "TD4", "TD5", "TD6", "TD7","TD8","TD9","TD10","TD11","TD12"};


    /**
     * Instantiates a new Nouvel etudiant.
     *
     * @param u the u
     */
    public Nouvel_Etudiant(Utilisateur u)
    {

        setTitle("Ajouter un nouvel étudiant");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);


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


        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 500);


        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub)
                {

                    String test = (String) promo.getSelectedItem();
                    System.out.println(test);
                    Promotion_DAO promos= new Promotion_DAO();
                    Promotion pro= new Promotion();
                    pro=promos.find2(test);

                    int IDG = new Groupe_DAO().getspId(new Promotion_DAO().getspID((String)promo.getSelectedItem()),(String) gp.getSelectedItem());

                    /*
                    Groupe_DAO groupes= new Groupe_DAO();
                    Groupe g=new Groupe();
                    g=groupes.find2(pro.getId_Promotion());

                     */

                    Etudiant_DAO etudiants= new Etudiant_DAO();
                    Etudiant etu= new Etudiant(u.getId(), 0 , IDG);
                    etu = etudiants.create(etu);
                    dispose();

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



    /*
    public static void main(String[] args) throws Exception
    {
        Nouvel_Etudiant f = new Nouvel_Etudiant();
    }
     */
}