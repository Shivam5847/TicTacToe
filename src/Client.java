import Controllers.GameController;
import Models.*;
import Strategy.WinningStrategy;
import Strategy.rowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        Scanner sc = new Scanner(System.in);

        List<Player> players=new ArrayList<>();
        players.add(new Player(1,"Shivam", PlayerType.HUMAN,new Symbol('X',"Red")));
        players.add(new Player(2,"Astha",PlayerType.HUMAN,new Symbol('0',"Green")));
       // players.add(new Player(3,"chulli",PlayerType.BOT,new Symbol('C',"pink")));
        List<WinningStrategy> winningStrategies=new ArrayList<>();
        winningStrategies.add(new rowWinningStrategy());
        Game game=gameController.startGame(3,players,winningStrategies);

        gameController.displayBoard(game);

        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.displayBoard(game);
            if(gameController.checkState(game).equals(GameState.DRAW)){
                System.out.println("Game ends in a draw");
                break;
            }
            else if(gameController.checkState(game).equals(GameState.SUCCESS)){
                System.out.println("Winner is "+gameController.getWinner(game).getName());
                break;
            }
            System.out.println("Anyone wants to Undo ???? (Y/N)");
            String x = sc.next();
            if(x.equals("Y")){
                gameController.undo(game);
                System.out.println("After UNDO : ");
                gameController.displayBoard(game);
            }
        }
    }
}