import javax.swing.*;

public abstract class Man {

    int x;
    int y;
    String name;
    Boolean selected;
    Icon manIcon;


    public Man(int x, int y, String name) {
        this.y = y;
        this.x = x;
        this.name = name;
        selected = false;

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

    public Boolean getSelected() {
        return selected;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    abstract boolean movement(int x, int y, Ground ground);

    abstract boolean check(int x, int y, Man[][] ground);

    abstract boolean canMove(int x, int y, Ground ground);

    public Icon getManIcon() {
        return manIcon;
    }
}
