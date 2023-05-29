package MazeSolver;

import java.util.List;
import java.util.Stack;

public class MazeSolver {

    public boolean DFS(Maze maze, int x, int y, List<MazePair> pathList) {
        if (isValid(maze.getSquare(y,x).type)) {
            if (maze.getSquare(y,x).type == 'E') {return true;}
            maze.getSquare(y,x).type = '·';
            if (DFS(maze, x-1,y,pathList)) {pathList.add(new MazePair(x,y)); return true;}
            if (DFS(maze, x,y-1,pathList)) {pathList.add(new MazePair(x,y)); return true;}
            if (DFS(maze, x+1,y,pathList)) {pathList.add(new MazePair(x,y)); return true;}
            if (DFS(maze, x,y+1,pathList)) {pathList.add(new MazePair(x,y)); return true;}
        }
        return false;
    }

    public Maze iterative(Maze maze) {
        Stack<MazePair> stack = new Stack<>();
        int x = maze.startx;
        int y = maze.starty;
        stack.push(new MazePair(x,y));
        while (maze.getMazeList().get(y).get(x).type != 'E') {
            maze.getMazeList().get(y).get(x).type = '·';
            if (isJunction(x,y, maze)) {stack.push(new MazePair(x,y));}
            if (isValid(maze.getSquare(y,x-1).type)) x--;
            else if (isValid(maze.getSquare(y-1,x).type)) y--;
            else if (isValid(maze.getSquare(y,x+1).type)) x++;
            else if (isValid(maze.getSquare(y+1,x).type)) y++;
            else {
                MazePair newStart = stack.pop();
                x = newStart.x();
                y = newStart.y();
            }
        }
        maze.getSquare(y,x).type = 'D';
        return maze;
    }

    public boolean isJunction(int x, int y, Maze maze) {
        int validOptions = 0;
        if (isValid(maze.getSquare(y,x-1).type)) validOptions++;
        if (isValid(maze.getSquare(y+1,x).type)) validOptions++;
        if (isValid(maze.getSquare(y,x+1).type)) validOptions++;
        if (isValid(maze.getSquare(y-1,x).type)) validOptions++;
        return validOptions > 1;

    }

    public boolean isValid(char c) {
        return !(c == '#' || c == '·');
    }
}
