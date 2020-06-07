package view;

import controler.Eleve;
import controler.GUI;
import controler.Prof;
import model.DAO_Utilisateur;
import model.Utilisateur;
import model.bdd_find;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Login.
 */
public class Login {
    /**
     * Instantiates a new Login.
     */
    public Login() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("User");
        label.setBounds(10 , 20, 80, 25);
        panel.add(label);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 20);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton button = new JButton();
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new ActionListener() {
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
                         p = new  planning(P.getPlannig().getSeances(),21);
                        break;
                    case 4 :
                        Eleve E = new Eleve(U);
                         p = new planning(E.getPlannig().getSeances(),21);
                        break;
                }

             }
               frame.dispose();

            }});
        panel.add(button);


        frame.setVisible(true);

        /*
        panel.add(label);

        JFrame f = new JFrame("LOGIN");
        // affectation du titre et de l'icône
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(panel1);
        f.pack();
        f.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String passwords = passwordField1.getText();

            }
        });*/
    }


}
