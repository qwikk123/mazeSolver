package MazeSolver;

import MazeSolver.Maze;
import MazeSolver.MazePair;
import MazeSolver.MazeSolver;

import java.util.ArrayList;
import java.util.List;

public class MazeMain {
    public static void main(String[] args) {
        String mazeString1 = """
                ##########
                #S       #
                ######## #
                #        #
                ######## #
                # #  #   #
                # #  #   #
                #        #
                #E########""";
        String mazeString2 = """
                ##########
                #S       #
                ######## #
                #        #
                ######## #
                E #  #   #
                # #  #   #
                #        #
                ##########""";
        String mazeString3 = """
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
        Maze maze1 = new Maze();
        maze1.fillMaze(mazeString1);
        Maze maze2 = new Maze();
        maze2.fillMaze(mazeString2);
        Maze maze3 = new Maze();
        maze3.fillMaze(mazeString3);


        System.out.println(maze1);
        System.out.println(mazeSolver.iterative(maze1));
        System.out.println("-----------------------------");
        System.out.println(maze2);
        System.out.println(mazeSolver.iterative(maze2));
        System.out.println("-----------------------------");
        System.out.println(maze3);
        List<MazePair> pathList = new ArrayList<>();
        mazeSolver.DFS(maze3,maze3.getStartx(),maze3.getStarty(), pathList);
        for (MazePair p : pathList) {
            maze3.getSquare(p.y(),p.x()).setType('+');
        }
        System.out.println(maze3);
        System.out.println("-----------------------------");
    }
}
