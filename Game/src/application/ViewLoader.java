package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
/**
* Klasa służąca do ładowania plików FXML i plików kontrolera.
* @author Krzysztof Jagodziński
*/
public class ViewLoader<T, U> {
	private T fxmlLayout = null;
	private U fxmlController = null;

	public ViewLoader(String fxml) throws IOException {
		// try {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
		fxmlLayout = fxmlLoader.load();
		fxmlController = fxmlLoader.getController();
		// }
		// catch (IOException ex) { ... }
	}
	/**
	 * Zwraca layout.
	 * @return layout
	 */
	public T getLayout() {
		return fxmlLayout;
	}
	/**
	 * Zwraca kontroler.
	 * @return kontroler
	 */
	public U getController() {
		return fxmlController;
	}
}
