import java.util.ArrayList;

public class Media{
    private String title;
    private String author;
    private ArrayList<Integer> l;

    public String toString(){
        return "\"" + title +  "\" par " + author;
    }

    public double moyenneNotes(){
        if(this.l == null) return 0;
        else{
            int c = 0;
            for(Integer i : this.l) c+=i;
            return (double) c / (double) this.l.size();
        }
    }

    public void vote(int n){
        if(0 <= n && n <= 5) this.l.add(n);
        else throw new Error("Le vote doit être compris entre 0 et 5.");
    }

    public Media(String title, String author){
        this.title = title;
        this.author = author;
        this.l = new ArrayList<>();
    }

    public String getAuthor() { return this.author; }
    public String getTitle()  { return this.title;  }

}