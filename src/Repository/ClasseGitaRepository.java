package Repository;

import Entity.ClasseGita;
import Config.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClasseGitaRepository {
    public void createClasseGita(ClasseGita oClasseGita) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO classe_gita VALUES('" + oClasseGita.getGitaId() + "','" + oClasseGita.getClasseId() + "','" + oClasseGita.getDataPartenza() + "','" + oClasseGita.getDataRitorno() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
