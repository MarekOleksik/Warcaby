package controllers;

import static controllers.UserController.fxmlController;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * Kontroler obsługi okna wyboru obrazka użytkownika - Avatar. 
 * Okno pozwala wybrać obrazek (avatar) z dostępnej bazy obrazków.
 * @author Krzysztof Jagodziński
 */
public class AvatarController {
    @FXML
    private ImageView imageView_1;

    @FXML
    private ImageView imageView_2;

    @FXML
    private ImageView imageView_3;

    @FXML
    private ImageView imageView_4;

    @FXML
    private ImageView imageView_5;

    @FXML
    private ImageView imageView_6;

    @FXML
    private ImageView imageView_7;

    @FXML
    private ImageView imageView_8;

    @FXML
    private ImageView imageView_9;

    @FXML
    private ImageView imageView_10;

    @FXML
    private ImageView imageView_11;

    @FXML
    private ImageView imageView_12;
    
    @FXML
    private Button closeButton;
	/**
	 * Metoda inicjalizująca.
	 */
    @FXML
	private void initialize() {

		File file = new File("res/avatars/1.png");
		Image image = new Image(file.toURI().toString());
		imageView_1.setImage(image);
		file = new File("res/avatars/2.png");
		image = new Image(file.toURI().toString());
		imageView_2.setImage(image);
		file = new File("res/avatars/3.png");
		image = new Image(file.toURI().toString());
		imageView_3.setImage(image);
		file = new File("res/avatars/4.png");
		image = new Image(file.toURI().toString());
		imageView_4.setImage(image);
		file = new File("res/avatars/5.png");
		image = new Image(file.toURI().toString());
		imageView_5.setImage(image);
		file = new File("res/avatars/6.png");
		image = new Image(file.toURI().toString());
		imageView_6.setImage(image);
		file = new File("res/avatars/7.png");
		image = new Image(file.toURI().toString());
		imageView_7.setImage(image);
		file = new File("res/avatars/8.png");
		image = new Image(file.toURI().toString());
		imageView_8.setImage(image);
		file = new File("res/avatars/9.png");
		image = new Image(file.toURI().toString());
		imageView_9.setImage(image);
		file = new File("res/avatars/10.png");
		image = new Image(file.toURI().toString());
		imageView_10.setImage(image);
		file = new File("res/avatars/11.png");
		image = new Image(file.toURI().toString());
		imageView_11.setImage(image);
		file = new File("res/avatars/12.png");
		image = new Image(file.toURI().toString());
		imageView_12.setImage(image);
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
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_1_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_1.getImage());
    	fxmlController.picID = "1.png";
    	stageClose();    	
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_2_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_2.getImage());
    	fxmlController.picID = "2.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_3_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_3.getImage());
    	fxmlController.picID = "3.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_4_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_4.getImage());
    	fxmlController.picID = "4.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_5_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_5.getImage());
    	fxmlController.picID = "5.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_6_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_6.getImage());
    	fxmlController.picID = "6.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_7_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_7.getImage());
    	fxmlController.picID = "7.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_8_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_8.getImage());
    	fxmlController.picID = "8.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_9_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_9.getImage());
    	fxmlController.picID = "9.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_10_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_10.getImage());
    	fxmlController.picID = "10.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_11_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_11.getImage());
    	fxmlController.picID = "11.png";
        stageClose();
    }
	/**
	 * Metoda obsługi kliknięcia obrazka.
	 * @param event kliknięcie obrazka
	 */
    @FXML
    void imageView_12_MousePressed(MouseEvent event) {
    	fxmlController.picIDImageView.setImage(imageView_12.getImage());
    	fxmlController.picID = "12.png";
        stageClose();
    }
}
