public class Queen extends Piece {
    private static final char ABBREV = 'Q';

    public Queen(Color color, Square startSquare) {
        super(color, ABBREV, startSquare);
    }
}
