public abstract class Piece {
    public final Color color;
    public final char abbrev;
    private Square currentSquare;

    public Piece(Color color, char abbrev, Square startSquare) {
        this.color = color;
        this.abbrev = abbrev;
        this.currentSquare = startSquare;
    }
}
