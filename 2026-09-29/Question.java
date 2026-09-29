import java.util.ArrayList;
import java.util.Scanner;

public class Question{
    private String question;
    private  ArrayList<Reponse> reponses;

    private boolean valid(ArrayList<Reponse> t){
        for(Reponse s : t) if(s.getValue()){return true;}
        return false;
    }

    public boolean isValid(){
        return valid(this.reponses);
    }

    public Question(String question, ArrayList<Reponse> reponses){
        if(valid(reponses)){
            this.question = question;
            this.reponses = reponses;
        } else throw  new Error("Le QCM doit contenir au moins une bonne reponse.");
    }

    public String toString(){
        String a = "";
        a = a + this.question + "\n";
        for(int i = 1; i - 1 < reponses.size(); i++){
            a = a + "\t" + i + " - " + this.reponses.get(i - 1) + "\n";
        }
        return a;
    }

    public boolean ask(){
        Scanner sc = new Scanner(System.in);
        System.out.print(this + "\nEntrez votre réponse : ");
        int r = sc.nextInt();
        // sc.close();
        if(0 < r && r - 1 < this.reponses.size()){
            return this.reponses.get(r - 1).getValue();
        } else throw new Error("Index out of bounds.");
        
    }

}