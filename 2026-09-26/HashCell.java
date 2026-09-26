public class HashCell {
    private Object key, value;
    private HashCell   nextCell;

    public HashCell(Object key, Object value, HashCell nextCell){
        this.key        = key;
        this.value      = value;
        this.nextCell   = nextCell;
    }

    public Object getKey()      { return this.key;      }
    public Object getValue()    { return this.value;    }
    public HashCell   getNextCell() { return this.nextCell; }

    public void setNextCell(HashCell nextCell) { this.nextCell = nextCell;}
    public void setValue   (Object value)    { this.value    = value;   } 
    
    public boolean hasKey(Object key) { return this.key.equals(key);}

}
