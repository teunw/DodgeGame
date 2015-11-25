package nl.teunwillems.dodge.server;

import com.badlogic.gdx.net.Socket;

/**
 * Created by Teun on 14-11-2015.
 */
public class Server {

    public static void main(String[] args) {
        new Server();
    }

    private Socket socket;

    public Server() {
        socket = new ServerSocket();
    }
}
