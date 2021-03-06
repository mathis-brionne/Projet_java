package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Modif seance.
 */
class Modif_Seance extends JFrame {

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
    private JLabel semaine;
    private JComboBox sem;
    private JComboBox heure ;
    private JComboBox type_cour ;
    private JComboBox cour;
    private JLabel res;
    private JLabel id;
    private JTextField idzone;

    /**
     * The Heures.
     */
    String[] heures = {"08:30:00","10:15:00","12:00:00","13:45:00","15:30:00","17:15:00","19:00:00"};
    /**
     * The Type cours.
     */
    String[] type_cours = {"Cours","TD","TD","Examen" };
    /**
     * The Promos.
     */
    String[] promos = {"2020", "2021", "2022", "2023", "2024"};
    /**
     * The Groupes.
     */
    String[] groupes = {"1", "2", "3", "4", "5", "6", "7","8","9","10","11","12"};
    private String[] cours = new String[ new Cours_DAO().getList_Course().size()];
    /**
     * The Semaines.
     */
    String[] semaines = new String[52];

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "01", "02", "03", "04",
            "05", "06", "07", "08",
            "09", "10", "11", "12" };
    private String years[]
            = { "2020","2021","2022" };

    private String[] salle = new String[new Salle_DAO().getList_Salle().size()];

    /**
     * Instantiates a new Modif seance.
     */
    public Modif_Seance()
    {
        List<Cours> rf = new Cours_DAO().getList_Course();
        List<Salle> emq = new Salle_DAO().getList_Salle();
        for (int y = 0 ; y < rf.size() ; y++) {
            cours[y] = rf.get(y).getNom();
        }
        for (int z = 0 ; z < emq.size();z++)
        {
            salle[z] = emq.get(z).getNom();
        }
        for(int i =0 ; i<52;i++)
        {
            semaines[i]= String.valueOf(i+1);
        }
        setTitle("Modifier une séance");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Modifier une séance");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        dob = new JLabel("Date");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 150);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(100, 20);
        date.setLocation(200, 150);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(100, 20);
        month.setLocation(300, 150);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(100, 20);
        year.setLocation(400, 150);
        c.add(year);

        promotion = new JLabel("Promotion");
        promotion.setFont(new Font("Arial", Font.PLAIN, 20));
        promotion.setSize(100, 20);
        promotion.setLocation(100, 200);
        c.add(promotion);

        promo = new JComboBox(promos);
        promo.setFont(new Font("Arial", Font.PLAIN, 15));
        promo.setSize(100, 20);
        promo.setLocation(200, 200);
        c.add(promo);

        groupe = new JLabel("Groupe");
        groupe.setFont(new Font("Arial", Font.PLAIN, 20));
        groupe.setSize(100, 20);
        groupe.setLocation(100, 250);
        c.add(groupe);

        gp = new JComboBox(groupes);
        gp.setFont(new Font("Arial", Font.PLAIN, 15));
        gp.setSize(100, 20);
        gp.setLocation(200, 250);
        c.add(gp);

        semaine = new JLabel("Semaine");
        semaine.setFont(new Font("Arial", Font.PLAIN, 20));
        semaine.setSize(100, 20);
        semaine.setLocation(100, 300);
        c.add(semaine);

        sem = new JComboBox(semaines);
        sem.setFont(new Font("Arial", Font.PLAIN, 15));
        sem.setSize(100, 20);
        sem.setLocation(200, 300);
        c.add(sem);

        heure = new JComboBox(heures);
        heure.setFont(new Font("Arial", Font.PLAIN, 15));
        heure.setSize(100, 20);
        heure.setLocation(200, 350);
        c.add(heure);

        type_cour = new JComboBox(type_cours);
        type_cour.setFont(new Font("Arial", Font.PLAIN, 15));
        type_cour.setSize(100, 20);
        type_cour.setLocation(200, 400);
        c.add(type_cour);

        cour = new JComboBox(cours);
        cour.setFont(new Font("Arial", Font.PLAIN, 15));
        cour.setSize(100, 20);
        cour.setLocation(200, 450);
        c.add(cour);

        JComboBox Salle = new JComboBox(salle);
        Salle.setFont(new Font("Arial", Font.PLAIN, 15));
        Salle.setSize(100, 20);
        Salle.setLocation(400, 450);
        c.add(Salle);

        id = new JLabel("Id");
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        id.setSize(100, 20);
        id.setLocation(100, 500);
        c.add(id);

        idzone = new JTextField();
        idzone.setFont(new Font("Arial", Font.PLAIN, 15));
        idzone.setSize(190, 20);
        idzone.setLocation(200, 500);
        c.add(idzone);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 550);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub) {


                    String test = tname.getText();
                    System.out.println(test);
                    // SETTER NOM DU COURS
                    //

                    String test2 = idzone.getText();
                    Integer x = Integer.valueOf(test2);

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    String dateString = (String)year.getSelectedItem()+"-"+(String)month.getSelectedItem()+"-"+(String)date.getSelectedItem();
                    Date   date = new Date();
                    try {
                        date = format.parse ( dateString );
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    String Heure_fin =new String();
                    switch ((String) heure.getSelectedItem()){
                        case "08:30:00" : Heure_fin = "10:00:00";
                            break;
                        case "10:15:00" : Heure_fin= "11:45:00";
                            break;
                        case "12:00:00" : Heure_fin= "13:30:00";
                            break;
                        case "13:45:00" : Heure_fin= "15:15:00";
                            break;
                        case "15:30:00" : Heure_fin= "17:00:00";
                            break;
                        case "17:15:00" : Heure_fin= "18:45:00";
                            break;
                        case "19:00:00" : Heure_fin= "20:30:00";
                            break;
                    }
                    Seance_DAO a = new Seance_DAO();
                    Seance S = new Seance(x,(int)sem.getSelectedIndex()+1,date,0,(String)heure.getSelectedItem(),Heure_fin,0,new Cours_DAO().getspId((String) cour.getSelectedItem()), type_cour.getSelectedIndex() +1 );
                    a.update(S);
                    Seance_Groupe n = new Seance_Groupe(x,gp.getSelectedIndex()+1);
                    new Seance_Groupe_DAO().update(n);
                    Seance_Salle em = new Seance_Salle(x,new Salle_DAO().getspId((String) Salle.getSelectedItem()));
                    new Seance_Salle_DAO().update(em);
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
        Modif_Seance f = new Modif_Seance();
    }
}
