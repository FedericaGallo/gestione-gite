package Entity;

import java.time.LocalDate;

public class ClasseGita {
    private LocalDate dataPartenza;
    private LocalDate dataRitorno;
    private Classe classe;
    private Docente docente;

    public void setDataPartenza(LocalDate dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public void setDataRitorno(LocalDate dataRitorno) {
        this.dataRitorno = dataRitorno;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
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
}
