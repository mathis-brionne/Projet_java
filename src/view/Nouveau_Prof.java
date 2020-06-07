package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.acl.Group;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class Nouveau_Prof extends JFrame {

    // Components of the Form
    private Container c;
    private JLabel title;

    private JLabel cours;
    private JTextField cours2;
    private JButton sub;
    private JLabel res;



    private String[] salle = new String[new Salle_DAO().getList_Salle().size()];
    private String[] profs = new String[new Enseignant_DAO().getList_Enseignant().size()];
    public Nouveau_Prof(Utilisateur u)
    {

        setTitle("Ajouter un nouveau professeur");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Ajouter un nouveau professeur");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        cours = new JLabel("Nom du cours:");
        cours.setFont(new Font("Arial", Font.PLAIN, 30));
        cours.setSize(300, 30);
        cours.setLocation(300, 100);
        c.add(cours);

        cours2 = new JTextField();
        cours2.setFont(new Font("Arial", Font.PLAIN, 15));
        cours2.setSize(190, 20);
        cours2.setLocation(300, 100);
        c.add(cours2);



        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 500);


        sub.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == sub)
                {
                    String r = cours2.getText();
                    Cours_DAO C = new Cours_DAO();

                    int i = C.getLastID();
                    Cours co = new Cours(i, r);
                    co = C.create(co);

                    Enseignant_DAO enseignants = new Enseignant_DAO();
                    Enseignant ens = new Enseignant(u.getId(),i);

                    ens = enseignants.create(ens);

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
}