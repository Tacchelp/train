public class Queue {
    private Cell first, last;
    private int size;

    public Queue(){
        this.first = null;
        this.last  = null;
        this.size  = 0;
    }

    public boolean isEmpty(){return this.size  == 0;}

    public int     getSize(){return this.size;}

    public void enqueue(Object o){
        Cell n = new Cell(o, null);
        if(this.isEmpty()){
            this.first = n;
            this.last  = n;
        }
        else this.last.setNextCell(n);
        size++;
    }

    public Object dequeue(){
        Cell a = this.first;
        this.size--;
        if(this.isEmpty()) this.last = null;
        this.first = this.first.getNextCell();
        return a;
    }
}
