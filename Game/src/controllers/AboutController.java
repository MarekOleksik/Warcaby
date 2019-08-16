package controllers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Kontroler obsługi okna About - O Programie. 
 * Przedstawia informacje o autorach i zasady gry.
 * @author Krzysztof Jagodziński
 */
public class AboutController {

	@FXML
	private TextArea topTextArea;

	@FXML
	private TextArea bottomTextArea;

	@FXML
	private ImageView boardImageView;

	@FXML
	private Button closeButton;

	/**
	 * Metoda inicjalizująca.
	 */
	@FXML
	private void initialize() {
		File file = new File("res/board.png");
		Image image = new Image(file.toURI().toString());
		boardImageView.setImage(image);
		topTextArea.setText("WARCABY" + "\n" + "\n" + "Autorzy:" + "\n" + "Krzysztof Jagodziński" + "\n" + "Marek Oleksik"
				+ "\n" + "\n" + "Program przygotowany na zaliczenie przedmiotu - Pojekt Końcowy."

		);

		bottomTextArea.setText("ZASADY GRY:" + "\n"+ "\n"
				+ "Gra warcaby jest rozgrywana na planszy 8x8 pól pokolorowanych na przemian na kolor jasny i ciemny."
				+ "\n" + "\n"
				+ "Każdy gracz rozpoczyna grę z dwunastoma pionami (jeden koloru białego, drugi -- czerwonego) ustawionymi na ciemniejszych polach planszy, w sposób przedstawiony na powyższej ilustracji."
				+ "\n" + "\n"
				+ "Jako pierwszy ruch wykonuje grający pionami białymi, po czym gracze wykonują na zmianę kolejne ruchy."
				+ "\n" + "\n"
				+ "Celem gry jest zbicie wszystkich pionów przeciwnika."
				+ "\n" + "\n"
				+ "Piony mogą poruszać się o jedno pole do przodu po przekątnej (na ukos) na wolne pola."
				+ "\n" + "\n"
				+ "Bicie pionem następuje przez przeskoczenie sąsiedniego pionu (lub damki) przeciwnika na pole znajdujące się tuż za nim po przekątnej (pole to musi być wolne). Zbite piony są usuwane z planszy po zakończeniu ruchu."
				+ "\n" + "\n"
				+ "Piony mogą bić jedynie do przodu."
				+ "\n" + "\n"
				+ "Pion, który dojdzie do ostatniego rzędu planszy, staje się damką."
				+ "\n" + "\n"
				+ "Damki mogą poruszać się o jedno pole zarówno do przodu jak i do tyłu po przekątnej, zatrzymując się na wolnych polach."
				+ "\n" + "\n"
				+ "Bicie damką jest możliwe zarówno do przodu jak i do tyłu.");
	}

	/**
	 * Metoda obsługująca działanie przycisku. 
	 * @param event kliknięcie przycisku
	 */
	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
		stageClose();
	}
	/**
	 * Metoda zamykająca okno.
	 */
	private void stageClose() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

}
