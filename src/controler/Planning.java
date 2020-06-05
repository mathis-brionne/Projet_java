package controler;

import model.Seance;
import model.Seance_DAO;
import model.Seance_Salle_DAO;

import java.util.ArrayList;
import java.util.List;

public class Planning {
    public  Planning(){}

    private Seance[][][] Seances = new Seance[52][5][7];
    public  Planning(ArrayList<Integer> Id_seance) {
        System.out.println(Id_seance.size());
        Seance_DAO seance_dao = new Seance_DAO();
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 5; j++) {
                for (int y = 0; y < 7; y++) {
                    for (int z = 0; z<Id_seance.size(); z++)
                    {
                        Seances[i][j][y] = seance_dao.finds(i, j ,y, Id_seance.get(z));
                        if (Seances[i][j][y].getId_Seance()!=0){
                            break;
                        }
                    }

                }
            }
        }
    }
    public Seance[][][] getSeances() {
        return Seances;
    }

}