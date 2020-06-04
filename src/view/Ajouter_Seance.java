package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ajouter_Seance extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel dob;
    private JComboBox date;
    private JLabel promotion;
    private JComboBox promo;
    private JLabel groupe;
    private JComboBox gp;
    private JComboBox month;
    private JComboBox year;
    private JButton sub;

    private JLabel res;


    String[] promos = {"2020", "2021", "2022", "2023", "2024"};
    String[] groupes = {"1", "2", "3", "4", "5", "6", "7","8","9","10","11","12"};

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "2020","2021","2022" };


    public Ajouter_Seance()
    {
        setTitle("Ajouter une nouvelle séance");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Ajouter une séance");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);



        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 150);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 150);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 150);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 150);
        c.add(year);

        promotion = new JLabel("Promotion");
        promotion.setFont(new Font("Arial", Font.PLAIN, 20));
        promotion.setSize(100, 20);
        promotion.setLocation(100, 200);
        c.add(promotion);

        promo = new JComboBox(promos);
        promo.setFont(new Font("Arial", Font.PLAIN, 15));
        promo.setSize(50, 20);
        promo.setLocation(200, 200);
        c.add(promo);

        groupe = new JLabel("Groupe");
        groupe.setFont(new Font("Arial", Font.PLAIN, 20));
        groupe.setSize(100, 20);
        groupe.setLocation(100, 250);
        c.add(groupe);

        gp = new JComboBox(groupes);
        gp.setFont(new Font("Arial", Font.PLAIN, 15));
        gp.setSize(50, 20);
        gp.setLocation(200, 250);
        c.add(gp);


        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 300);
        sub.addActionListener(this);
        c.add(sub);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {


            String test = tname.getText();
            System.out.println(test);
            // SETTER NOM DU COURS



            //SETTER DE DATE

            String testpromo= (String)promo.getSelectedItem();
            Integer x = Integer.valueOf(testpromo);
            System.out.println(x);
            //SETTER PROMO

            String testgroupe= (String)gp.getSelectedItem();
            Integer y = Integer.valueOf(testgroupe);
            System.out.println(y);


            res.setText("Registration Successfully..");
        }
    }


    public static void main(String[] args) throws Exception
    {
        Ajouter_Seance f = new Ajouter_Seance();
    }
}