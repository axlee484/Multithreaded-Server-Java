package multithreadedserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket client;
    BufferedReader in;
    // PrintWriter out;
    String message;

    ClientHandler(Socket client) throws IOException {
        this.client = client;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        while (client.isConnected()) {
            try {
                String clientMessage = in.readLine();
                if (clientMessage == null) {
                    System.out.println("closing " + client.toString());
                    client.close();
                    break;
                }
                // out.println("Recieved via Client " + client.toString());
                System.out.println(client.getPort() + ": " + clientMessage);

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}