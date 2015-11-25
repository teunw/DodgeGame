package nl.teunwillems.dodge;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Teun on 23-11-2015.
 */
public class GameServer implements Runnable {

    private DodgeGame dodgeGame;
    private ArrayList<String> outputQueue = new ArrayList<String>();

    public GameServer(DodgeGame dodgeGame) {
        this.dodgeGame = dodgeGame;
    }

    public void addMessageToQueue(String msg) {
        outputQueue.add(msg);
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(666);
            Socket incomingTraffic = serverSocket.accept();

            System.out.println("Connection established");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(incomingTraffic.getOutputStream());
            while (!Thread.currentThread().isInterrupted()) {
                for (String msg : outputQueue) {
                    bufferedOutputStream.write(msg.getBytes());
                }
                bufferedOutputStream.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(incomingTraffic.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    dodgeGame.onReceivePacket(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
