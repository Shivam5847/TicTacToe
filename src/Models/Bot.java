package Models;

public class Bot extends Player{
    BotDifficultylevel botDifficultylevel;

    public Bot(int id, String name, PlayerType playerType, Symbol symbol,BotDifficultylevel
               botDifficultylevel) {
        super(id, name, PlayerType.BOT, symbol);
        this.botDifficultylevel=botDifficultylevel;
    }

    public BotDifficultylevel getBotDifficultylevel() {
        return botDifficultylevel;
    }
    public void setBotDifficultylevel(BotDifficultylevel botDifficultylevel) {
        this.botDifficultylevel = botDifficultylevel;
    }
}
