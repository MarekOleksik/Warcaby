package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
/**
 * Klasa Main - uruchamia program WARCABY.
 * @author Krzysztof Jagodziński i Marek Oleksik
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			ViewLoader<AnchorPane, controllers.UserController> viewLoader = new ViewLoader<>("/FXML_Files/User.fxml");
			Scene scene = new Scene(viewLoader.getLayout());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Nazwa użytkownika");
			primaryStage.setResizable(false);
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		          public void handle(WindowEvent we) {
		        	  we.consume(); // dezaktywuje (x) w oknie
		        	  if (AlertBox.showAndWait(AlertType.CONFIRMATION, "WARCABY", "Czy na pewno chcesz zakończyć grę?")
		  					.orElse(ButtonType.CANCEL) == ButtonType.OK) {
		        		  primaryStage.close();
		  			}
		          }
		      });
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}