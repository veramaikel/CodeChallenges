package grid.robotgrid;

import java.io.Serializable;

public record Square(int row, int col) implements Serializable {

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (col != square.col) return false;
        return row == square.row;
    }

    @Override
    public int hashCode() {
        int result = col;
        result = 31 * result + row;
        return result;
    }

    @Override
    public String toString() {
        return "Square{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}
