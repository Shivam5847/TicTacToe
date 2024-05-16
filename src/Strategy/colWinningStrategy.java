package Strategy;

import Models.Board;
import Models.Move;

public class colWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
