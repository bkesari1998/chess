public class Pawn extends Piece {
    private static final char ABBREV = 'P';

    public Pawn(Color color, Square startSquare) {
        super(color, ABBREV, startSquare);
    }
}
