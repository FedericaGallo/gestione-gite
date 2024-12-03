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

    public int getDocenteId(){
       return docente.getId();
    }
    public String getDocenteNome(){
        return docente.getNome();
    }
    public String getDocenteCognome(){
        return docente.getCognome();
    }
    public String getDestinazione(){
        return destinazione;
    }
    public int getId(){
       return id;
    }
}
