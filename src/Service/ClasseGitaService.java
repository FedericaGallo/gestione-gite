package Service;

import Entity.ClasseGita;
import Entity.Docente;
import Entity.Gita;
import Entity.Classe;
import Repository.ClasseGitaRepository;
import Repository.GitaRepository;
import Repository.ClasseRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClasseGitaService {
    ClasseGitaRepository classeGitaRepository= new ClasseGitaRepository();
    GitaRepository gitaRepository = new GitaRepository();
    ClasseRepository classeRepository = new ClasseRepository();
    //CREATE
    public void create(int idGita, int idClasse, LocalDate dataPartenzaFormatted, LocalDate dataRitornoFormatted) {
        ClasseGita oClasseGita = new ClasseGita();
        oClasseGita.setDataRitorno(dataRitornoFormatted);
        oClasseGita.setDataPartenza(dataPartenzaFormatted);
        Gita oGita =gitaRepository.readGitaById(idGita);
        Classe oClasse= classeRepository.readClasseById(idClasse);
        oClasseGita.setGita(oGita);
        oClasseGita.setClasse(oClasse);
        classeGitaRepository.createClasseGita(oClasseGita);
    }
    //READ
    public List<ClasseGita> readClasseGita(){
        return classeGitaRepository.readClasseGita();
    }
    //DELETE
    public void delete(int id) {
        ClasseGita oClasseGita = new ClasseGita();
        oClasseGita.setId(id);
        classeGitaRepository.deleteClasseGita(oClasseGita);
    }
    //UPDATE
    public void update(int id, int idGita, int idClasse, LocalDate dataPartenzaFormatted, LocalDate dataRitornoFormatted) {
        ClasseGita oClasseGita = new ClasseGita();
        oClasseGita.setDataRitorno(dataPartenzaFormatted);
        oClasseGita.setDataPartenza(dataRitornoFormatted);
        oClasseGita.setId(id);
        Gita oGita =gitaRepository.readGitaById(idGita);
        Classe oClasse= classeRepository.readClasseById(idClasse);
        oClasseGita.setGita(oGita);
        oClasseGita.setClasse(oClasse);
        classeGitaRepository.updateClasseGita(oClasseGita);
    }
}
