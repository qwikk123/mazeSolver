package qwikk.mazeSolver.service;

import MazeSolver.Maze;
import MazeSolver.MazeSolver;
import MazeSolver.MazePair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MazeServiceImpl implements MazeService {

    @Override
    public String getMaze(String mazeString) {
        Maze maze = new Maze();
        maze.fillMaze(mazeString);
        MazeSolver mazeSolver = new MazeSolver();
        List<MazePair> pathList = new ArrayList<>();
        mazeSolver.DFS(maze, maze.getStartx(), maze.getStarty(), pathList);
        for (MazePair p : pathList) {
            maze.getSquare(p.y(),p.x()).setType('+');
        }
        return maze.toString();
    }
}
