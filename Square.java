public class Square {
    public final Color color;

    private Piece occupyingPiece;

    public Square(Color color) {
        this.color = color;
        this.occupyingPiece = null;
    }
    
    void placePiece(Piece piece) {
        this.occupyingPiece = piece;
    }

    Piece getPiece() {
        return this.occupyingPiece;
    }
}
