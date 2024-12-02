package Service;

import Entity.Classe;
import Entity.Docente;
import Repository.ClasseRepository;
import Repository.DocenteRepository;

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
}
