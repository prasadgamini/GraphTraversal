package edu.graph.maze;

public class MazeSolveApplication {

    public static void main(String[] args) {
        MazeProblemData mazeProblemData = new MazeProblemData(5, 5, "classpath:map.txt");
        System.out.println(mazeProblemData);
        MazeSolver mazeSolver = new MazeSolver(mazeProblemData.getMap(), mazeProblemData.getStartPositionRow(), mazeProblemData.getStartPositionColumn());
        mazeSolver.findWayOut();
    }
}
