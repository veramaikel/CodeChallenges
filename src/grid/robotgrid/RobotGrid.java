package grid.robotgrid;

import java.util.Set;

/*
    Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
    The robot can only move in two directions, right and down,
    but certain cells are "off limits" such that the robot cannot step on them.
    Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class RobotGrid {

    public static void main(String[] arg){
        Grid grid = new Grid(getTest1());
        System.out.println("\nBeginning");
        grid.printBoard();

        Set<Square> route = grid.getRoute();
        System.out.println("\nRoute");
        grid.printRoute(route);

    }

    public static String[] getTest1(){

        return new String[]{
                "R#......",
                "........",
                "........",
                "........",
                ".#......",
                "........",
                "........",
                "..######",
                ".......X"};
    }

}
