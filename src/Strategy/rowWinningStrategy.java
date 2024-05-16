package Strategy;

import Models.Board;
import Models.CellState;
import Models.Move;
import Models.Symbol;

public class rowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getPlayerSymbol();
        int count=0;

        for(int i=0;i<board.getDimension();i++){
            if(board.getGrid().get(row).get(i).getCellState().equals(CellState.FILLED)){
                if(board.getGrid().get(row).get(i).getSymbol().getSym()==symbol.getSym()) {
                    count+=1;
                }
            }
        }
        if(count==board.getDimension()){
            //System.out.println("yes it is");
            return true;
        }
        return false;
    }
}
