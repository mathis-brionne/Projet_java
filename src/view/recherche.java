package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The type Recherche.
 */
public class recherche extends JFrame {
    private JButton button;

    /**
     * Instantiates a new Recherche.
     */
    public recherche(){
        String[] promos = {"2020", "2021", "2022", "2023", "2024"};
        String[] groupes = {"TD1", "TD2", "TD3", "TD4", "TD5", "TD6", "TD7","TD8","TD9","TD10","TD11","TD12"};

        JLabel promotion = new JLabel("Promotion");
        promotion.setFont(new Font("Arial", Font.PLAIN, 20));
        promotion.setSize(100, 20);
        promotion.setLocation(100, 200);
        add(promotion);

        JComboBox promo = new JComboBox(promos);
        promo.setFont(new Font("Arial", Font.PLAIN, 15));
        promo.setSize(100, 20);
        promo.setLocation(200, 200);
        add(promo);

        JLabel groupe = new JLabel("Groupe");
        groupe.setFont(new Font("Arial", Font.PLAIN, 20));
        groupe.setSize(100, 20);
        groupe.setLocation(100, 250);
        add(groupe);

        JComboBox gp = new JComboBox(groupes);
        gp.setFont(new Font("Arial", Font.PLAIN, 15));
        gp.setSize(100, 20);
        gp.setLocation(200, 250);
        add(gp);

        button = new JButton("Submit");
        button.setFont(new Font("Arial", Font.PLAIN, 15));
        button.setSize(100, 20);
        button.setLocation(150, 500);
        button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (e.getSource() == button) {

              }
          }
        });
        add(button);

    }
}
