package Repository;

import Entity.ClasseGita;
import Config.DbConnection;
import Entity.Docente;
import Entity.Gita;
import Entity.Classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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
    public ArrayList<ClasseGita> readByDateInterval(LocalDate dataPartenza, LocalDate dataRitorno){
        ArrayList<ClasseGita> listaGita = new ArrayList<>();
        GitaRepository gitaRepository = new GitaRepository();
        ClasseRepository classeRepository = new ClasseRepository();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classe_gita WHERE data_partenza >= " + " '"+dataPartenza +" '"+ " AND data_ritorno <= " + " '" + dataRitorno+ " '");
            while (rs.next()) {
                ClasseGita oClasseGita = new ClasseGita();
                oClasseGita.setDataPartenza(rs.getDate("data_partenza").toLocalDate());
                oClasseGita.setDataRitorno(rs.getDate("data_ritorno").toLocalDate());
                oClasseGita.setId(rs.getInt("id"));
                Gita oGita = gitaRepository.readGitaById(rs.getInt("id_gita"));
                Classe oClasse = classeRepository.readClasseById(rs.getInt("id_classe"));
                oClasseGita.setGita(oGita);
                oClasseGita.setClasse(oClasse);
                listaGita.add(oClasseGita);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaGita;
    }
}
