package Entity;

import java.time.LocalDate;

public class ClasseGita {
    private int id;
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

    public void setId(int id){
        this.id=id;
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

    public String getClasseCoordinatore(){
        return this.classe.getCoordinatoreNome() + " " + this.classe.getCoordinatoreCognome();
    }
    public String getClasseNome(){
        return this.classe.getAnno()+ " " + this.classe.getSezione();
    }
    public String getGitaDettagli(){
        return "destinazione " + this.gita.getDestinazione() + " docente coordinatore: " + this.gita.getDocenteNome() + " " + this.gita.getDocenteCognome();
    }
    public int getId(){
        return this.id;
    }
}
