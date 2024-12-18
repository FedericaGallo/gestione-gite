import java.util.*;

import Entity.ClasseGita;
import Repository.ClasseGitaRepository;
import Repository.DocenteRepository;
import Service.DocenteService;
import Service.ClasseService;
import Service.GitaService;
import Service.ClasseGitaService;
import Entity.Docente;
import Entity.Classe;
import Entity.Gita;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class ScuolaInformatica {
    public static void main(String[] args) {
         //gestisciDettagliGite();
        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        int choiceEntity;
        System.out.println("1. Per gestire i docenti");
        System.out.println("2. Per gestire le classi");
        System.out.println("3. Per gestire le gite");
        System.out.println("4. Per gestire le gite pianificate");
        System.out.println("5. Query varie");
        choiceEntity = scanner.nextInt();

        switch (choiceEntity){
            case 1:
                gestisciDocente();
                break;
            case 2:
                gestisciClasse();
                break;
            case 3:
                gestisciGita();
                break;
            case 4:
                gestisciDettagliGite();
                break;
            case 5:
                faiDelleQuery();
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
                    updateClasse();
                    break;
                case 3:
                    readClasse();
                    break;
                case 4:
                    deleteClasse();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Scelta errata, scegli un numero da 1 a 4");

            }
        }while(choice!=9);


    }
    public static void gestisciGita(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Crea una nuova gita");
            System.out.println("2. Aggiorna una gita");
            System.out.println("3. Visualizza la lista delle gite");
            System.out.println("4. Elimina una gita");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            choice= scanner.nextInt();

            switch (choice){
                case 1:
                    createGita();
                    break;
                case 2:
                    updateGita();
                    break;
                case 3:
                    readGita();
                    break;
                case 4:
                    deleteGita();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Scelta errata, scegli un numero da 1 a 4");

            }
        }while(choice!=9);
    }
    public static void gestisciDettagliGite(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Pianifica una nuova gita");
            System.out.println("2. Modifica una gita pianificata");
            System.out.println("3. Visualizza la lista delle gite pianificate");
            System.out.println("4. Elimina una gita pianificata");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            choice= scanner.nextInt();

            switch (choice){
                case 1:
                    createClasseGita();
                    break;
                case 2:
                    updateClasseGita();
                    break;
                case 3:
                   readClasseGita();
                    break;
                case 4:
                    deleteClasseGita();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Scelta errata, scegli un numero da 1 a 4");

            }
        }while(choice!=9);


    }
    public static void faiDelleQuery(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Cerca le gite in programma tra un intervallo di date");
            System.out.println("2. Cerca le gite di una classe ");
            System.out.println("3. ");
            System.out.println("4. Cerca i docenti che partecipano a più gite");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            choice= scanner.nextInt();

            switch (choice){
                case 1:
                    readClasseGitaByDate();
                    break;
                case 2:
                    readClasseGitaByClasse();
                    break;
                case 3:

                    break;
                case 4:
                    readDocentiConPiuDiUnaGita();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Scelta errata, scegli un numero da 1 a 4");

            }
        }while(choice!=9);

    };
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
        //System.out.println(oDocenteService.hashCode());
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
        readClasse();
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id della classe da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci il nuovo anno:");
        int anno = scanner.nextInt();
        System.out.println("inserisci la nuova sezione:");
        char sezione = scanner.next().charAt(0);
        readDocente();
        System.out.println("inserisci l'id del nuovo coordinatore:");
        int idCoordinatore = scanner.nextInt();
        ClasseService oClasseService = new ClasseService();
        oClasseService.update(anno, sezione, id, idCoordinatore);
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
        readClasse();
        System.out.println("Elimina la classe con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        ClasseService oClasseService = new ClasseService();
        oClasseService.delete(id);
    }
    //CRUD GITA
    public static void readGita(){
        System.out.println("ecco la lista delle gite: ");
        GitaService oGitaService = new GitaService();
        List<Gita> listaGita= oGitaService.readGita();
        //System.out.println(oDocenteService.hashCode());
        int i = 0;
        while(i<listaGita.size()){
            System.out.println(listaGita.get(i).getId()+" "+listaGita.get(i).getDestinazione()+", coordinatore gita: "+listaGita.get(i).getDocenteCognome()+" "+listaGita.get(i).getDocenteNome() );
            i++;}
    }
    public static void createGita(){
        try{
            System.out.println("inserisci destinazione: ");
            Scanner scanner = new Scanner(System.in);
            String destinazione = scanner.nextLine();
            readDocente();
            System.out.println("inserisci l'id del docente coordinatore della gita: ");
            int id_docente = scanner.nextInt();
            scanner.nextLine();
            GitaService oGitaService = new GitaService();
            oGitaService.create(destinazione, id_docente);
        }catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }
    public static void deleteGita(){
        readGita();
        System.out.println("Elimina la gita con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        GitaService oGitaService = new GitaService();
        oGitaService.delete(id);
    }
    public static void updateGita(){
        readGita();
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id della gita da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci la nuova destinazione:");
        scanner.nextLine();
        String destinazione = scanner.nextLine();
        readDocente();
        System.out.println("inserisci l'id del nuovo coordinatore:");
        int idCoordinatore = scanner.nextInt();
        GitaService oGitaService = new GitaService();
        oGitaService.update(id, destinazione, idCoordinatore);
    }
    //CRUD CLASSEGITA
    public static void createClasseGita(){
        try{
            readClasse();
            System.out.println("inserisci id classe: ");
            Scanner scanner = new Scanner(System.in);
            int idClasse = scanner.nextInt();
            readGita();
            System.out.println("inserisci id gita: ");
            int idGita = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Inserisci la data di partenza nel formato YYYY-MM-DD: ");
            String dataPartenza = scanner.nextLine();
            System.out.print("Inserisci la data di ritorno nel formato YYYY-MM-DD: ");
            String dataRitorno = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataPartenzaFormatted = LocalDate.parse(dataPartenza, formatter);
            LocalDate dataRitornoFormatted = LocalDate.parse(dataRitorno, formatter);

            ClasseGitaService oClasseGitaService = new ClasseGitaService();
            oClasseGitaService.create(idGita, idClasse, dataPartenzaFormatted, dataRitornoFormatted);
        }catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }
    public static void readClasseGita(){
        System.out.println("ecco la lista delle gite programmate: ");
        ClasseGitaService oClasseGitaService = new ClasseGitaService();
        List<ClasseGita> listaClasseGita= oClasseGitaService.readClasseGita();
        //System.out.println(oDocenteService.hashCode());
        int i = 0;
        while(i<listaClasseGita.size()){
            System.out.println(listaClasseGita.get(i).getId()+" "+listaClasseGita.get(i).getGitaDettagli()+", coordinatore classe: "+listaClasseGita.get(i).getClasseCoordinatore()+ ", dal "+ listaClasseGita.get(i).getDataPartenza()+ " al " + listaClasseGita.get(i).getDataRitorno());
            i++;}
    }
    public static void updateClasseGita(){
        readClasseGita();
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id della gita programmata da modificare:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci la data di partenza nel formato YYYY-MM-DD: ");
        String dataPartenza = scanner.nextLine();
        System.out.println("Inserisci la data di ritorno nel formato YYYY-MM-DD: ");
        String dataRitorno = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataPartenzaFormatted = LocalDate.parse(dataPartenza, formatter);
        LocalDate dataRitornoFormatted = LocalDate.parse(dataRitorno, formatter);
        readGita();
        System.out.println("inserisci l'id della gita");
        int idGita = scanner.nextInt();
        readClasse();
        System.out.println("inserisci l'id della classe");
        int idClasse = scanner.nextInt();
        ClasseGitaService oClasseGitaService = new ClasseGitaService();
        oClasseGitaService.update(id, idGita, idClasse, dataPartenzaFormatted, dataRitornoFormatted);
    }
    public static void deleteClasseGita(){
        readClasseGita();
        System.out.println("Elimina la gita programmata con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        ClasseGitaService oClasseGitaService = new ClasseGitaService();
        oClasseGitaService.delete(id);
    }
    // QUERY VARIE
    public static void readClasseGitaByDate(){
        ClasseGitaRepository classeGitaRepository = new ClasseGitaRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la prima data dell'intervallo nel formato YYYY-MM-DD: ");
        String primaData = scanner.nextLine();
        System.out.print("Inserisci la seconda data dell'intervallo nel formato YYYY-MM-DD: ");
        String secondaData = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataPartenzaFormatted = LocalDate.parse(primaData, formatter);
        LocalDate dataRitornoFormatted = LocalDate.parse(secondaData, formatter);
        ArrayList<ClasseGita> listaClasseGita=classeGitaRepository.readByDateInterval(dataPartenzaFormatted, dataRitornoFormatted);
        int i = 0;
        while(i<listaClasseGita.size()){
            System.out.println(listaClasseGita.get(i).getId()+". " + "classe: "+ listaClasseGita.get(i).getClasseNome()+ " dal "+listaClasseGita.get(i).getDataPartenza()+" al "+listaClasseGita.get(i).getDataRitorno()+" coordinatore classe: "+listaClasseGita.get(i).getClasseCoordinatore()+" "+listaClasseGita.get(i).getGitaDettagli());
            i++;}


    }

    public static void readClasseGitaByClasse(){
        ClasseGitaRepository classeGitaRepository = new ClasseGitaRepository();
        readClasse();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci l'anno: ");
        int anno = scanner.nextInt();
        System.out.print("Inserisci la sezione: ");
        char sezione = scanner.next().charAt(0);
        ArrayList <ClasseGita> listaClasseGita = classeGitaRepository.readByClasse(anno, sezione);
        int i = 0;
        while(i<listaClasseGita.size()){
            System.out.println(listaClasseGita.get(i).getId()+". " + "classe: "+ listaClasseGita.get(i).getClasseNome()+ " dal "+listaClasseGita.get(i).getDataPartenza()+" al "+listaClasseGita.get(i).getDataRitorno()+" coordinatore classe: "+listaClasseGita.get(i).getClasseCoordinatore()+" "+listaClasseGita.get(i).getGitaDettagli());
            i++;}
    }

    public static void readDocentiConPiuDiUnaGita(){
        DocenteRepository docenteRepository = new DocenteRepository();
        HashMap<Docente, Integer> docentiCountGita = docenteRepository.readDocentiConPiuDiUnaGita();
        for (Docente i : docentiCountGita.keySet()) {
            System.out.println("docente: " + i.getCognome() + i.getNome()+ " partecipa a gite n: " + docentiCountGita.get(i));
        }
    }


}