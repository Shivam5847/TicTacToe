package Models;
import Strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    Player Winner;
    List<Move> moves;
    int nextPlayerIndex;
    List<WinningStrategy> winningStrategies;
    GameState gameState;

    public Game(int dimension,List<Player>players,List<WinningStrategy>
            winningStrategies){
        this.board=new Board(dimension);
        this.players=players;
        this.Winner=null;
        this.moves=new ArrayList<>();
        this.nextPlayerIndex=0;
        this.winningStrategies=winningStrategies;
        this.gameState=GameState.IN_PROGRESS;
    }

    public void undo(){
        if(moves.size()==0){
            System.out.println("Nothing to undo");
        }
        Move lastMove=moves.get(moves.size()-1);
        moves.remove(moves.size()-1);

        lastMove.getCell().setCellState(CellState.EMPTY);
        lastMove.getCell().setSymbol(null);

        nextPlayerIndex-=1;
        nextPlayerIndex=(nextPlayerIndex+players.size())%players.size();

    }
    public void displayBoard(){
        board.display();
    }
    boolean validateMove(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        if(row<0 || row>=board.getDimension() || col<0 || col>=board.getDimension()) return false;
        if(!board.getGrid().get(row).get(col).getCellState().equals(CellState.EMPTY)) return false;
        return true;
    }
    public void makeMove(){
        Player currentPlayer=players.get(nextPlayerIndex);
        System.out.println("Hey "+currentPlayer.getName()+" its your turn " +
                "Please make a move");
        Move move=currentPlayer.makeMove();
        if(!validateMove(move)) {
            System.out.println("dang se chal be");
            return;
        };
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell cellTOChange=board.getGrid().get(row).get(col);
        cellTOChange.setCellState(CellState.FILLED);
        cellTOChange.setSymbol(currentPlayer.getPlayerSymbol());

        nextPlayerIndex+=1;
        nextPlayerIndex%=players.size();
        move.setPlayer(currentPlayer);
        move.setCell(cellTOChange);
        moves.add(move);

        if(checkWinner(board,move)){
            gameState=GameState.SUCCESS;
            Winner=currentPlayer;
        }
        else if(moves.size()== board.getDimension()*board.getDimension()){
            gameState=GameState.DRAW;
        }
    }

    public boolean checkWinner(Board board,Move move) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, move)) return true;
        }
            return false;
    }
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        int dimension;
        List<Player> players;
        List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Game build(){
            validate();
            return new Game(this.dimension,this.players,this.winningStrategies);
        }
        void validate(){
            validatePlayers();
            validateBotCount();
            validateSymbol();
        }
        void validatePlayers(){
               if(players.size()!=dimension-1) throw new RuntimeException("players are correct");
        }
        void validateBotCount(){
              int botCount=0;
              for(Player player:players){
                  if(player.getPlayerType().equals(PlayerType.BOT)) botCount+=1;
              }

              if(botCount>1) throw new RuntimeException("ek se jyda ni hona chaiye");
        }
        void validateSymbol(){

        }
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public Player getWinner() {
        return Winner;
    }
    public void setWinner(Player winner) {
        Winner = winner;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }
    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }
    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
