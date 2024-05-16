package Models;

public class Cell {
    int row;
    int col;
    CellState cellState;
    Symbol symbol;
    public Cell(int row,int col){
        this.row=row;
        this.col=col;
        this.cellState=CellState.EMPTY;
        this.symbol=null;
    }
    public  void printCell()
    {
        if(this.cellState.equals(CellState.EMPTY)){
            System.out.print("|-|");
        }
        else {
            System.out.print("|"+symbol.getSym()+"|");
        }
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public CellState getCellState() {
        return cellState;
    }
    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
