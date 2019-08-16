package application;

import controllers.GameController;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

/**
 * Klasa CheckersBoard służy do rysowania i obsługi planszy do gry w Warcaby.
 * 
 * @author Marek Oleksik
 */
public class CheckersBoard {

	/**
	 * Zmienna określająca wysokość planszy do gry
	 */
	private double boardHeight;
	/**
	 * Zmienna określająca szerokość planszy do gry
	 */
	private double boardWidth;
	/**
	 * Zmienna określająca wysokość pojedynczego pola planszy do gry
	 */
	private double rectangleHeight;
	/**
	 * Zmienna określająca szerokość pojedynczego pola planszy do gry
	 */
	private double rectangleWidth;
	/**
	 * Zmienna typu final określająca ilość kolumn planszy do gry
	 */
	private final int NUMCOLS = 8;
	/**
	 * Zmienna typu final określająca ilość wierszy planszy do gry
	 */
	private final int NUMROWS = 8;
	/**
	 * Zmienna określająca rozmiar pojedynczego pola planszy do gry
	 */
	private double rectangleSize;
	/**
	 * Zmienna typu AnchorPane określająca planszę do gry
	 * 
	 * @see AnchorPane
	 */
	private AnchorPane gameboard = null;
	/**
	 * Tablica typu String określająca aktualny stan pionków na planszy
	 */
	public static String[][] boardString = new String[8][8];
	/**
	 * Tablica typu Tile określająca widok planszy do gry
	 */
	private Tile[][] board = new Tile[NUMCOLS][NUMROWS];
	/**
	 * Obiekt typu Group grupujący poszczególne pola planszy do gry
	 */
	private Group tileGroup = new Group();
	/**
	 * Obiekt typu Group grupujący poszczególne pionki
	 */
	private Group pieceGroup = new Group();

	/**
	 * Domyślny konstruktor klasy CheckersBoard
	 */
	public CheckersBoard() {

	}

	/**
	 * Konstruktor klasy ChceckersBoard przyjmujący dwa parametry:
	 * 
	 * @param boardWidth  - szerokość planszy do gry
	 * @param boardHeight - wysokość planszy do gry
	 */
	public CheckersBoard(double boardWidth, double boardHeight) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}

	/**
	 * Metoda zwracająca planszę do gry
	 * 
	 * @return gameboard
	 */
	public AnchorPane getBoard() {
		return gameboard;
	}

	/**
	 * Metoda zwracająca szerokość planszy do gry
	 * 
	 * @return boardWidth
	 */

	public double getWidth() {
		return boardWidth;
	}

	/**
	 * Metoda zwracająca wysokość planszy do gry
	 * 
	 * @return boardHeight
	 */
	public double getHeight() {
		return boardHeight;
	}

	/**
	 * Metoda zwracająca szerokość pojedynczego pola planszy do gry
	 * 
	 * @return rectangleWidth
	 */
	public double getRectangleWidth() {
		return rectangleWidth;
	}

	/**
	 * Metoda zwracająca wysokość pojedynczego pola planszy do gry
	 * 
	 * @return
	 */
	public double getRectangleHeight() {
		return rectangleHeight;
	}

	/**
	 * Metoda zwracająca rozmiar pojedynczego pola planszy do gry
	 * 
	 * @return
	 */

	public double getRectangleSize() {
		return rectangleSize;
	}

	/**
	 * Metoda typu AnchorPane odpowiedzialna za narysowanie pojedynczych pól i
	 * ustawienie pionków na planszy do gry. Wylicza maksymalną szerokość i wysokość
	 * pojedynczego pola wykorzystując najmniejszy wymiar planszy. Zastosowanie ma
	 * to w przypadku skalowania okna.
	 * 
	 * @see AnchorPane
	 * @return gameboard
	 */
	public AnchorPane build() {

		if (boardWidth < boardHeight) {
			rectangleWidth = boardWidth / NUMCOLS;
			rectangleHeight = boardWidth / NUMROWS;
		} else {
			rectangleWidth = boardHeight / NUMCOLS;
			rectangleHeight = boardHeight / NUMROWS;
		}
		rectangleSize = rectangleWidth;
		gameboard = new AnchorPane();
		gameboard.getChildren().addAll(tileGroup, pieceGroup);
		// Tworzy pojedyncze pola planszy
		for (int x = 0; x < NUMROWS; x++) {
			for (int y = 0; y < NUMCOLS; y++) {

				Tile tile = new Tile((x + y) % 2 == 0, x, y, rectangleWidth, rectangleHeight);
				board[x][y] = tile;

				tileGroup.getChildren().add(tile);

				Piece piece = null;

				if (y <= 2 && (x + y) % 2 != 0) {
					piece = makePiece(PieceType.RED, x, y);
				}

				if (y >= 5 && (x + y) % 2 != 0) {
					piece = makePiece(PieceType.WHITE, x, y);
				}

				if (piece != null) {
					tile.setPiece(piece);
					pieceGroup.getChildren().add(piece);
				}
			}
		}
		return gameboard;
	}

	/**
	 * Metoda typu AnchorPane odpowiedzialna za przerysowanie planszy do gry po
	 * wykonanym ruchu.
	 * 
	 * @see AnchorPane
	 * @return
	 */
	public AnchorPane fill() {

		if (boardWidth < boardHeight) {
			rectangleWidth = boardWidth / NUMCOLS;
			rectangleHeight = boardWidth / NUMROWS;
		} else {
			rectangleWidth = boardHeight / NUMCOLS;
			rectangleHeight = boardHeight / NUMROWS;
		}
		rectangleSize = rectangleWidth;
		gameboard = new AnchorPane();
		gameboard.getChildren().addAll(tileGroup, pieceGroup);
		// Tworzy pojedyncze pola planszy
		for (int x = 0; x < NUMROWS; x++) {
			for (int y = 0; y < NUMCOLS; y++) {

				Tile tile = new Tile((x + y) % 2 == 0, x, y, rectangleWidth, rectangleHeight);
				board[x][y] = tile;

				tileGroup.getChildren().add(tile);

				Piece piece = null;

				// System.out.println(boardServer[x][y]);
				if (boardString[x][y] != null && boardString[x][y].equals("RED")) {
					piece = makePiece(PieceType.RED, x, y);
				}

				if (boardString[x][y] != null && boardString[x][y].equals("WHITE")) {
					piece = makePiece(PieceType.WHITE, x, y);
				}

				if (boardString[x][y] != null && boardString[x][y].equals("KINGWHITE")) {
					piece = makePiece(PieceType.WHITE, x, y);
					piece.makeKing();
				}

				if (boardString[x][y] != null && boardString[x][y].equals("KINGRED")) {
					piece = makePiece(PieceType.RED, x, y);
					piece.makeKing();
				}

				if (piece != null) {
					tile.setPiece(piece);
					pieceGroup.getChildren().add(piece);
				}
			}
		}
		return gameboard;
	}

	/**
	 * Metoda typu MoveResult zwracająca rodzaj ruchu wykonanego przez zawodnika.
	 * Metoda zawiera logikę gry, czyli sposób w jaki zawodnik porusza się pionakmi
	 * po planszy, w jaki sposób następuje bicie oraz kiedy pionek staje się damką.
	 * 
	 * @param piece
	 * @param newX
	 * @param newY
	 * @return
	 */
	private MoveResult tryMove(Piece piece, int newX, int newY) {

		try {

			if (board[newX][newY].hasPiece() || (newX + newY) % 2 == 0 || newX > boardWidth || newY > boardHeight) {
				return new MoveResult(MoveType.NONE);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Wyszedłeś poza pole");
			return new MoveResult(MoveType.NONE);
		}

		int x0 = toBoard(piece.getOldX());
		int y0 = toBoard(piece.getOldY());

		System.out.println("x0= " + x0 + " y0= " + y0);
		System.out.println("newx = " + newX + " newy = " + newY);

		// pionek nie jest damką

		if (!piece.isKing()) {
			if (piece.getType().equals(PieceType.RED) && Math.abs(newX - x0) == 1
					&& newY - y0 == piece.getType().moveDir) {
				if (newY == 7) {
					piece.makeKing();
				}

				return new MoveResult(MoveType.NORMAL);
			} else if (piece.getType().equals(PieceType.WHITE) && Math.abs(newX - x0) == 1
					&& newY - y0 == piece.getType().moveDir) {
				if (newY == 0) {
					piece.makeKing();
				}

				return new MoveResult(MoveType.NORMAL);

			} else if (Math.abs(newX - x0) == 2 && newY - y0 == piece.getType().moveDir * 2) {

				int x1 = x0 + (newX - x0) / 2;
				int y1 = y0 + (newY - y0) / 2;
				System.out.println("x1= " + x1 + " y1= " + y1);
				System.out.println("newY - y0 = " + (newY - y0));

				if (board[x1][y1].hasPiece() && board[x1][y1].getPiece().getType() != piece.getType()) {
					if ((newY == 7) && piece.getType().equals(PieceType.RED)
							|| (newY == 0) && piece.getType().equals(PieceType.WHITE)) {
						piece.makeKing();
					}
					return new MoveResult(MoveType.KILL, board[x1][y1].getPiece());
				}
			}

		}

		// pionek jest damką

		else if (piece.isKing()) {
			if ((piece.getType().equals(PieceType.KINGRED) && Math.abs(newX - x0) == 1)
					|| (piece.getType().equals(PieceType.KINGWHITE) && Math.abs(newX - x0) == 1)) {
				return new MoveResult(MoveType.NORMAL);
			} else if (Math.abs(newX - x0) == 2) {
				int x1 = x0 + (newX - x0) / 2;
				int y1 = y0 + (newY - y0) / 2;
				if (board[x1][y1].hasPiece() && (((board[x1][y1].getPiece().getType().equals(PieceType.KINGRED)
						|| board[x1][y1].getPiece().getType().equals(PieceType.RED))
						&& (piece.getType().equals(PieceType.KINGWHITE) || piece.getType().equals(PieceType.WHITE)))
						|| ((board[x1][y1].getPiece().getType().equals(PieceType.KINGWHITE)
								|| board[x1][y1].getPiece().getType().equals(PieceType.WHITE))
								&& (piece.getType().equals(PieceType.KINGRED)
										|| piece.getType().equals(PieceType.RED))))) {
					return new MoveResult(MoveType.KILL, board[x1][y1].getPiece());
				}
			} else {
				return new MoveResult(MoveType.NONE);
			}
		}

		return new MoveResult(MoveType.NONE);
	}

	private int toBoard(double pixel) {
		return (int) ((pixel + rectangleSize / 2) / rectangleSize);
	}

	/**
	 * Metoda makePiece jest odpowiedzialna za przerysowanie pionka na planszy po
	 * wykonanym ruchu przez zawodnika.
	 * 
	 * @param type
	 * @param x
	 * @param y
	 * @return
	 */
	private Piece makePiece(PieceType type, int x, int y) {
		Piece piece = new Piece(type, x, y, rectangleSize);

		piece.setOnMouseReleased(e -> {
			int newX = toBoard(piece.getLayoutX());
			int newY = toBoard(piece.getLayoutY());
			int x0 = toBoard(piece.getOldX());
			int y0 = toBoard(piece.getOldY());

			MoveResult result = null;
			try {
				if (newX < 0 || newY < 0 || newX >= boardWidth || newY >= boardHeight) {
					result = new MoveResult(MoveType.NONE);
				} else {
					result = tryMove(piece, newX, newY);
				}
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println("Wyszedłeś poza pole");
				result = new MoveResult(MoveType.NONE);
			}

			switch (result.getType()) {
			case NONE:
				piece.abortMove();
				break;
			case NORMAL:
				piece.move(newX, newY);
				board[x0][y0].setPiece(null);
				board[newX][newY].setPiece(piece);

				sendBoardToServerAfterMove();

				break;
			case KILL:
				piece.move(newX, newY);
				board[x0][y0].setPiece(null);
				board[newX][newY].setPiece(piece);

				Piece otherPiece = result.getPiece();
				board[toBoard(otherPiece.getOldX())][toBoard(otherPiece.getOldY())].setPiece(null);
				pieceGroup.getChildren().remove(otherPiece);

				sendBoardToServerAfterMove();

				break;
			}
		});

		return piece;
	}

	/**
	 * Wysyła tablice z pozycjami pionow na serwer.
	 */
	private void sendBoardToServerAfterMove() {
		GameController.outputPrintWriter.println("NEXT"); // Wysyła na serwer komendę zmiany gracza
		setBoardServer(); // Tworzy tablicę z aktualnymi pionkami
		GameController.outputPrintWriter.println("BRD" + GameController.convertBoardStringToString()); // Konwertuje
																										// tablicę na
																										// String i
																										// wysyła go na
																										// serwer
	}

	/**
	 * Tworzy tablice z pozycjami pionow.
	 */
	public void setBoardServer() {
		for (int col = 0; col < 8; col++) {
			for (int row = 0; row < 8; row++) {
				if (board[row][col].getPiece() != null) {
					boardString[row][col] = String.valueOf(board[row][col].getPiece().getType());
				} else {
					boardString[row][col] = "";

				}
			}
		}
	}

}