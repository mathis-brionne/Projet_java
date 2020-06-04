package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
    public Fenetre(){
        this.setTitle("Ma première fenêtre Java");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ///this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        this.setContentPane(new Panneau());

        this.setVisible(true);
    }
}