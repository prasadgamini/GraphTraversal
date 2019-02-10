package edu.graph.maze;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The map is loaded from @link{map.txt}
 * 1 1 1 1 1
 * 1 2 0 1 1
 * 1 1 0 1 1
 * 1 1 0 3 1
 * 1 1 1 1 1
 *
 * 2 --> Starting position
 * 3 --> Ending position
 * 1 --> wall
 * 0 --> No wall, u can pass through
 */
public class MazeProblemData {

    private int[][] map;
    private int numOfRows;
    private int numOfColumns;
    private int startPositionRow;
    private int startPositionColumn;
    private String mapFilePath;

    public MazeProblemData(int numOfRows, int numOfColumns, String mapFilePath) {
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.mapFilePath = mapFilePath;
        map = new int[numOfRows][numOfColumns];
        parseFile();
    }

    private void parseFile() {
        try {
            ResourceUtils.getFile(mapFilePath);

            try (Scanner scanner = new Scanner(ResourceUtils.getFile(mapFilePath))) {
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        map[i][j] = scanner.nextInt();
                        if (map[i][j] == 2) {
                            startPositionRow = i;
                            startPositionColumn = j;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int[][] getMap() {
        return map;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfColumns() {
        return numOfColumns;
    }

    public int getStartPositionRow() {
        return startPositionRow;
    }

    public int getStartPositionColumn() {
        return startPositionColumn;
    }

    @Override
    public String toString() {
        StringBuffer mapContentBuffer = new StringBuffer();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                mapContentBuffer.append(map[i][j]).append(" ");
            }
            mapContentBuffer.append("\n");
        }
        return mapContentBuffer.toString();
    }
}
