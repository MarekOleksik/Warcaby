package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.AlertBox;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
/**
 * Kontroler obsługi okna logowania użytkownika - User. 
 * Pozwala wybrać nazwę użytkownika i adres serwera.
 * @author Krzysztof Jagodziński
 */
public class UserController implements Initializable {

	@FXML
	private TextField userTextField;

	@FXML
	public ImageView picIDImageView;

	@FXML
	private TextField hostTextField;

	@FXML
	private Button anulujButton;

	@FXML
	private Button okButton;
	/**
	 * Kontroler okna logowania użytkownika
	 */
	public static UserController fxmlController;
	/**
	 * nazwa obrazka wybrana przez użytkownika
	 */
	public String picID = "";
	/**
	 * nazwa wybrana przez użytkownika
	 */
	public String userName = "";
	/**
	 * Metoda inicjalizująca.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		fxmlController = this;
		picID = "no-avatar.png";
		File file = new File("res/avatars/" + picID);
		Image image = new Image(file.toURI().toString());
		picIDImageView.setImage(image);
		
	}
	/**
	 * Metoda obsługująca działanie przycisku Anuluj. 
	 */
	@FXML
	private void anulujButtonOnActrion() {
		Stage stage = (Stage) anulujButton.getScene().getWindow();
  	  if (AlertBox.showAndWait(AlertType.CONFIRMATION, "WARCABY", "Czy na pewno chcesz zakończyć grę?")
				.orElse(ButtonType.CANCEL) == ButtonType.OK) {
			stage.close();
  	  }
	}
	/**
	 * Metoda obsługująca działanie przycisku OK. 
	 */
	@FXML
	private void okButtonOnActrion() {

		// przypisanie pierwszego okna
		Stage primaryStage = (Stage) okButton.getScene().getWindow();

		try {

			application.ViewLoader<BorderPane, GameController> viewLoader = new application.ViewLoader<>("/FXML_Files/Game.fxml");
			if (!userTextField.getText().equals("") && !userTextField.getText().equals("Gracz biały") && !userTextField.getText().equals("Gracz czerwony")) {
				userName = userTextField.getText();
			} else {
				userName = "Gość";
			}
			viewLoader.getController().setUserName(userName);
			viewLoader.getController().setPicID(picID);
			viewLoader.getController().setHost(hostTextField.getText());
			viewLoader.getController().run();

			
			BorderPane borderPane = viewLoader.getLayout();
			Scene scene = new Scene(borderPane);

			GameController controller = viewLoader.getController();
			
			// Initialize game board
			controller.ready(scene);
			

			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.setTitle("WARCABY - " + userName);
			stage.setOnHiding(e -> {
				try {
					Stage_Hiding(e, viewLoader.getController());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			stage.show();
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		          public void handle(WindowEvent we) {
		        	  we.consume(); // dezaktywuje (x) w oknie
		        	  if (AlertBox.showAndWait(AlertType.CONFIRMATION, "WARCABY", "Czy na pewno chcesz zakończyć grę?")
		  					.orElse(ButtonType.CANCEL) == ButtonType.OK) {
		  				stage.close();
		  			}
		          }
		      });        
			
			// ukrycie pierwszego okna
			primaryStage.hide();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metoda obsługi kliknięcia obrazka - otwiera okno wybory Avatara.
	 * @param event kliknięcie obrazka
	 */
	@FXML
	void picID_MousePressed(MouseEvent event) {
		try {
			application.ViewLoader<AnchorPane, AvatarController> viewLoader = new application.ViewLoader<>("/FXML_Files/Avatar.fxml");
			AnchorPane anchorPane = viewLoader.getLayout();
			Stage stage = new Stage();
			Scene scene = new Scene(anchorPane);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Wybierz Avatar");
			stage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Object Stage_Hiding(WindowEvent e, GameController controller) throws IOException {
		controller.closeSocket();
		return null;
	}
	/**
	 * Metoda obsługi kliknięcia przyciku ENTER w polu tekstowym.
	 * @param e klikniece przycisku na klawiaturze
	 */
	@FXML
	private void userTextField_KeyPressed(KeyEvent e) {
		if (e.getCode() == KeyCode.ENTER) {
			okButtonOnActrion();
		}
	}
	/**
	 * Metoda obsługi kliknięcia przyciku ENTER w polu tekstowym.
	 * @param e klikniece przycisku na klawiaturze
	 */
	@FXML
	private void hostTextField_KeyPressed(KeyEvent e) {
		if (e.getCode() == KeyCode.ENTER) {
			okButtonOnActrion();
		}
	}

}