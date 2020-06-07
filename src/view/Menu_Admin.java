package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class Menu_Admin extends JFrame {


    private Container c;
    private JLabel title;

    private JButton sub;
    private JButton sub2;
    private JButton sub3;

    private JLabel res;


    public Menu_Admin ()
    {

        setTitle("Menu");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        JPanel boutonPane = new JPanel();

        c = getContentPane();
        c.setLayout(null);


        sub = new JButton("Ajouter Séance");
        sub.setFont(new Font("Arial", Font.PLAIN, 20));
        sub.setSize(300, 50);
        sub.setLocation(250, 100);



        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub) {
                    Ajouter_Seance a =new Ajouter_Seance();

                }


            }
        });



        sub2 = new JButton("Modifier Séance");
        sub2.setFont(new Font("Arial", Font.PLAIN, 20));
        sub2.setSize(300, 50);
        sub2.setLocation(250, 200);

        sub2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub2) {
                    Modif_Seance m = new Modif_Seance();


                }


            }
        });


        sub3 = new JButton("Ajouter un nouvel utilisateur");
        sub3.setFont(new Font("Arial", Font.PLAIN, 20));
        sub3.setSize(300, 50);
        sub3.setLocation(250, 300);

        sub3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub3) {
                    Nouvel_Utilisateur u = new Nouvel_Utilisateur();


                }


            }
        });
        c.add(sub);
        c.add(sub2);
        c.add(sub3);





        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        boutonPane.add(res);


        setVisible(true);
    }



    public static void main(String[] args) throws Exception
    {
        Menu_Admin f = new Menu_Admin();
    }

}