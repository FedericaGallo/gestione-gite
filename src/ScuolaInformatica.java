import java.util.List;
import java.util.Scanner;
import Service.DocenteService;
import Service.ClasseService;
import Entity.Docente;
import Entity.Classe;
public class ScuolaInformatica {
    public static void main(String[] args) {

        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        int choiceEntity;
        System.out.println("1. Per gestire i docenti");
        System.out.println("2. Per gestire le classi");
        System.out.println("3. Per gestire le gite");
        System.out.println("4. Per gestire i dettagli delle uscite didattiche");
        choiceEntity = scanner.nextInt();

        switch (choiceEntity){
            case 1:
                gestisciDocente();
                break;
            case 2:
                gestisciClasse();
                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("scelta errata. scegliere un numero da 1 a 4");
        }



    }
    public static void gestisciDocente(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Crea un nuovo docente");
            System.out.println("2. Aggiorna un docente");
            System.out.println("3. Visualizza la lista dei docenti");
            System.out.println("4. Elimina un docente");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            choice= scanner.nextInt();

            switch (choice){
                case 1:
                    createDocente();
                    break;
                case 2:
                    updateDocente();
                    break;
                case 3:
                    readDocente();
                    break;
                case 4:
                    deleteDocente();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Scelta errata, scegli un numero da 1 a 4");

            }
        }while(choice!=9);


    }
    public static void gestisciClasse(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Crea una nuova classe");
            System.out.println("2. Aggiorna una classe");
            System.out.println("3. Visualizza la lista delle classi");
            System.out.println("4. Elimina una classe");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            choice= scanner.nextInt();

            switch (choice){
                case 1:
                    createClasse();
                    break;
                case 2:
                    updateDocente();
                    break;
                case 3:
                    readClasse();
                    break;
                case 4:
                    deleteDocente();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Scelta errata, scegli un numero da 1 a 4");

            }
        }while(choice!=9);


    }
//CRUD DOCENTE
    public static void createDocente(){
      try{
             System.out.println("inserisci nome: ");
             Scanner scanner = new Scanner(System.in);
             String nome = scanner.nextLine();
             System.out.println("inserisci cognome: ");
             String cognome = scanner.nextLine();
             DocenteService oDocenteService = new DocenteService();
             oDocenteService.create(nome, cognome);
       }catch(Exception e){
          System.out.println("Something went wrong.");
        }

    }
    public static void updateDocente(){

            readDocente();
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserisci l'id del docente da modificare:");
            int id = scanner.nextInt();
            System.out.println("inserisci il nuovo nome:");
            String nome = scanner.next();
            System.out.println("inserisci il nuovo cognome:");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.update(id, nome, cognome);


    }
    public static void readDocente(){
        System.out.println("ecco la lista dei docenti: ");
        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti= oDocenteService.readDocente();
        System.out.println(oDocenteService.hashCode());
        int i = 0;
        while(i<listaDocenti.size()){
            System.out.println(listaDocenti.get(i).getId()+" "+listaDocenti.get(i).getCognome()+" "+listaDocenti.get(i).getNome());
            i++;}
    }
    public static void deleteDocente(){
        readDocente();
        System.out.println("Elimina il docente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DocenteService oDocenteService = new DocenteService();
        oDocenteService.delete(id);
    }
//CRUD CLASSE
    public static void createClasse(){
        try{
            System.out.println("inserisci anno: ");
            Scanner scanner = new Scanner(System.in);
            int anno = scanner.nextInt();
            System.out.println("inserisci sezione: ");
            char sezione = scanner.next().charAt(0);
            readDocente();
            System.out.println("inserisci l'id del coordinatore");
            int idCoordinatore = scanner.nextInt();
            ClasseService oClasseService = new ClasseService();
            oClasseService.create(anno, sezione, idCoordinatore);
        }catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }
    public static void updateClasse(){

    }
    public static void readClasse(){
        System.out.println("ecco la lista delle classi: ");
        ClasseService oClasseService = new ClasseService();
        List<Classe> listaClasse= oClasseService.readClasse();
        //System.out.println(oDocenteService.hashCode());
        int i = 0;
        while(i<listaClasse.size()){
            System.out.println(listaClasse.get(i).getId()+" "+listaClasse.get(i).getAnno()+" "+listaClasse.get(i).getSezione()+" "+listaClasse.get(i).getCoordinatoreNome()+" "+listaClasse.get(i).getCoordinatoreCognome() );
            i++;}
    }
    public static void deleteClasse(){

    }
    //CRUD GITA
    //CRUD CLASSE GITA
}