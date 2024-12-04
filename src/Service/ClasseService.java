package Service;

import Entity.Classe;
import Entity.Docente;
import Repository.ClasseRepository;
import Repository.DocenteRepository;
import jdk.jfr.internal.Repository;

import java.util.ArrayList;

public class ClasseService {
    ClasseRepository classeRepository=new ClasseRepository();
    DocenteRepository docenteRepository=new DocenteRepository();
    public void create(int anno, char sezione, int id) {
        Docente oDocente = new Docente();
        Classe oClasse = new Classe();
        oClasse.setAnno(anno);
        oClasse.setSezione(sezione);
        oDocente = docenteRepository.readDocenteById(id);
        oClasse.setCoordinatore(oDocente);
        classeRepository.createClasse(oClasse);
    }
    public ArrayList<Classe> readClasse(){
        return classeRepository.readClasse();
    }
    public void update(int anno, char sezione, int id, int idCoordinatore) {
        Classe oClasse = new Classe();
        oClasse.setAnno(anno);
        oClasse.setSezione(sezione);
        oClasse.setId(id);
        Docente oDocente = docenteRepository.readDocenteById(idCoordinatore);
        oClasse.setCoordinatore(oDocente);
        classeRepository.updateClasse(oClasse);
    }
    public void delete(int id){

            Classe oClasse = new Classe();
            oClasse.setId(id);
            classeRepository.deleteDocente(oClasse);

    }
}
