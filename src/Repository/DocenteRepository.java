package Repository;
import Entity.Docente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import Config.DbConnection;
public class DocenteRepository {
    //CREATE
    public void createDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO docente VALUES('" + oDocente.getNome() + "','" + oDocente.getCognome() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    //READ
    public ArrayList<Docente> readDocente () {
        ArrayList<Docente> listaDocenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Docente ORDER BY id asc");
            while (rs.next()) {
                Docente oDocente = new Docente();
                oDocente.setNome(rs.getString("nome"));
                oDocente.setCognome(rs.getString("cognome"));
                oDocente.setId(rs.getInt("id"));
                listaDocenti.add(oDocente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDocenti;
    }

    public Docente readDocenteById(int id){
        Docente oDocente= new Docente();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM docente WHERE id= " + id);

            while (rs.next()) {

                oDocente.setNome(rs.getString("nome"));
                oDocente.setCognome(rs.getString("cognome"));
                oDocente.setId(rs.getInt("id"));

            }
        }catch (ClassNotFoundException|SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return oDocente;
    }
    //DELETE
    public void deleteDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM Docente WHERE id = '" + oDocente.getId() + "'");
            System.out.println("model.dao.Docente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    //UPDATE
    public void updateDocente(Docente oDocente) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE Docente SET nome='"+oDocente.getNome()+"', cognome='"+oDocente.getCognome()+"' WHERE id ="  + oDocente.getId());
            System.out.println("model.dao.Docente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public HashMap<Docente, Integer> readDocentiConPiuDiUnaGita(){
        HashMap<Docente, Integer> docentiCountGita = new HashMap<>();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cd.nome, cd.cognome, COUNT(*) FROM classe_gita cg "+
            "JOIN classe c ON cg.id_classe=c.id "+
            "JOIN docente cd ON c.id_docente= cd.id "+
            "JOIN gita g ON cg.id_gita=g.id "+
           "JOIN docente gd ON g.id_docente= gd.id "+
            "GROUP BY (cd.nome, cd.cognome) "+
            " HAVING COUNT(*)>1 "+
           " UNION "+
            "SELECT gd.nome, gd.cognome, COUNT(*) FROM classe_gita cg "+
            "JOIN classe c ON cg.id_classe=c.id "+
            "JOIN docente cd ON c.id_docente= cd.id "+
            "JOIN gita g ON cg.id_gita=g.id "+
            "JOIN docente gd ON g.id_docente= gd.id "+
            "GROUP BY (gd.nome, gd.cognome) "+
            " HAVING COUNT(*)>1;");

            while (rs.next()) {
                Docente oDocente= new Docente();
                oDocente.setNome(rs.getString("nome"));
                oDocente.setCognome(rs.getString("cognome"));
                int count = rs.getInt("count");
                docentiCountGita.put(oDocente, count);

            }
        }catch (ClassNotFoundException|SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return docentiCountGita;
    }
}


