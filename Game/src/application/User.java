package application;

/**
* Klasa użytkownika
* @author Krzysztof Jagodziński
*/
public class User {
	/** 
	 * nazwa obrazka wybrana przez użytkownika
	 */  
	String picID;
	/** 
	 * nazwa wybrana przez użytkownika
	 */ 
	String userName;
	/** 
	 * identyfikator użytkownika nadany przez serwer
	 */ 
	int UID;
	
	/**
	 * Zwraca nazwę użytkownika.
	 * @return nazwa użytkownika
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * Ustawia nazwę użytkownika.
	 * @param userName nazwa wybrana przez użytkownika
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Zwraca nazwę obrazka użytkownika.
	 * @return nazwa obrazka użytkownika
	 */
	public String getPicID() {
		return picID;
	}
	/**
	 * Ustawia nazwę obrazka użytkownika.
	 * @param picID nazwa obrazka wybrana przez użytkownika
	 */
	public void setPicID(String picID) {
		this.picID = picID;
	}
	/**
	 * Zwraca identyfikator użytkownika.
	 * @return identyfikator użytkownika
	 */
	public int getUID() {
		return UID;
	}
	/**
	 * Ustawia identyfikator użytkownika.
	 * @param UID identyfikator użytkownika nadany przez serwer
	 */
	public void setUID(int UID) {
		this.UID = UID;
	}
}
