import java.util.ArrayList;

public class QCM{
    private ArrayList<Question> q;

    public QCM(ArrayList<Question> q){
        this.q = q;
    }

    public int Ask(){
        int c = 0;
        for (Question q : this.q){
            boolean b = q.ask();
            if (b){
                System.out.println("Bonne reponse !");
                c++;
            } else System.out.println("Mauvaise réponse..");
        }
        return c;
    }

    
    public static void main(String[] args){
        Question a, b;
        ArrayList<Reponse> ra, rb;
        ra = new ArrayList<>();
        ra.add(new Reponse("Le nombre 1 est premier", false));
        ra.add(new Reponse("Il en existe une infinité", true));
        ra.add(new Reponse("Un nombre pair peut être premier", true));
        ra.add(new Reponse("Le produit de deux nombres premiers est premier", false));
        a = new Question("À propos des nombres premiers :",ra);


        rb = new ArrayList<>();
        rb.add(new Reponse("Nuageux", true));
        rb.add(new Reponse("Pluvieux", true));
        rb.add(new Reponse("Orageux", false));
        b = new Question("Quel temps fait-il aujourd'hui.", rb);

        ArrayList<Question> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        QCM test = new QCM(l);
        int c = test.Ask();
        System.out.println("Votre score est de : " + c);

    }

}