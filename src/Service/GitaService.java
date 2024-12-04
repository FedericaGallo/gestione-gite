package Service;

import Entity.Classe;
import Entity.Docente;
import Entity.Gita;
import Repository.GitaRepository;
import Repository.DocenteRepository;

import java.util.List;

public class GitaService {
    GitaRepository gitaRepository = new GitaRepository();
    public List<Gita> readGita(){
        return gitaRepository.readGita();
    }
    public void update(int id, String destinazione, int idCoordinatore) {
        DocenteRepository docenteRepository = new DocenteRepository();
        Gita oGita = new Gita();
        oGita.setId(id);
        oGita.setDestinazione(destinazione);
        Docente oDocente = docenteRepository.readDocenteById(idCoordinatore);
        oGita.setDocente(oDocente);
        gitaRepository.updateGita(oGita);
    }
    public void delete(int id){

        Gita oGita = new Gita();
        oGita.setId(id);
        gitaRepository.deleteGita(oGita);

    }
    public void create(String destinazione, int id_docente) {
        DocenteRepository docenteRepository = new DocenteRepository();
        Gita oGita = new Gita();
        Docente oDocente = new Docente();
        oGita.setDestinazione(destinazione);
        oDocente = docenteRepository.readDocenteById(id_docente);
        oGita.setDocente(oDocente);
        gitaRepository.createGita(oGita);
    }
}
