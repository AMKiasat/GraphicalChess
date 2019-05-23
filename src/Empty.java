import javax.swing.*;

public class Empty extends Man {

    public Empty(int x, int y, String name) {
        super(x, y, name);
        manIcon = null;
    }

    @Override
    boolean movement(int x, int y, Ground ground) {
        return false;
    }

    @Override
    boolean check(int x, int y, Man[][] ground) {
        return false;
    }

    @Override
    boolean canMove(int x, int y, Ground ground) {
        return false;
    }
}
