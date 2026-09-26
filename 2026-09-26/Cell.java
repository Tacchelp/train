public class Cell {
    private Object elt;
    private Cell nextCell;

    public Cell(Object elt, Cell nexCell){
        this.elt = elt;
        this.nextCell = nexCell;
    }

    public Object getElt(){
        return this.elt;
    }

    public Cell getNextCell(){
        return this.nextCell;
    }

    public void setNextCell(Cell nextCell){
        this.nextCell = nextCell;
    }
}
