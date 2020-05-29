package view;

import model.Utilisateur;
import model.bdd_find;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel panel1;
    private JTextField passwordField1;
    private JTextField textField1;
    private JButton button1;
    public Login() {
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
               controler.Login L = new controler.Login(username , passwords);
            }
        });
    }
    public void err_prompt(){

    }

    public static void main(String[] args) {

    }
}
