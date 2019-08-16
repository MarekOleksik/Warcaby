package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa serwera gry WARCABY
 * @author Krzysztof Jagodziński
 */

public class SocketServer {

	private static final int PORT = 9001;
	private static ArrayList<String> users = new ArrayList<String>();
	private static String playerWhite = "";
	private static String playerRed = "";
	private static String board = "";
	private static ConcurrentHashMap<Integer, PrintWriter> clients = new ConcurrentHashMap<Integer, PrintWriter>();
	
	
	public static void main(String[] args) throws Exception {

		// adres IP w sieci lokalnej
		System.out.println("IP: " + InetAddress.getLocalHost().getHostAddress());

		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("The server is running.");
			while (true) {
				Socket socket = serverSocket.accept();
				RequestHandler requestHandler = new RequestHandler(socket);
				requestHandler.start();
			}
		}

	}
	/**
	 * Klasa obsługi żądań
	 * @author Krzysztof Jagodziński
	 *
	 */
	private static class RequestHandler extends Thread {
		private int id;
		private String name;
		private String picID;
		private Socket socket;
		private BufferedReader inputBufferedReader;
		private PrintWriter outputPrintWriter;

		/**
		 * Konstruktor klasy obsługi żądań.
		 * @param socket - gniazdo serwera
		 */
		public RequestHandler(Socket socket) {
			this.socket = socket;
			id = new Random().nextInt(Integer.MAX_VALUE);
		}
		/**
		 * Metoda serwera, która nasłuchuje informacji przychodzących od użytkowników oraz przesyła im informacje zwrotne.
		 */
		@Override
		public void run() {
			try {
				inputBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				outputPrintWriter = new PrintWriter(socket.getOutputStream(), true);
				outputPrintWriter.println("RDY");

				name = inputBufferedReader.readLine();
				users.add(id + "\t" + name);
				picID = inputBufferedReader.readLine();
				clients.putIfAbsent(id, outputPrintWriter);
				System.out.println("Name: " + name + "; Pic: " + picID);

				outputPrintWriter.println("UID" + String.valueOf(id));
				System.out.println("UID" + String.valueOf(id));

				sendUsers();
				outputPrintWriter.println(playerWhite);
				outputPrintWriter.println(playerRed);
				if (!board.equals("")) {
					outputPrintWriter.println(board);
				}
				// Wysłanie kto przyszedł
				sendToAll("MSG" + 000000000 + "\t" + "System" + "\t" + "bot.png" + "\t" + "Przychodzi: " + name);

				while (true) {
					String clientMsg = inputBufferedReader.readLine();
					if (clientMsg == null) {
						return;
					}

					if (clientMsg.startsWith("MSG")) {
						clientMsg = clientMsg.substring(3);
						// Wysłanie wiadomości (MSG)
						sendToAll("MSG" + id + "\t" + name + "\t" + picID + "\t" + clientMsg);
					} else if (clientMsg.startsWith("PMSG")) {
						clientMsg = clientMsg.substring(4);
						// Wysłanie wiadomości (PMSG)
						sendToAll("PMSG" + id + "\t" + name + "\t" + picID + "\t" + clientMsg);
					} else if (clientMsg.startsWith("SIT_WHITE")) {
						sendToAll("SIT" + id + "\t" + name + "\t" + picID + "\t" + clientMsg);
						playerWhite = "SIT" + id + "\t" + name + "\t" + picID + "\t" + clientMsg;
					} else if (clientMsg.startsWith("SIT_RED")) {
						sendToAll("SIT" + id + "\t" + name + "\t" + picID + "\t" + clientMsg);
						playerRed = "SIT" + id + "\t" + name + "\t" + picID + "\t" + clientMsg;
					} else if (clientMsg.startsWith("STAND_WHITE")) {
						sendToAll("STAND" + id + "\t" + name + "\t" + picID + "\t" + clientMsg);
						playerWhite = "";
					} else if (clientMsg.startsWith("STAND_RED")) {
						sendToAll("STAND" + id + "\t" + name + "\t" + picID + "\t" + clientMsg);
						playerRed = "";
					} else if (clientMsg.startsWith("MOVE")) {
						sendToAll(clientMsg);
					} else if (clientMsg.startsWith("ENDGAME")) {
						sendToAll(clientMsg + "\t" + id);
					} else if (clientMsg.startsWith("NEXT")) {
						sendToAll(clientMsg);
					} else if (clientMsg.startsWith("BRD")) {
						sendToAll(clientMsg);
						board = clientMsg;
					}

				}
			} catch (IOException e) {
				System.out.println("Client reset connection");
			} finally {
				// Czy gracz siedział przy stole? (jak tak to zwalnia miejsce).
				ifPlayerWasSitting();

				// Usunięcie z listy obecnych
				users.remove(id + "\t" + name);
				// Wysłanie aktualnej listy obecnych
				sendUsers();
				// Wysłanie kto odszedł
				sendToAll("MSG" + 000000000 + "\t" + "System" + "\t" + "bot.png" + "\t" + "Odchodzi: " + name);
				// Usunięcie ID
				clients.remove(id);
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		/**
		 * Metoda weryfikująca czy użytkownik, który odszedł siedział przy stole.
		 * Jeżeli tak to wysyła do innch użytkowników informację,że gracz wstał od stołu.
		 */
		private void ifPlayerWasSitting() {
			if (!playerWhite.equals("")) {
				String temp = playerWhite.substring(3);
				String[] param = temp.split("\t");
				if (param[0].equals(String.valueOf(id))) {
					if (!playerRed.equals("")) {
						sendToAll("ENDGAME_WHITE" + "\t" + "odszedł z gry" + "\t" + id);
					}
					sendToAll("STAND" + id + "\t" + name + "\t" + picID + "\t" + "STAND_WHITE");
					playerWhite = "";
				}

			}
			if (!playerRed.equals("")) {
				String temp = playerRed.substring(3);
				String[] param = temp.split("\t");
				if (param[0].equals(String.valueOf(id))) {
					if (!playerWhite.equals("")) {
						sendToAll("ENDGAME_RED" + "\t" + "odszedł z gry" + "\t" + id);
					}
					sendToAll("STAND" + id + "\t" + name + "\t" + picID + "\t" + "STAND_RED");
					playerRed = "";
				}

			}
		}
		/**
		 * Metoda wysyła listę aktywnych użytkowników.
		 */
		private void sendUsers() {
			for (ConcurrentHashMap.Entry<Integer, PrintWriter> entry : clients.entrySet()) {
				PrintWriter printWriter = entry.getValue();
				printWriter.println(users);
				System.out.println(users); // do skasowania
			}
		}
		/**
		 * Metoda wysyła informację do wszystkich aktywnych użytkowników.
		 * @param serverMsg - informacja wysyłana
		 */
		private void sendToAll(String serverMsg) {
			for (ConcurrentHashMap.Entry<Integer, PrintWriter> entry : clients.entrySet()) {
				PrintWriter printWriter = entry.getValue();
				printWriter.println(serverMsg); // wysyłanie komunikatu do
												// klienta
			}
		}
	}
}