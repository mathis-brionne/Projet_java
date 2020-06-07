package view;

import controler.Eleve;
import controler.Prof;
import model.DAO_Utilisateur;
import model.Utilisateur;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The type Panneau.
 */
public class Panneau extends JPanel {
    private JButton boutton = new JButton("submit");

    public void paintComponent(Graphics g){

        try {
            Image img = ImageIO.read(new File("image.jpg"));
            //Pour une image de fond
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);


            JLabel label = new JLabel("User");
            label.setBounds(1500, 150, 165, 25);
            this.add(label);

            JTextField userText = new JTextField(20);
            userText.setBounds(1680, 150, 165, 25);
            this.add(userText);


            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(1500, 170, 165, 25);
            this.add(passwordLabel);

            JPasswordField passwordText = new JPasswordField();
            passwordText.setBounds(1680, 170, 165, 25);
            this.add(passwordText);



            boutton.setBounds(1680, 200, 165, 25);
            boutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(userText.getText());
                    DAO_Utilisateur a = new DAO_Utilisateur();
                    Utilisateur U = a.find("user",userText.getText());
                    System.out.println(U.getPassword());
                    planning p ;
                    if (passwordText.getText().equals(U.getPassword())){
                        switch (U.getDroit()){
                            case 1 : break;
                            case 2 : break;
                            case 3 :
                                Prof P = new Prof(U);
                                p = new  planning(P.getPlannig().getSeances(), 21);
                                break;
                            case 4 :
                                Eleve E = new Eleve(U);
                                p = new planning(E.getPlannig().getSeances(),21);
                                break;
                        }
                        dispose();
                    }
                }});
            this.add(boutton);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dispose.
     */
    public void dispose() {
        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.dispose();
    }
}