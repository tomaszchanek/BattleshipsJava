package battleship;

import java.time.temporal.ValueRange;
import java.util.Objects;

public class Position {

    int row;
    int col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public boolean positionInBounds() {
        ValueRange range = ValueRange.of(0, Board.BOARD_SIZE - 1);
        return range.isValidIntValue(this.col) && range.isValidIntValue(this.row);
    }

    //--STATICS---------------------------------------------------------------------------------------------------------
    //--Core parsers between internal state and display state of positions (A -> 1 etc.)--------------------------------
    //------------------------------------------------------------------------------------------------------------------
    static public int stringNum2Int(String num) throws IllegalArgumentException {
        if (Board.colStr2Int.containsKey(num)){
            return Board.colStr2Int.get(num);
        } else {
            throw new IllegalArgumentException(String.format("Error! Expected a number between 1 and %d. Try again:", Board.BOARD_SIZE));
        }
    }

    static public int stringLetter2Int(String letter) throws IllegalArgumentException {
        if (Board.rowStr2Int.containsKey(letter)){
            return Board.rowStr2Int.get(letter);
        } else {
            throw new IllegalArgumentException(String.format("Error! Expected a single capital letter between A and %s. Try again:", Board.rowInt2Str.get(Board.BOARD_SIZE - 1)));
        }
    }

    static public String integer2StringNum(int number) throws IllegalArgumentException {
        if (Board.colInt2Str.containsKey(number)){
            return Board.colInt2Str.get(number);
        } else {
            throw new IllegalArgumentException(String.format("Error! Expected a number between 0 and %d. Try again:", Board.BOARD_SIZE - 1));
        }
    }

    static public String integer2StringLetter(int number) throws IllegalArgumentException {
        if (Board.rowInt2Str.containsKey(number)){
            return Board.rowInt2Str.get(number);
        } else {
            throw new IllegalArgumentException(String.format("Error! Expected a number between 0 and %d. Try again:", Board.BOARD_SIZE - 1));
        }
    }
}


