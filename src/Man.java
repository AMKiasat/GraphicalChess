import javax.swing.*;

public abstract class Man {

    int x;
    int y;
    String name;
    Boolean inGame;
    Icon manIcon;

    public Man(int x, int y, String name) {
        this.y = y;
        this.x = x;
        this.name = name;
        inGame = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public Boolean getInGame() {
        return inGame;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setInGame(Boolean inGame) {
        this.inGame = inGame;
    }

    abstract boolean movement(int x, int y, Ground ground);

    abstract boolean check(int x, int y, Man[][] ground);

    public Icon getManIcon() {
        return manIcon;
    }
}
