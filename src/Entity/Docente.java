package Entity;

public class Docente {
    private String nome;
    private String cognome;
    private int id;

    public void setNome(String nome){
        this.nome=nome;
    }
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public int getId(){
        return id;
    }
}
