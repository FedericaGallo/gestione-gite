package Repository;

import Config.DbConnection;
import Entity.Classe;
import Entity.Docente;
import Entity.Gita;
import Repository.DocenteRepository;

import java.sql.*;
import java.util.ArrayList;
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
    public ArrayList <Classe> readClasse(){
        DocenteRepository docenteRepository = new DocenteRepository();
        ArrayList<Classe> listaClasse = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.anno, c.sezione, d.nome, d.cognome, c.id AS id_classe, d.id AS id_docente FROM classe c JOIN docente d  ON d.id=c.id_docente;");
            while (rs.next()) {
                Classe oClasse = new Classe();
                oClasse.setAnno(rs.getInt("anno"));
                oClasse.setSezione(rs.getString("sezione").charAt(0));
                oClasse.setId(rs.getInt("id_classe"));
                Docente oDocente= docenteRepository.readDocenteById(rs.getInt("id_docente"));
                oClasse.setCoordinatore(oDocente);
                listaClasse.add(oClasse);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaClasse;
    }
    public Classe readClasseById(int id){
       DocenteRepository docenteRepository = new DocenteRepository();
       Classe oClasse= new Classe();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM classe WHERE id= " + id);

            while (rs.next()) {

                oClasse.setId(rs.getInt("id"));
                oClasse.setAnno(rs.getInt("anno"));
                oClasse.setSezione(rs.getString("sezione").charAt(0));
                Docente oDocente = docenteRepository.readDocenteById(rs.getInt("id_docente"));
                oClasse.setCoordinatore(oDocente);

            }
        }catch (ClassNotFoundException|SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return oClasse;
    }
}
