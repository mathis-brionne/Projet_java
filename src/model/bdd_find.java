package model;

import java.sql.*;
import model.DaoFactory;

public class bdd_find {
    public bdd_find(){}
    public Utilisateur find(String username) throws ClassNotFoundException {
        Utilisateur U = null;
        Connection conn = null;
        try {
                 conn = DaoFactory.getInstance().getConnection();

                // our SQL SELECT query.
                // if you only need a few columns, specify them by name instead of using "*"
                String query = String.format("SELECT * FROM utilisateur WHERE EMAIL = '%s'", username);
                System.out.println(query);
                // create the java statement
                Statement st = conn.createStatement();

                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next())
                {
                    int id = rs.getInt("ID");
                    String email = rs.getString("EMAIL");
                    String passwd = rs.getString("PASSWD");
                    String nom = rs.getString("NOM");
                    String premon = rs.getString("PREMON");
                    int droit = rs.getInt("DROIT");

                    // print the results
                    System.out.format("%d, %s, %s, %s, %s, %d\n", id, email, passwd, nom,premon,droit);
                    U = new Utilisateur(id,droit,email,nom,premon,passwd);
                }
                st.close();
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return U;
    }
}
