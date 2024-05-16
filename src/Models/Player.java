package Models;

import java.util.Scanner;

public class Player {
    int id;
    String name;
    PlayerType playerType;
    Symbol playerSymbol;
    Scanner scanner;
    public int getId() {
        return id;
    }
    public Player(int id,String name,PlayerType playerType,Symbol symbol){
        this.id=id;
        this.name=name;
        this.playerType=playerType;
        this.playerSymbol=symbol;
        this.scanner= new Scanner(System.in);
    }
    public Move makeMove(){
        System.out.println("Please enter the row");
        int row=scanner.nextInt();
        System.out.println("Please enter the col");
        int col= scanner.nextInt();
        return new Move(new Cell(row,col),this);
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }
    public void setPlayerSymbol(Symbol playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
}
