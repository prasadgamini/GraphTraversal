package edu.graph.maze;

public class MazeSolver {

    private int[][] map;
    private boolean[][] visitMap;
    private int startPositionRow;
    private int startPositionColumn;

    public MazeSolver(int[][] map, int startPositionRow, int startPositionColumn) {
        this.map = map;
        this.visitMap = new boolean[map.length][map[0].length];
        this.startPositionRow = startPositionRow;
        this.startPositionColumn = startPositionColumn;
    }

    public void findWayOut() {
        try {
            dfs(startPositionRow, startPositionColumn);
            System.out.println("Solution not found");
        } catch (RouteFoundException e) {
            System.out.println("Route found to exit");
        }
    }

    private void dfs(int rowIndex, int columnIndex) {
        System.out.println(rowIndex + " , " + columnIndex);
        if (map[rowIndex][columnIndex] == 3) {
            // This is the success scenario, but we are identifying with the help of Exception
            throw new RouteFoundException();
        }


        if (visitMap[rowIndex][columnIndex] == true) {
            return; // Skipping as it is already visited
        } else if (rowIndex < 0 || rowIndex > map.length) {
            return; // Row index out of map
        } else if (columnIndex < 0 || columnIndex > map[rowIndex].length) {
            return; // Column index out of map
        } else if (map[rowIndex][columnIndex] == 1) {
            return; // It's a wall, we can't go in this direction
        } else {
            this.visitMap[rowIndex][columnIndex] = true;
            dfs(rowIndex + 1, columnIndex); // going down
            dfs(rowIndex, columnIndex + 1); // going right
            dfs(rowIndex, columnIndex - 1); // going left
            dfs(rowIndex - 1, columnIndex); // going up

        }
    }

}
