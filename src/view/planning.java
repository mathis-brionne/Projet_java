package view;


import model.Cours_DAO;
import model.Seance;
import sun.awt.SunHints;

import java.awt.*;
import java.util.ArrayList;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class planning extends JFrame {

    //JToggleButton btngreen;
    //JButton valid = new JButton("Confirmer");
    ModeleStatique model ;
    int Semaine = 21;
    JTable table;
    boolean test;

    public planning(Seance[][][] seances) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelHaut = new JPanel();
        JPanel frame = new JPanel();
        JTextArea text = new JTextArea("Coucou les loulou");
        setSize(1000, 800);
        model = new ModeleStatique(seances, Semaine);

        table = new JTable(model);
        table.setRowHeight(50);

        table.setDefaultRenderer(Seance.class, new ColorCellRenderer());

        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setDefaultRenderer(String.class, new ColorCellRenderer());



        add(panelHaut);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(panelHaut, BorderLayout.NORTH);
        add(frame);
        frame.add(text);
        frame.setVisible(true);
        setVisible(true);

    }

    public class ModeleStatique extends AbstractTableModel {

        Planning[] data;

        private final String[] title = { null, "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi" };

        public ModeleStatique() {
            super();

            data = new Planning[] {
                    new Planning("8h30-10h", null, null, null, null,null),
                    new Planning("10h15-11h45", null, null, null, null,null),
                    new Planning("12h-13h30", null, null, null, null,null),
                    new Planning("13h45-15h15", null, null, null, null,null),
                    new Planning("15h30-17h", null, null, null, null,null),
                    new Planning("17h15-18h45", null, null, null, null,null),
                    new Planning("19h-20h30", null, null, null, null,null),
            };
        }
        public ModeleStatique(Seance[][][] S, int Semaine) {
            super();
           
            data = new Planning[] {
                    new Planning("8h30-10h",S[Semaine][0][0], S[Semaine][1][0], S[Semaine][2][0], S[Semaine][3][0],S[Semaine][4][0]),
                    new Planning("10h15-11h45", S[Semaine][0][1], S[Semaine][1][1], S[Semaine][2][1], S[Semaine][3][1],S[Semaine][4][1]),
                    new Planning("12h-13h30", S[Semaine][0][2], S[Semaine][1][2], S[Semaine][2][2], S[Semaine][3][2],S[Semaine][4][2]),
                    new Planning("13h45-15h15", S[Semaine][0][3], S[Semaine][1][3], S[Semaine][2][3], S[Semaine][3][3],S[Semaine][4][3]),
                    new Planning("15h30-17h",  S[Semaine][0][4], S[Semaine][1][4], S[Semaine][2][4], S[Semaine][3][4],S[Semaine][4][4]),
                    new Planning("17h15-18h45", S[Semaine][0][5], S[Semaine][1][5], S[Semaine][2][5], S[Semaine][3][5],S[Semaine][4][5]),
                    new Planning("19h-20h30", S[Semaine][0][6], S[Semaine][1][6], S[Semaine][2][6], S[Semaine][3][6],S[Semaine][4][6]),

            };
            for (int i = 0; i < 52; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int y = 0; y < 7; y++) {
                        if(S[i][j][y].getId_Seance() != 0){
                            System.out.println("Semaine "+i+" jours "+j +" craineau horaire "+y);
                            System.out.println(S[i][j][y].getId_Seance());
                        }

                    }
                }
            }
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return title[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return data[rowIndex].getHeure();
                case 1:
                    return data[rowIndex].lundi;
                case 2:
                    return data[rowIndex].mardi;
                case 3:
                    return data[rowIndex].mercredi;
                case 4:
                    return data[rowIndex].jeudi;
                case 5:
                    return data[rowIndex].vendredi;
                default:
                    return "";
            }
        }

        // SERT A CHANGER LE BOOLEEN DES JOURS DE LA SEMAINE


        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnIndex == 0 ? String.class : Seance.class;
        }
    }

    public class Planning {

        private String heure;
        private Seance lundi;
        private Seance mardi;
        private Seance mercredi;
        private Seance jeudi;
        private Seance vendredi;

        public Planning(String heure, Seance lundi, Seance mardi, Seance mercredi,Seance jeudi, Seance vendredi) {
            this.heure = heure;
            this.lundi = lundi;
            this.mardi = mardi;
            this.mercredi = mercredi;
            this.jeudi = jeudi;
            this.vendredi = vendredi;

        }

        public String getHeure() {
            return heure;
        }

    }


    public class ColorCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            System.out.println( value.getClass());
            if (column > 0) {


                if (value instanceof Seance) {

                    if (((Seance)value).getId_Seance() != 0) {
                        //((JLabel) c).setText(); = new JTextArea( s.getCours()+"\n" +s.getProf() +"\n"+s.getSalle());
                        ((JLabel) c).setText("<html>"+((Seance)value).getCours()+"<br>"+ ((Seance)value).getProf()+"<br>"+((Seance)value).getSalle()+"</html>");
                        Color color = new Color(((Seance)value).getId_Seance()*70%255, ((Seance)value).getId_Seance()*120%255, ((Seance)value).getId_Seance()*26%255);
                        c.setBackground(color);
                    } else {
                        ((JLabel) c).setText("");
                        Color color = new Color(255, 255, 255);
                        c.setBackground(color);
                    }

                    // ALORS ON AFFICHE LE NOM DE LA SEANCE, LA SALLE, LE SITE


                }
            }
            return c;
        }
    }
}
