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
    //CREATE
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
    //TROVA GITE PROGRAMMATE DALLA DATA ALLA DATA
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
    //TROVA LE GITE PROGRAMMATE PER UNA CLASSE
    public ArrayList<ClasseGita> readByClasse(int anno, char sezione){
        ArrayList<ClasseGita> listaGita = new ArrayList<>();
        GitaRepository gitaRepository = new GitaRepository();
        ClasseRepository classeRepository = new ClasseRepository();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classe_gita cg JOIN classe c ON c.id=cg.id_classe  WHERE c.anno = " + "'"+anno +"'"+ " AND c.sezione = " + " '" + sezione+ " '");
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
    //DELETE
    public void deleteClasseGita(ClasseGita oClasseGita) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM classe_gita WHERE id = '" + oClasseGita.getId() + "'");
            System.out.println("model.dao.ClasseGita eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    //UPDATE
    public void updateClasseGita(ClasseGita oClasseGita) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE classe_gita SET id_gita='"+oClasseGita.getGitaId()+"', id_classe='"+oClasseGita.getClasseId()+ "', data_partenza='"+oClasseGita.getDataPartenza()+"', data_ritorno='"+oClasseGita.getDataRitorno()+ "' WHERE id ="  + oClasseGita.getId());
            System.out.println("model.dao.Docente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<ClasseGita> readClasseGita(){
        ArrayList<ClasseGita> listaGita = new ArrayList<>();
        GitaRepository gitaRepository = new GitaRepository();
        ClasseRepository classeRepository = new ClasseRepository();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classe_gita ORDER BY data_partenza");
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
