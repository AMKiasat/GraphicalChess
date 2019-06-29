import javax.swing.*;

/**
 * This is an abstract peace for every chessmen
 *
 * @author Amir Mojtaba Kiasat
 * @version 1.0
 * @since 5-15-2019
 */
public abstract class Man {

    int x;
    int y;
    String name;
    private Boolean selected;
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

    public Icon getManIcon() {
        return manIcon;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    /**
     * @param x      final x
     * @param y      final y
     * @param ground the ground which the man moves on
     * @return true if the move is allowed and move it to x and y otherwise it's false
     */
    abstract boolean movement(int x, int y, Ground ground);

    /**
     * @param x      final x
     * @param y      final y
     * @param ground the array if the all chess mans
     * @return true if the move is allowed otherwise it's false
     */
    abstract boolean check(int x, int y, Man[][] ground);

    /**
     * @param x      final x
     * @param y      final y
     * @param ground the array if the all chess mans
     * @return true if the move is allowed otherwise it's false
     */
    abstract boolean canMove(int x, int y, Ground ground);
}
