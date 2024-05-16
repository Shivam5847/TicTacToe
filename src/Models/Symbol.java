package Models;

public class Symbol {
    char sym;
    String color;
    public Symbol(char symbol,String color){
        this.sym=symbol;
        this.color=color;
    }
    public char getSym() {
        return sym;
    }
    public void setSym(char sym) {
        this.sym = sym;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
