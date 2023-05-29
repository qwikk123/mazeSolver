package MazeSolver;

public class MazeSquare {
    char type;
    int x;
    int y;

    public MazeSquare(char type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
