package MazeSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Maze {
    private ArrayList<ArrayList<MazeSquare>> mazeList;
    boolean solved;
    int startx;
    int starty;

    public Maze() {
        solved = false;
        mazeList = new ArrayList<>();
    }

    public ArrayList<ArrayList<MazeSquare>> getMazeList() {
        return mazeList;
    }

    public void fillMaze(String mazeString) {
        List<String> lines = mazeString.lines().collect(Collectors.toList());
        for (int y = 0; y < lines.size(); y++) {
            ArrayList<MazeSquare> mazeRow = new ArrayList<>();
            String line = lines.get(y);

            for (int x = 0; x < line.length(); x++) {
                mazeRow.add(new MazeSquare(line.charAt(x),x,y));
                if (mazeRow.get(mazeRow.size()-1).type == 'S') {
                    startx = x;
                    starty = y;
                }
            }
            mazeList.add(mazeRow);
        }

    }

    public MazeSquare getSquare(int y, int x) {
        return mazeList.get(y).get(x);
    }

    @Override
    public String toString() {
        StringBuilder mazeString = new StringBuilder();
        mazeList.forEach(row -> {
            row.forEach(square -> mazeString.append(square));
            mazeString.append("\n");
        });
        return mazeString.toString();
    }

    public int getStartx() {
        return startx;
    }

    public int getStarty() {
        return starty;
    }
}
