public class Video extends MediaTempo {
    private String[] subTitle;

    public Video(String title, String author, String[] subTitle, int duree){
        super(title, author, duree);
        this.subTitle = subTitle;
    }

}
