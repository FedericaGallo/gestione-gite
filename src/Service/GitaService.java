package Service;

import Entity.Gita;
import Repository.GitaRepository;

import java.util.List;

public class GitaService {
    GitaRepository gitaRepository = new GitaRepository();
    public List<Gita> readGita(){
        return gitaRepository.readGita();
    }
}
