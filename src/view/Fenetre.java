package view;

import com.sun.deploy.panel.JavaPanel;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The type Fenetre.
 */
public class Fenetre extends JFrame {
    /**
     * Instantiates a new Fenetre.
     */
    public Fenetre(){
        this.setTitle("Ma première fenêtre Java");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ///this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setContentPane(new Panneau());
        this.setVisible(true);
    }
}