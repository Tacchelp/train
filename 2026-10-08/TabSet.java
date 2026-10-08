import java.util.Iterator;

public class TabSet implements Set, Iterable<Integer>{
    
    private Integer[] tab;
    private int size;

    public TabSet(int maxSize){
        this.size = 0;
        this.tab = new Integer[maxSize];
    }

    public boolean contains(Integer i){
        for(int j = 0; j < this.size; j++){
            if (this.tab[j].equals(i)) return true;
        }
        return false;
    }

    public int cardinal(){
        return this.size;
    }

    public boolean add(Integer i){
        if(this.contains(i)) return false;
        else{
            this.tab[this.size] = i;
            this.size++;
            return true;
        }
    }


    public boolean remove(Integer i){
        if(!this.contains(i)) return false;
        else {
            int j;
            for(j = 0; !this.tab[j].equals(i); j++);
            for(int x = j; x < this.size - 1; x++){
                this.tab[x] = this.tab[x + 1];
            }
            size--;
            return true;
        }
    }

    public Set clone(){
        Set c = new TabSet(this.tab.length);
        for(int i = 0; i < this.size; i++) c.add(this.tab[i]);
        return c;

    }

    public String toString(){
        String s = "[";
        for(int i = 0; i < this.size - 1; i++){
            s += this.tab[i].toString() + ", ";
        }
        return s + this.tab[this.size - 1] + "]";
    }

    public boolean include(Set s){
        for(Integer i : this.tab){
            if(this.contains(i) && !s.contains(i)) return false;
        }
        return true;
    }

    public boolean equals(Set s){
        return this.include(s) && s.include(this);
    }


    private class TabSetIterator implements Iterator<Integer>{
    private Integer[] tab;
    private int size;
    private int i;

    public TabSetIterator(Integer[] tab, int size){
        this.size = size;
        this.tab = tab;
    }

    public boolean hasNext(){
        return this.i < this.size;
    }
    public Integer next(){
        this.i++;
        return this.tab[this.i - 1];
    }

}

    public Iterator<Integer> iterator(){
        return new TabSetIterator(tab, size);
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
