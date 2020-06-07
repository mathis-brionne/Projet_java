package view;

import controler.Eleve;
import controler.Planning;
import controler.Prof;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * The type Recherche.
 */
public class recherche extends JFrame {
    private JButton button;
    private JButton button2;

    /**
     * Instantiates a new Recherche.
     */
    public recherche(){
        List<Cours> rf = new Cours_DAO().getList_Course();
        String[] cours = new String[ new Cours_DAO().getList_Course().size()];
        for (int y = 0 ; y < rf.size() ; y++) {
            cours[y] = rf.get(y).getNom();
        }
        Container panel;
        setTitle("Ajouter une nouvelle séance");
        setBounds(300, 90, 615, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel = getContentPane();
        panel.setLayout(null);

        String[] promos = {"2020", "2021", "2022", "2023", "2024"};
        String[] groupes = {"TD1", "TD2", "TD3", "TD4", "TD5", "TD6", "TD7","TD8","TD9","TD10","TD11","TD12"};

        JLabel promotion = new JLabel("Promotion");
        promotion.setFont(new Font("Arial", Font.PLAIN, 20));
        promotion.setSize(100, 20);
        promotion.setLocation(100, 100);
        panel.add(promotion);

        JComboBox promo = new JComboBox(promos);
        promo.setFont(new Font("Arial", Font.PLAIN, 15));
        promo.setSize(100, 20);
        promo.setLocation(200, 100);
        panel.add(promo);

        JLabel groupe = new JLabel("Groupe");
        groupe.setFont(new Font("Arial", Font.PLAIN, 20));
        groupe.setSize(100, 20);
        groupe.setLocation(315, 100);
        panel.add(groupe);

        JComboBox gp = new JComboBox(groupes);
        gp.setFont(new Font("Arial", Font.PLAIN, 15));
        gp.setSize(100, 20);
        gp.setLocation(415, 100);
        panel.add(gp);

        JLabel nom = new JLabel("Nom");
        nom.setFont(new Font("Arial", Font.PLAIN, 20));
        nom.setSize(300, 20);
        nom.setLocation(100,50);
        panel.add(nom);

        JTextField getnom = new JTextField();
        getnom.setFont(new Font("Arial", Font.PLAIN, 15));
        getnom.setSize(100, 20);
        getnom.setLocation(200, 50);
        panel.add(getnom);

        JLabel prenom = new JLabel("Prenom");
        prenom.setFont(new Font("Arial", Font.PLAIN, 20));
        prenom.setSize(200, 20);
        prenom.setLocation(315, 50);
        panel.add(prenom);

        JTextField getprenom = new JTextField();
        getprenom.setFont(new Font("Arial", Font.PLAIN, 15));
        getprenom.setSize(100, 20);
        getprenom.setLocation(415, 50);
        panel.add(getprenom);

        button = new JButton("Rechercher Etudiant");
        button.setFont(new Font("Arial", Font.PLAIN, 15));
        button.setSize(200, 20);
        button.setLocation(207, 150);
        button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (e.getSource() == button) {
                  DAO_Utilisateur user = new DAO_Utilisateur();
                  int IDG = new Groupe_DAO().getspId(new Promotion_DAO().getspID((String)promo.getSelectedItem()),(String) gp.getSelectedItem());
                  List<Utilisateur> L =  user.findq(getnom.getText(),getprenom.getText());
                  for (Utilisateur a : L) {
                      if ( new Etudiant_DAO().find(a.getId())==IDG) {
                          Eleve E =new Eleve(a);
                          planning p = new planning(E.getPlannig().getSeances() , 21);
                      }
                  }
                  dispose();
              }

          }
        });
        add(button);
        setTitle("Ajouter une nouvelle séance");
        setBounds(300, 90, 615, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel = getContentPane();
        panel.setLayout(null);


        JLabel nomp = new JLabel("Nom");
        nomp.setFont(new Font("Arial", Font.PLAIN, 20));
        nomp.setSize(300, 20);
        nomp.setLocation(100,200);
        panel.add(nomp);

        JTextField getnomp = new JTextField();
        getnomp.setFont(new Font("Arial", Font.PLAIN, 15));
        getnomp.setSize(100, 20);
        getnomp.setLocation(200, 200);
        panel.add(getnomp);

        JLabel prenomp = new JLabel("Prenom");
        prenomp.setFont(new Font("Arial", Font.PLAIN, 20));
        prenomp.setSize(200, 20);
        prenomp.setLocation(315, 200);
        panel.add(prenomp);


        JTextField getprenomp = new JTextField();
        getprenomp.setFont(new Font("Arial", Font.PLAIN, 15));
        getprenomp.setSize(100, 20);
        getprenomp.setLocation(415, 200);
        panel.add(getprenomp);

       JComboBox cour = new JComboBox(cours);
        cour.setFont(new Font("Arial", Font.PLAIN, 15));
        cour.setSize(100, 20);
        cour.setLocation(207, 250);
        panel.add(cour);

        button2 = new JButton("Rechercher Enseignent");
        button2.setFont(new Font("Arial", Font.PLAIN, 15));
        button2.setSize(200, 20);
        button2.setLocation(207, 300);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button2) {
                    DAO_Utilisateur user = new DAO_Utilisateur();
                    List<Utilisateur> L =  user.findq(getnomp.getText(),getprenomp.getText());
                    for (Utilisateur a : L) {
                        if ( new Enseignant_DAO().getIDcour(a.getId())== new Cours_DAO().getspId((String) cour.getSelectedItem()) ) {
                            Prof P =new Prof(a);
                            planning p = new planning(P.getPlannig().getSeances() , 21);
                        }
                    }
                }
            }
        });
        add(button2);


        setVisible(true);

    }
}
