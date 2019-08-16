package application;

/**
 * Klasa nadawcy wiadomości 
 * @author Krzysztof Jagodziński
 */
public class Sender {
	/**
	 * nazwa nadawcy wiadomości
	 */
	String senderName;
	/**
	 * identyfikator nadawcy
	 */
	int senderUID;
	/**
	 * nazwa obrazka nadawcy
	 */
	String senderPicID;

	/**
	 * Zwraca nazwę nadawcy wiadomości.
	 * @return nadawca wiadomości
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * Ustawia nazwę nadawcy wiadomości.
	 * @param senderName nazwa nadawcy wiadomości
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * Zwraca identyfikator nadawcy.
	 * @return identyfikator nadawcy
	 */
	public int getSenderUID() {
		return senderUID;
	}
	/**
	 * Ustawia identyfikator nadawcy.
	 * @param senderUID identyfikator nadawcy
	 */
	public void setSenderUID(int senderUID) {
		this.senderUID = senderUID;
	}
	/**
	 * Zwraca nazwę obrazka nadawcy.
	 * @return nazwa obrazka nadawcy
	 */
	public String getSenderPicID() {
		return senderPicID;
	}
	/**
	 * Ustawia nazwę obrazka nadawcy.
	 * @param senderPicID nazwa obrazka nadawcy
	 */
	public void setSenderPicID(String senderPicID) {
		this.senderPicID = senderPicID;
	}

}
