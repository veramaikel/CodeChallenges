package grid.robotgrid;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    SquareValue[][] board;
    Square start;
    Set<Square> visited;

    Grid(String[] board){
        if(board.length > 0) {
            this.board = new SquareValue[board.length][board[0].length()];
            for (int r = 0; r < board.length; r++) {
                String srow = board[r];
                for (int c = 0; c < srow.length(); c++) {
                    char s = srow.charAt(c);
                    if (s == SquareValue.START.getValue()) start = new Square(r, c);
                    this.board[r][c] = getSquareValue(s);
                }
            }
        }
        visited = new HashSet<>();
    }

    Set<Square> getRoute() {
        if (board == null || board.length == 0) return null;

        return getRouteFrom(start);
    }

    Set<Square> getRouteFrom(Square square) {

        if (isBoundOut(square) || isBlock(square) || isVisited(square)) {
            return null;
        }

        if (isTarget(square)){
            return new HashSet<>(){{ add(square); }};
        }

        visited.add(square);

        Set<Square> move;

        move = getRouteFrom(new Square(square.getRow(), square.getCol() + 1));// to right
        if(move != null) {
            move.add(square);
        }
        else {
            move = getRouteFrom(new Square(square.getRow() + 1, square.getCol()));// to down
        }

        if(move != null) {
            move.add(square);
        }

        return move;
    }

    public void printBoard(){

        System.out.println(SquareValue.START.getValue()+" - Robot Start");
        System.out.println(SquareValue.TARGET.getValue()+" - Robot Target");
        System.out.println(SquareValue.BLOCK.getValue()+" - Blocked Square");
        System.out.println(SquareValue.EMPTY.getValue()+" - Free Square");

        for (SquareValue[] squareValues : board) {
            System.out.println();
            for (SquareValue s : squareValues) {
                System.out.print(" " + s.getValue());
            }
        }
        System.out.println();
    }

    public void printRoute(Set<Square> route){

        System.out.println(SquareValue.START.getValue()+" - Robot Move");
        System.out.println(SquareValue.BLOCK.getValue()+" - Blocked Square");
        System.out.println(SquareValue.EMPTY.getValue()+" - Free Square");

        for (int r = 0; r < board.length; r++) {
            System.out.println();
            for (int c = 0; c < board[r].length; c++) {
                SquareValue s = board[r][c];
                if(route != null && route.contains(new Square(r,c))) System.out.print(" R");
                else System.out.print(" "+s.getValue());
            }
        }
        System.out.println();
    }

    private boolean isBoundOut(Square square){
        return (square.getCol() < 0 || square.getRow() < 0 ||
                square.getRow()+1 > board.length || square.getCol()+1 > board[0].length);
    }

    private boolean isVisited(Square square){
        return visited.contains(square);
    }

    private boolean isBlock(Square square){
        return (board[square.getRow()][square.getCol()] == SquareValue.BLOCK);
    }

    private boolean isTarget(Square square){
        return (board[square.getRow()][square.getCol()] == SquareValue.TARGET);
    }

    private SquareValue getSquareValue(char c){
        if (c == SquareValue.START.getValue()) {
            return SquareValue.START;
        } else if (c == SquareValue.BLOCK.getValue()) {
            return SquareValue.BLOCK;
        } else if (c == SquareValue.TARGET.getValue()) {
            return SquareValue.TARGET;
        } else return SquareValue.EMPTY;
    }
}
