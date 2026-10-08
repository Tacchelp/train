import java.util.Iterator;

public class BitSet implements Set, Iterable<Integer>{
    private boolean[] tab;

    public BitSet(int maxSize){
        this.tab = new boolean[maxSize];
        for(int i = 0; i < this.tab.length; i++) this.tab[i] = false;
    }

    public int cardinal(){
        int c = 0;
        for(boolean b : this.tab) if(b) c++;
        return c;
    }

    public boolean contains(Integer i){
        return this.tab[i.intValue()];
    }

    public boolean add(Integer i){
        if(this.contains(i)) return false;
        else{
            this.tab[i.intValue()] = true;
            return true;
        }
    }
    public boolean remove(Integer i){
        if(!this.contains(i)) return false;
        else{
            this.tab[i.intValue()] = false;
            return true;
        }
    }

    public Set clone(){
        Set s = new BitSet(this.tab.length);
        for(int i = 0; i< this.tab.length; i++) if(this.contains(i)) s.add(i);
        return s;
    }

    public String toString(){
        String s = "[";
        for(int i = 0; i < this.tab.length; i++){
            if(this.tab[i]) s += i + ", ";
        }
        return s + "]";
    }

    public boolean include(Set s){
        for(int i = 0; i < this.tab.length; i++){
            if(this.contains(i) && !s.contains(i)) return false;
        }
        return true;
    }

    public boolean equals(Set s){
        return s.include(this) && this.include(s);
    }



    
    private class BitSetIterator implements Iterator<Integer>{
        private boolean[] tab;
        private int i;

        public BitSetIterator(boolean[] tab){
            this.tab = tab;
            this.i = 0;
        }

        private int getNextPos(){
            for(int j = this.i + 1; j < this.tab.length; j++) if(this.tab[j]) return j;
            return -1;
        }

        public boolean hasNext(){
            return this.getNextPos() != -1;
        }

        public Integer next(){
            this.i = this.getNextPos();
            return new Integer(i);
        }
    }



    public Iterator<Integer> iterator(){
        return new BitSetIterator(tab);
    }


    public Set union(Set s){
        Set b = this.clone();
        for(Integer i : s) b.add(i);
        return b;
    }

    public Set intersection(Set s){
        Set b = this.clone();
        for(Integer i : this){
            if(!s.contains(i)) b.remove(i);
        }
        return b;
    }

    

}
