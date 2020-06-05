package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.*;

import model.Cours;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;

public class Stat extends JFrame {
    private JPanel pnl;


    public Stat() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        pnl = new JPanel(new BorderLayout());
        setContentPane(pnl);
        setSize(400, 250);

        int x = 0,y=0, z=0, w=0;
        List<Cours> List_Course = new ArrayList<Cours>();

        int id=1;
        String nom="PHYSIQUE";

        Cours U = new Cours(id, nom);
        List_Course.add(U);

        int id2=2;
        String nom2="MATHEMATIQUES";

        Cours U2 = new Cours(id2, nom2);
        List_Course.add(U2);
        int id3=3;
        String nom3="MATHEMATIQUES";

        Cours U3 = new Cours(id3, nom3);
        List_Course.add(U3);


        for (Cours i: List_Course) {
            String exemple =i.getNom();
            if(exemple.equals("PHYSIQUE"))
            {
                x=x+1;
            }
            else if (exemple.equals("MATHEMATIQUES"))
            {
                y=y+1;
            }
            else if (exemple.equals("ELECTRONIQUE"))
            {
                z=z+1;
            }
            else if (exemple.equals("INFORMATIQUE"))
            {
                w=w+1;
            }
        }

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("PHYSIQUE", x);
        pieDataset.setValue("MATHEMATIQUES", y);
        pieDataset.setValue("ELECTRONIQUE", z);
        pieDataset.setValue("INFORMATIQUE", w);

        JFreeChart pieChart = ChartFactory.createPieChart("Repartition des cours", pieDataset, true, true, true);
        ChartPanel cPanel = new ChartPanel(pieChart);
        pnl.add(cPanel);
    }

    public static void main(String args[]) {
        Stat tpc = new Stat();
        tpc.setVisible(true);
    }
}

