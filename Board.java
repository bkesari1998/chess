class Board {
    private final int NUM_RANKS = 8;
    private final int NUM_FILES = 8;

    private final int WHITE_MINOR_START_RANK_IDX = 1;
    private final int WHITE_MAJOR_START_RANK_IDX = 0;
    private final int BLACK_MINOR_START_RANK_IDX = 6;
    private final int BLACK_MAJOR_START_RANK_IDX = 7;

    private final int A_FILE_IDX = 0;
    private final int B_FILE_IDX = 1;
    private final int C_FILE_IDX = 2;
    private final int D_FILE_IDX = 3;
    private final int E_FILE_IDX = 4;
    private final int F_FILE_IDX = 5;
    private final int G_FILE_IDX = 6;
    private final int H_FILE_IDX = 7;

    private final Square[][] squares;

    public Board() {
        squares = new Square[NUM_RANKS][NUM_FILES];
        
        Color tmpColor = Color.WHITE;
        for (int i = 0; i < NUM_RANKS; ++i) {
            for (int j = 0; j < NUM_FILES; ++j) {
                squares[i][j] = new Square(tmpColor);
            }
        }

        placePiecesInStartingPositions();
    }

    private void placePiecesInStartingPositions() {
        placePawnsInStartingPositions(Color.WHITE, WHITE_MINOR_START_RANK_IDX);
        placePawnsInStartingPositions(Color.BLACK, BLACK_MINOR_START_RANK_IDX);
        placeRooksInStartingPositions(Color.WHITE, WHITE_MAJOR_START_RANK_IDX);
        placeRooksInStartingPositions(Color.BLACK, BLACK_MAJOR_START_RANK_IDX);
        placeKnightsInStartingPositions(Color.WHITE, WHITE_MAJOR_START_RANK_IDX);
        placeKnightsInStartingPositions(Color.BLACK, BLACK_MAJOR_START_RANK_IDX);
        placeBishopsInStartingPositions(Color.WHITE, WHITE_MAJOR_START_RANK_IDX);
        placeBishopsInStartingPositions(Color.BLACK, BLACK_MAJOR_START_RANK_IDX);
        placeQueenInStartingPosition(Color.WHITE, WHITE_MAJOR_START_RANK_IDX);
        placeQueenInStartingPosition(Color.BLACK, BLACK_MAJOR_START_RANK_IDX);
        placeKingInStartingPosition(Color.WHITE, WHITE_MAJOR_START_RANK_IDX);
        placeKingInStartingPosition(Color.BLACK, BLACK_MAJOR_START_RANK_IDX);
    }

    private void placePawnsInStartingPositions(Color color, int startRankIndex) {
        Square[] startRank = this.squares[startRankIndex];
        for (Square square : startRank) {
            square.placePiece(new Pawn(color, square));
        }
    }

    private void placeRooksInStartingPositions(Color color, int startRankIndex) {
        Square startSquareAFile = this.squares[startRankIndex][A_FILE_IDX];
        startSquareAFile.placePiece(new Rook(color, startSquareAFile));

        Square startSquareHFile = this.squares[startRankIndex][H_FILE_IDX];
        startSquareHFile.placePiece(new Rook(color, startSquareHFile));
    }

    private void placeKnightsInStartingPositions(Color color, int startRankIndex) {
        Square startSquareBFile = this.squares[startRankIndex][B_FILE_IDX];
        startSquareBFile.placePiece(new Knight(color, startSquareBFile));

        Square startSquareGFile = this.squares[startRankIndex][G_FILE_IDX];
        startSquareGFile.placePiece(new Knight(color, startSquareGFile));
    }

    private void placeBishopsInStartingPositions(Color color, int startRankIndex) {
        Square startSquareCFile = this.squares[startRankIndex][C_FILE_IDX];
        startSquareCFile.placePiece(new Bishop(color, startSquareCFile));

        Square startSquareFFile = this.squares[startRankIndex][F_FILE_IDX];
        startSquareFFile.placePiece(new Bishop(color, startSquareFFile));
    }

    private void placeQueenInStartingPosition(Color color, int startRankIndex) {
        Square startSquareDFile = this.squares[startRankIndex][D_FILE_IDX];
        startSquareDFile.placePiece(new Queen(color, startSquareDFile));
    }

    private void placeKingInStartingPosition(Color color, int startRankIndex) {
        Square startSquareEFile = this.squares[startRankIndex][E_FILE_IDX];
        startSquareEFile.placePiece(new King(color, startSquareEFile));
    }

    public void printBoard() {
        System.out.println("    a b c d e f g h");
        System.out.println("  +-----------------+");
        for (int rank = NUM_RANKS - 1; rank >= 0; rank--) {
            System.out.print((rank + 1) + " | ");
            for (int file = 0; file < NUM_FILES; file++) {
                Piece piece = squares[rank][file].getPiece();
                System.out.print(getPieceSymbol(piece) + " ");
            }
            System.out.println("| " + (rank + 1));
        }
        System.out.println("  +-----------------+");
        System.out.println("    a b c d e f g h");
    }

    private char getPieceSymbol(Piece piece) {
        if (piece == null) {
            return '.';
        }

        return piece.color == Color.WHITE ? piece.abbrev : Character.toLowerCase(piece.abbrev);
    }
}