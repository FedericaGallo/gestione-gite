package Service;

import Entity.Docente;
import Repository.DocenteRepository;

import java.util.List;

public class DocenteService {
    DocenteRepository docenteRepository = new DocenteRepository();
    //CREATE
    public void create(String nome, String cognome) {
        Docente oDocente = new Docente();
        oDocente.setCognome(cognome);
        oDocente.setNome(nome);
        docenteRepository.createDocente(oDocente);
    }
    //READ
    public List<Docente>  readDocente(){
        return docenteRepository.readDocente();
    }
    //DELETE
    public void delete(int id) {
        Docente oDocente = new Docente();
        oDocente.setId(id);
        docenteRepository.deleteDocente(oDocente);
    }
    //UPDATE
    public void update(int id, String nome, String cognome) {
        Docente oDocente = new Docente();
        oDocente.setNome(nome);
        oDocente.setCognome(cognome);
        oDocente.setId(id);
        docenteRepository.updateDocente(oDocente);
    }
}
