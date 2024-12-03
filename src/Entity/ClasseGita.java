package Entity;

import java.time.LocalDate;

public class ClasseGita {
    private LocalDate dataPartenza;
    private LocalDate dataRitorno;
    private Classe classe;
    private Gita gita;

    public void setDataPartenza(LocalDate dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public void setDataRitorno(LocalDate dataRitorno) {
        this.dataRitorno = dataRitorno;
    }

    public void setGita(Gita gita) {
        this.gita = gita;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    public LocalDate getDataPartenza(){
        return dataPartenza;
    }
    public LocalDate getDataRitorno(){
        return dataRitorno;
    }
    public int getClasseId(){
        return this.classe.getId();
    }
    public int getGitaId(){
        return this.gita.getId();
    }
}
