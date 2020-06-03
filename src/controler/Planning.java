package controler;

import model.Seance;
import model.Seance_DAO;

import java.util.ArrayList;
import java.util.List;

public class Planning {
    public  Planning(){}

    private ArrayList<ArrayList<Seance>> Seances = new ArrayList<ArrayList<Seance>>() ;
    public  Planning(ArrayList<Integer> Id_seance){
        System.out.println(Id_seance.size());
        for (int i = 0 ; i < 52 ; i ++ ){
            Seances.add(new ArrayList<Seance>());

            for (int y= 0 ; y < Id_seance.size(); y++){
                Seances.get(i).add(new Seance_DAO().finds(i , Id_seance.get(y)));
            }
        }
    }

    public ArrayList<ArrayList<Seance>> getSeances() {
        return Seances;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder("");
        for (int i=0 ; i< 52 ; i++){
            for (int y= 0 ; y < Seances.get(i).size() ; y++){
                a.append(Seances.get(i).get(y).getId_Seance());
            }
        }
        return a.toString();
    }
}