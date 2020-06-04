package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Panneau extends JPanel {
    private JButton boutton = new JButton("Mon bouton");

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
            this.add(boutton);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}