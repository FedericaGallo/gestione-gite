package Service;

import Entity.ClasseGita;
import Entity.Gita;
import Entity.Classe;
import Repository.ClasseGitaRepository;
import Repository.GitaRepository;
import Repository.ClasseRepository;
import java.time.LocalDate;

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
}
