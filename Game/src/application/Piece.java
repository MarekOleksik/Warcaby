package application;

import controllers.GameController;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Klasa Piece zawiera podstawowe metody i zmienne do określenia wyglądu
 * poszczególnych pionków, jak również damek. Klasa dziedziczy po klasie
 * {@link javafx.scene.layout.StackPane}.
 * 
 * @author Marek Oleksik
 */
public class Piece extends StackPane {
	/**
	 * Obiekt typu PieceType odpowiedzialny za kolor pionka
	 */
	private PieceType type;
	/**
	 * Zmienna wyrażająca rozmiar pojedynczego pola planszy do gry
	 */
	private double tileSize;
	/**
	 * Zmienne określające współrzędne punktu, w który nastąpiło kliknięcie myszą
	 */
	private double mouseX, mouseY;
	/**
	 * Zmienne określające poprzednie położenie pionka
	 */
	private double oldX, oldY;
	/**
	 * Zmienna określająca czy dany pionek jest damką
	 */
	private boolean isKing;
	/**
	 * Zmienna finalna odpowiedzialna za kolor jasnego pionka
	 */
	private final Color LIGHTPIECE = Color.valueOf("white");
	/**
	 * Zmienna finalna odpowiedzialna za kolor ciemnego pionka
	 */
	private final Color DARKPIECE = Color.valueOf("red");
	/**
	 * Zwraca kolor pionka
	 * @return type
	 */
	public PieceType getType() {
		return type;
	}
	/**
	 * Zwraca współrzędna X poprzedniego położenia pionka
	 * @return oldX
	 */
	public double getOldX() {
		return oldX;
	}
	/**
	 * Zwraca współrzędna Y poprzedniego położenia pionka
	 * @return oldY
	 */
	public double getOldY() {
		return oldY;
	}

	/**
	 * Konstruktor klasy Piece.
	 * 
	 * @param type     - kolor pionka
	 * @param x        - współrzędna x pionka
	 * @param y        - współrzędna y pionka
	 * @param tileSize - rozmiar pojedynczego pola planszy
	 */
	public Piece(PieceType type, int x, int y, double tileSize) {
		this.type = type;
		this.tileSize = tileSize;

		move(x, y);

		drawEllipse(type, tileSize);

		if (type.toString().equals(GameController.turn)) {
			setOnMousePressed(e -> {
				mouseX = e.getSceneX();
				mouseY = e.getSceneY();
				System.out.println(mouseX + " + " + mouseY);
			});

			setOnMouseDragged(e -> {
				relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
			});
		}
	}

	/**
	 * Metoda drawEllipse ma za zadanie narysować pionek na planszy. Metoda
	 * przyjmuje dwa parametry wywołania.
	 * 
	 * @param type     - określa kolor pionka
	 * @param tileSize - określa rozmiar pojedynczego pola planszy
	 */

	public void drawEllipse(PieceType type, double tileSize) {
		Ellipse bg = new Ellipse(tileSize * 0.3125, tileSize * 0.26);
		bg.setFill(Color.BLACK);

		bg.setStroke(Color.BLACK);
		bg.setStrokeWidth(tileSize * 0.03);

		bg.setTranslateX((tileSize - tileSize * 0.3125 * 2) / 2);
		bg.setTranslateY((tileSize - tileSize * 0.26 * 2) / 2 + tileSize * 0.07);

		Ellipse ellipse = new Ellipse(tileSize * 0.3125, tileSize * 0.26);
		ellipse.setFill(type == PieceType.RED ? DARKPIECE : LIGHTPIECE);

		ellipse.setStroke(Color.BLACK);

		ellipse.setStrokeWidth(tileSize * 0.03);

		ellipse.setTranslateX((tileSize - tileSize * 0.3125 * 2) / 2);
		ellipse.setTranslateY((tileSize - tileSize * 0.26 * 2) / 2);

		getChildren().addAll(bg, ellipse);

	}

	/**
	 * Metoda drawKing ma za zadanie narysować damkę na planszy. Metoda przyjmuje
	 * dwa parametry wywołania.
	 * 
	 * @param type     - określa kolor damki
	 * @param tileSize - określa rozmiar pojedynczego pola planszy
	 */

	public void drawKing(PieceType type, double tileSize) {
		drawEllipse(type, tileSize);
		Ellipse ellipse = new Ellipse(tileSize * 0.3125, tileSize * 0.26);
		ellipse.setFill(type == PieceType.RED ? DARKPIECE : LIGHTPIECE);

		ellipse.setStroke(Color.BLACK);

		ellipse.setStrokeWidth(tileSize * 0.03);

		ellipse.setTranslateX((tileSize - tileSize * 0.3125 * 2) / 2);
		ellipse.setTranslateY((tileSize - tileSize * 0.35 * 2) / 2);
		getChildren().add(ellipse);
	}

	/**
	 * Metoda move odpowiada za przesunięcie pionka na planszy. Przyjmuje dwa
	 * parametry wywołania.
	 * 
	 * @param x - współrzędna x pionka
	 * @param y - współrzędna y pionka
	 */
	public void move(int x, int y) {
		oldX = x * tileSize;
		oldY = y * tileSize;
		relocate(oldX, oldY);
	}

	/**
	 * Metoda abortmove jest odpoiwiedzialna za anulowanie wykonania ruchu.
	 */
	public void abortMove() {
		relocate(oldX, oldY);
	}

	/**
	 * Metoda sprawdza czy dany pionek jest damką.
	 * 
	 * @return - zwraca wartość zmiennej isKing.
	 */
	public boolean isKing() {
		return isKing;
	}

	/**
	 * Metoda makeKing jest odpowiedzialna za zmianę pionka na damkę.
	 */
	public void makeKing() {
		isKing = true;
		drawKing(type, tileSize);
		if (type == PieceType.RED) {
			type = PieceType.KINGRED;
		} else if (type == PieceType.WHITE) {
			type = PieceType.KINGWHITE;
		}

	}
}
