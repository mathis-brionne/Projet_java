package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Case_Planning extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;

    private JLabel name;
    private JTextField tname;
    private JButton sub;
    private JLabel res;

    public Case_Planning()
    {
        setTitle("Test Semaine");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        name = new JLabel("Semaine");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
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
        sub.setLocation(150, 350);
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
            Integer x = Integer.valueOf(test);
            if (x>0 && x<53)
            {
                res.setText("Semaine ok ");
                System.out.println(x);
                //SETTER SEMAINE
            }
            else
            {
                String echec="";
                tname.setText(echec);
                res.setText("Echec");
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Case_Planning f = new Case_Planning();
    }
}
