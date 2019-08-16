package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Klasa Tile jest odpowiedzialna za pojedynczy kwadrat na planszy do gry
 * Warcaby. Klasa dziedziczy po klasie {@link javafx.scene.shape.Rectangle}.
 * 
 * @author Marek Oleksik
 */
public class Tile extends Rectangle {

	/**
	 * Obiekt klasy Piece reprezentujący pionek na planszy
	 */
	private Piece piece;
	/**
	 * Obiekt klasy Color reprezentujący kolor pola jasnego na planszy do gry.
	 * 
	 * @see Color
	 */
	private final Color LIGHTCOLOR = Color.valueOf("#feb");
	/**
	 * Obiekt klasy Color reprezentujący kolor pola ciemnego na planszy do gry.
	 * 
	 * @see Color
	 */
	private final Color DARKCOLOR = Color.valueOf("#552");

	/**
	 * Zwraca wartość true, jeżeli pole posiada pionka
	 * 
	 * @return piece
	 */
	public boolean hasPiece() {
		return piece != null;
	}

	/**
	 * Zwraca obiekt pionka
	 * 
	 * @return piece
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * Ustawia obiekt pionka
	 * 
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * Konstruktor klasy Tile przyjmujący następujące parametry:
	 * 
	 * @param light  - kolor pojedynczego pola planszy do gry
	 * @param x      - współrzędna X pola na planszy do gry
	 * @param y      - współrzędna Y pola na planszy do gry
	 * @param width  - szerokość pojedynczego pola planszy do gry
	 * @param height - wysokość pojedynczego pola planszy do gry
	 */
	public Tile(boolean light, int x, int y, double width, double height) {

		setWidth(width);
		setHeight(height);

		relocate(x * width, y * height);

		setFill(light ? LIGHTCOLOR : DARKCOLOR);
	}
}