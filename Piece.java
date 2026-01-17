public abstract class Piece {
    public final Color color;
    public Square currentSquare;

    public Piece(Color color, Square startSquare) {
        this.color = color;
        this.currentSquare = startSquare;
    }
}
