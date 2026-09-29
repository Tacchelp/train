public class Reponse{

    private String intitule;
    private boolean val;


    public Reponse(String intitule, boolean value){
        this.intitule = intitule;
        this.val = value;
    }

    public boolean getValue(){
        return this.val;
    }

    public String toString(){
        return this.intitule;
    }

}