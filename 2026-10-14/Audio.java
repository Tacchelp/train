public class Audio extends MediaTempo{
    private String type;

    public Audio(String title, String author, String type, int duree){
        super(title, author, duree);
        this.type = type;
    }
    public Audio(String title, String author, int duree){
        this(title, author, "album", duree);
    }

    public String getType(){ return this.type;}

}
