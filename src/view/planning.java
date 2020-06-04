package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class planning extends JFrame {

    //JToggleButton btngreen;
    //JButton valid = new JButton("Confirmer");
    ModeleStatique model = new ModeleStatique();
    JTable table;
    boolean test;

    public static void main(String[] args) {
        planning thf = new planning();
    }

    public planning() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelHaut = new JPanel();


        table = new JTable(model);
        table.setDefaultRenderer(Boolean.class, new ColorCellRenderer());

        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setDefaultRenderer(String.class, new ColorCellRenderer());



        add(panelHaut);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panelHaut, BorderLayout.NORTH);
        pack();
        setVisible(true);

    }

    public class ModeleStatique extends AbstractTableModel {

        private final Planning[] data;

        private final String[] title = { null, "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi" };

        public ModeleStatique() {
            super();

            data = new Planning[] {
                    new Planning("8h30-10h", false, false, false, false,false),
                    new Planning("10h15-11h45", false, false, false, false,false),
                    new Planning("12h-13h30", false, false, false, false,false),
                    new Planning("13h45-15h15", false, false, false, false,false),
                    new Planning("15h30-17h", false, false, false, false,false),
                    new Planning("17h15-18h45", false, false, false, false,false),
                    new Planning("19h-20h30", false, false, false, false,false),

            };
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
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            switch (columnIndex) {
                case 1:
                    data[rowIndex].lundi = !data[rowIndex].lundi;
                    break;
                case 2:
                    data[rowIndex].mardi = !data[rowIndex].mardi;
                    break;
                case 3:
                    data[rowIndex].mercredi = !data[rowIndex].mercredi;
                    break;
                case 4:
                    data[rowIndex].jeudi = !data[rowIndex].jeudi;
                    break;
                case 5:
                    data[rowIndex].vendredi = !data[rowIndex].vendredi;
                    break;
                default:
                    break;
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnIndex == 0 ? String.class : Boolean.class;
        }
    }

    public class Planning {

        private String heure;
        private boolean lundi;
        private boolean mardi;
        private boolean mercredi;
        private boolean jeudi;
        private boolean vendredi;

        public Planning(String heure, boolean lundi, boolean mardi, boolean mercredi,boolean jeudi, boolean vendredi) {
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

        public void setLundi(boolean lundi) {
            this.lundi = lundi;
        }

        public boolean isLundi() {
            return lundi;
        }

        public boolean isMardi() {
            return mardi;
        }

        public void setMardi(boolean mardi) {
            this.mardi = mardi;
        }

        public boolean isMercredi() {
            return mercredi;
        }

        public void setMercredi(boolean mercredi) {
            this.mercredi = mercredi;
        }

        public boolean isJeudi() {
            return jeudi;
        }

        public void setJeudi(boolean jeudi) {
            this.jeudi = jeudi;
        }
        public boolean isVendredi() {
            return vendredi;
        }

        public void setVendredi(boolean vendredi) {
            this.vendredi = vendredi;
        }

        public void setHeure(String Heure) {
            this.heure = heure;
        }

    }


    public class ColorCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (column > 0) {

                ((JLabel) c).setText("");
                if ((boolean) value) {
                    // ALORS ON AFFICHE LE NOM DE LA SEANCE, LA SALLE, LE SITE
                    //c.setBackground(Color.green);
                }
                else {
                    //RIEN
                    //c.setBackground(Color.white);
                }
            }
            return c;
        }
    }
}
