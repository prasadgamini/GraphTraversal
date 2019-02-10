package edu.graph.maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private int[][] map;
    private int numOfRows;
    private int numOfColumns;
    private int startPositionRow;
    private int startPositionColumn;
    private String mapFilePath;

    public FileReader(int numOfRows, int numOfColumns, String mapFilePath) {
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.mapFilePath = mapFilePath;
        map = new int[numOfRows][numOfColumns];
        parseFile();
    }

    private void parseFile() {
        try (Scanner scanner = new Scanner(new File(mapFilePath))) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = scanner.nextInt();
                    if (map[i][j] == 2) {
                        startPositionRow = i;
                        startPositionColumn = j;
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
}
