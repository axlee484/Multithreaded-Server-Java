package multithreadedserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends ServerSocket {
    HashSet<Socket> clientList = new HashSet<Socket>();
    ExecutorService threadPool;
    int ClientConnected;

    Server(final int PORT) throws IOException {
        super(PORT);
        threadPool = Executors.newFixedThreadPool(4);
        System.out.println("[SERVER] Starting at Port: " + PORT);
        ClientConnected = 0;
    }

    void startServer() {
        while (true) {
            try {
                System.out.println("[SERVER] running...with " + ClientConnected + " client(s) connected");
                Socket client = this.accept();
                System.out.println("[SERVER] connected to client " + client.getLocalAddress());
                clientList.add(client);
                ClientConnected += 1;
                ClientHandler clientThread = new ClientHandler(client);
                threadPool.execute(clientThread);
            } catch (IOException e) {
                continue;
            }
        }
    }

}