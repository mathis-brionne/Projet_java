package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Supprimet séance.
 */
public class Supprimet_séance extends JFrame {
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;

    private JButton sub;

    private JLabel res;

    /**
     * Instantiates a new Supprimet séance.
     */
    public Supprimet_séance()
    {

        setTitle("Supprimer une  séance");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        name = new JLabel("id: ");
        name.setFont(new Font("Arial", Font.PLAIN, 30));
        name.setSize(300, 30);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 500);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub) {
                    
                    String test = tname.getText();
                    Integer i=Integer.valueOf(test);
                    System.out.println(test);

                    Seance_DAO a = new Seance_DAO();
                    Seance S = new Seance();
                    S=a.find2(i);
                    a.delete(S);


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


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception
    {
        Supprimet_séance f = new Supprimet_séance();
    }
}
