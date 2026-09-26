public class HashTable {
    private HashCell[]  t;
    private int     size;

    public HashTable(){
        this.t = new HashCell[8];
        this.size = 0;
    }

    public void put(Object k, Object v){
        if(this.contains(k)) this.remove(k);
        if(this.size + 1 >= this.t.length) this.extend(); 
        int slot = k.hashCode() % this.t.length;
        this.size++;
        this.t[slot] = new HashCell(k, v, this.t[slot]);

    }

    public boolean contains(Object k){
        HashCell slot = this.t[k.hashCode() % this.t.length];
        while(slot != null) if(slot.hasKey(k)) return true;
        return false;
    }

    public Object get(Object k){
        if(this.contains(k)){
            HashCell slot = this.t[k.hashCode() % this.t.length];
            while(!slot.hasKey(k)) slot = slot.getNextCell();
            return slot.getValue();
        }
        else throw new Error("");
    }

    public void remove(Object k){
        if(this.contains(k)){
            int s = k.hashCode() % this.t.length;
            HashCell slot = this.t[s];
            if(slot.hasKey(k)) this.t[s] = this.t[s].getNextCell();
            else{
                while(!slot.getNextCell().hasKey(k)) slot = slot.getNextCell();
                slot.setNextCell(slot.getNextCell().getNextCell());
            }
        }
        else throw new Error("");
    }

    public void extend(){
        HashCell[] tab = new HashCell[this.t.length * 2];
        for(int i = 0; i < this.t.length; i++){
            HashCell a = this.t[i];
            while(a != null){

                Object k = a.getKey();
                Object v = a.getValue();
                int new_slot = k.hashCode() % (this.t.length * 2);
                tab[new_slot] = new HashCell(k, v, tab[new_slot]);

                a = a.getNextCell();
            }
        }
        this.t = tab;
    }


}
