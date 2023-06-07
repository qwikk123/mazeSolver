package MazeSolver;

import java.util.ArrayList;
import java.util.List;

public class MazeMain {
    public static void main(String[] args) {
        String mazeString = """
                ################################
                #S             #               #
                ########       #               #
                #      #       #               #
                #      #       #               #
                #      #       #               #
                #      #                       #
                #      #       #              E#
                #      #       #               #
                #      #       ##########      #
                #      #       #               #
                #      #       #               #
                #      #       #               #
                #              #               #
                ################################""";
        MazeSolver mazeSolver = new MazeSolver();
        Maze maze = new Maze();
        maze.fillMaze(mazeString);

        System.out.println("-----------------------------");
        System.out.println(maze);
        List<MazePair> pathList = new ArrayList<>();
        mazeSolver.DFS(maze,maze.getStartx(),maze.getStarty(), pathList);
        for (MazePair p : pathList) {
            maze.getSquare(p.y(),p.x()).setType('+');
        }
        System.out.println(maze);
        System.out.println("-----------------------------");
    }
}
