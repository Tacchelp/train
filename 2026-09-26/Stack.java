public class Stack {
    private Cell top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize(){
        return this.size;
    }

    public void push(Object o){
        this.top = new Cell(o, this.top);
        this.size++;
    }

    public Object pop(){
        Object o = top.getElt();
        this.top = this.top.getNextCell();
        this.size--;
        return o;
    }

    

}
