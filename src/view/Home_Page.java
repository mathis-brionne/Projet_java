package view;

import controler.Eleve;
import model.Cours_DAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Home page.
 */
public class Home_Page {
    /**
     * Instantiates a new Home page.
     *
     * @param E the e
     */
    public Home_Page(Eleve E ) {
        System.out.println(E.getPlannig().toString());
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(2000, 1800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Bonjous "+E.getPrenom()+" votre prochain cours est "+ new Cours_DAO().find(1));
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
                System.out.println("coucou");

                frame.dispose();
                Home_Page H = new Home_Page(E);
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
