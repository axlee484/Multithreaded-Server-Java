
// import java.io.BufferedReader;
import java.io.IOException;
// import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String IP = "127.0.0.1";
    private static final int PORT = 2403;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the Server IP");
        // IP = sc.nextLine();
        Socket socket = new Socket(IP, PORT);
        System.out.println(socket.isConnected() + " " + socket.getPort());

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // BufferedReader inComing = new BufferedReader(new
        // InputStreamReader(socket.getInputStream()));

        System.out.println("Connected to server Send your Message");

        while (true) {

            String clientMessage = sc.nextLine();
            if (clientMessage.equals("close")) {
                break;
            }
            out.println(clientMessage);
            // String response = inComing.readLine();
            // System.out.println("[SERVER]: " + response);

        }
        System.out.println("close");
        socket.close();
        sc.close();

    }

}
