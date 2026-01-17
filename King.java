public class King extends Piece {
    private static final char ABBREV = 'K';

    public King(Color color, Square startSquare) {
        super(color, ABBREV, startSquare);
    }
}
