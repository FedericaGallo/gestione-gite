package Repository;

import Config.DbConnection;
import Entity.Gita;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Repository.DocenteRepository;
import Entity.Docente;

public class GitaRepository {
    public ArrayList<Gita> readGita () {
        ArrayList<Gita> listaGita = new ArrayList<>();
        DocenteRepository docenteRepository = new DocenteRepository();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Gita ORDER BY id asc");
            while (rs.next()) {
                Gita oGita = new Gita();
                oGita.setDestinazione(rs.getString("destinazione"));
                oGita.setId(rs.getInt("id"));
                Docente oDocente = docenteRepository.readDocenteById(rs.getInt("id_docente"));
                oGita.setDocente(oDocente);
                listaGita.add(oGita);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaGita;
    }
    public Gita readGitaById(int id){
        DocenteRepository docenteRepository= new DocenteRepository();
        Gita oGita= new Gita();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM gita WHERE id= " + id);

            while (rs.next()) {

                oGita.setId(rs.getInt("id"));
                oGita.setDestinazione(rs.getString("destinazione"));
                Docente oDocente = docenteRepository.readDocenteById(rs.getInt("id_docente"));
                oGita.setDocente(oDocente);

            }
        }catch (ClassNotFoundException|SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return oGita;
    }
}
