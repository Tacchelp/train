public class Livre extends Media {
    private int nbPages;

    public Livre(String title, String author, int nbPages){
        super(title, author);
        this.nbPages = nbPages;
    }

    public int getNbPages(){ return this.nbPages;}

}
