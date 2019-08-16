package application;

/**
 * Klasa enum zawierająca kolor i typ pionka
 * 
 * @author Marek Oleksik
 */
public enum PieceType {
	RED(1), WHITE(-1), KINGRED(0), KINGWHITE(0);
	/**
	 * Zmienna finalna odpowiadająca za kierunek ruchu pionka
	 */
	final int moveDir;

	/**
	 * Konstruktor klasy PieceType przyjmujący jako parametr dozwolony kierunek
	 * ruchu pionkiem
	 * 
	 * @param moveDir
	 */
	PieceType(int moveDir) {
		this.moveDir = moveDir;
	}
}
