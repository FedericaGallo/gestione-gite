package Entity;

public class Classe {
    private int anno;
    private char sezione;
    private Docente coordinatore;
    private int id;

    public void setAnno(int anno){
        this.anno=anno;
    }
    public void setSezione(char sezione){
        this.sezione=sezione;
    }
    public void setCoordinatore(Docente coordinatore){
        this.coordinatore=coordinatore;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public int getAnno(){
        return anno;
    }
    public char getSezione(){
        return sezione;
    }
    public int getCoordinatoreId(){
      return this.coordinatore.getId();
    }

}
