package multithreadedserver;

import java.io.IOException;

public class Main {
    // Main Class
    public static void main(String[] args) throws IOException {
        Server server = new Server(2403);
        server.startServer();
        server.close();

    }

}
