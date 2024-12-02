package Entity;

import java.time.LocalDate;

public class Gita {
    private Docente docente;
    private String destinazione;
    private int id;

    public void setDocente(Docente docente){
        this.docente = docente;
    }
    public void setDestinazione(String destinazione){
        this.destinazione = destinazione;
    }
    public void setId(int id){
        this.id = id;
    }

    public Docente getDocente(){
       return docente;
    }
    public String getDestinazione(){
        return destinazione;
    }
    public int getId(int id){
       return id;
    }
}
