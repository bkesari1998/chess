class Board {
    public final int NUM_RANKS = 8;
    public final int NUM_FILES = 8;

    private final Square[][] squares;

    public Board() {
        squares = new Square[NUM_FILES][NUM_RANKS];
        
        Color tmpColor = Color.WHITE;
        for (int i = 0; i < NUM_FILES; ++i) {
            for (int j = 0; j < NUM_RANKS; ++j) {
                squares[i][j] = new Square(tmpColor);
            }
        }
    }
}