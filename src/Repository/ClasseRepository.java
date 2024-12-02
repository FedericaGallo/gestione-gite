package Repository;

import Config.DbConnection;
import Entity.Classe;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClasseRepository {
    public void createClasse(Classe oClasse) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO classe VALUES('" + oClasse.getAnno() + "','" + oClasse.getSezione() + "','" + oClasse.getCoordinatoreId() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
