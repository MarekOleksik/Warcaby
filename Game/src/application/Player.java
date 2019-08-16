package application;

/**
 * Klasa gracza
 * @author Marek Oleksik
 */
public class Player {
	/**
	 * nazwa gracza czerwonego.
	 */	
	String redPlayer;
	/**
	 * nazwa gracza białego.
	 */
	String whitePlayer;
	/**
	 * czy trwa ruch czerownego gracza
	 */
	boolean isRedTurn = true;

	/**
	 * Zwraca nazwę gracza czerwonego.
	 * @return nazwa gracza czerwonego
	 */
	public String getRedPlayer() {
		return redPlayer;
	}
	/**
	 * Ustawia nazwę gracza czerwonego.
	 * @param redPlayer nazwa gracza czerwonego
	 */
	public void setRedPlayer(String redPlayer) {
		this.redPlayer = redPlayer;
	}
	/**
	 * Zwraca nazwę gracza białego.
	 * @return nazwa gracza białego
	 */
	public String getWhitePlayer() {
		return whitePlayer;
	}
	/**
	 * Ustawia nazwę gracza białego.
	 * @param whitePlayer nazwa gracza białego
	 */
	public void setWhitePlayer(String whitePlayer) {
		this.whitePlayer = whitePlayer;
	}
	/**
	 * Okresla czy trwa ruch czerownego gracza.
	 * @return 'true' jeżeli ruch czerwonego gracza, 'false' jeżeli ruch białego gracza
	 */
	public boolean isRedTurn() {
		return isRedTurn;
	}
	/**
	 * Ustawia ruch czerownego gracza.
	 * @param isRedTurn czy trwa ruch czerownego gracza
	 */
	public void setRedTurn(boolean isRedTurn) {
		this.isRedTurn = isRedTurn;
	}

}
