package application;

/**
 * Klasa zawiera zmienne oraz metody odpowiedzialne za obsługę rezultatu
 * wykonanego ruchu pionkiem
 * 
 * @author Marek Oleksik
 */

public class MoveResult {
	/**
	 * Obiekt klasy MoveType reprezentujący kolor i typ piuonka
	 */
	private MoveType type;

	/**
	 * Zwraca kolor i typ pionka
	 * 
	 * @return type
	 */
	public MoveType getType() {
		return type;
	}

	/**
	 * Obiekt klasy Piece reprezentujący pionek na planszy do gry
	 */
	private Piece piece;

	/**
	 * Zwraca obiekt pionka
	 * 
	 * @return
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * Konstruktor klasy MoveResult, przyjmujący jako parametr typ pionka
	 * 
	 * @param type
	 */
	public MoveResult(MoveType type) {
		this(type, null);
	}

	/**
	 * Konstruktor klasy MoveResult, przyjmujący jako parametr typ pionka oraz
	 * obiekt pionka
	 * 
	 * @param type
	 */
	public MoveResult(MoveType type, Piece piece) {
		this.type = type;
		this.piece = piece;
	}
}
