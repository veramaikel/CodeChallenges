package grid.robotgrid;

public enum SquareValue {
    BLOCK('#'), EMPTY('.'), START('R'), TARGET('X');

    private final char value;
    SquareValue(char value){
        this.value = value;
    }

    public char getValue(){
        return value;
    }
}
