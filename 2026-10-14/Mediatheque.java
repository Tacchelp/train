import java.util.ArrayList;

public class Mediatheque {
    private ArrayList<Media> bdd;

    public Mediatheque(){
        this.bdd = new ArrayList<>();
    }


    public void add(Media m) { this.bdd.add(m); }
        
    public ArrayList<Media> searchByTitle(String titre){
        ArrayList<Media> l = new ArrayList<>();

        for(Media m : this.bdd) if(m.getTitle().equalsIgnoreCase(titre)) l.add(m);

        return l;
    }

    public ArrayList<Media> searchByAuthor(String author){
        ArrayList<Media> l = new ArrayList<>();
        for(Media m : this.bdd) if(m.getAuthor().equalsIgnoreCase(author)) l.add(m);
        return l;
    }
    

    public ArrayList<Media> filtre(String critere, String valeur){
        ArrayList<Media> l;
        critere = critere.toLowerCase();
        valeur = valeur.toLowerCase();
        switch (critere) {
            case "titre":
                l = searchByTitle(valeur);
                break;
            case "auteur":
                l = searchByAuthor(valeur);
                break;
            case "media":
                l = new ArrayList<>();
                switch (valeur) {
                    case "audio":
                        for(Media m : this.bdd) if(m instanceof Audio) l.add(m);
                        break;
                    case "livre":
                        for(Media m : this.bdd) if(m instanceof Livre) l.add(m);
                        break;
                    case "serie":
                        for(Media m : this.bdd) if(m instanceof Serie) l.add(m);
                        break;
                    case "video":
                        for(Media m : this.bdd) if(m instanceof Video) l.add(m);
                        break;
                    default:
                        throw new Error("Ce type n'existe pas.");
                }
                break;
            default:
                throw new Error("Ce critere n'existe pas.");
        }
        return l;
    }



}
