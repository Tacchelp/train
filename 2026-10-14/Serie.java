import java.util.ArrayList;

public class Serie extends Media {
    private ArrayList<Media> listeEpisodes;

    public Serie(String title, String author, Media[] l){
        super(title, author);
        this.listeEpisodes = new ArrayList<>();
        for(Media m : l) this.listeEpisodes.add(m);
    }

    public double moyenneAgregee(){
        int c = 0;
        for(Media m : this.listeEpisodes) c += m.moyenneNotes();
        return (this.moyenneNotes() + (c / this.listeEpisodes.size())) / 2.;
    }
}
