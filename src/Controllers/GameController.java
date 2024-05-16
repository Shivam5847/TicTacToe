package Controllers;

import Models.Game;
import Models.GameState;
import Models.Player;
import Strategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy>
            winningStrategies){
        return Game.
                getBuilder().
                setWinningStrategies(winningStrategies).
                setDimension(dimension).
                setPlayers(players).build();
    }
    public void displayBoard(Game game){
           game.displayBoard();
    }
    public void makeMove(Game game){
            game.makeMove();
    }
    public GameState checkState(Game game){
                return game.getGameState();
    }
    public Player getWinner(Game game){
          return game.getWinner();
    }
    public void undo(Game game){
        game.undo();
    }
}
