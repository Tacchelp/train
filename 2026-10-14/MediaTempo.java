public class MediaTempo extends Media{
    private int duree;

    public MediaTempo(String title, String author, int duree){
        super(title, author);
        this.duree = duree;
    }

    public int getDuration(){ return this.duree;}

}
