package nl.teunwillems.dodge;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Teun on 23-11-2015.
 */
public class GameClient implements Runnable {

    private ArrayList<String> outputQueue = new ArrayList<String>();
    private DodgeGame dodgeGame;

    public GameClient(DodgeGame dodgeGame) {
        this.dodgeGame = dodgeGame;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", 666);

            System.out.println("Connection established");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            while (!Thread.currentThread().isInterrupted()) {
                for (String msg : outputQueue) {
                    bufferedOutputStream.write(msg.getBytes());
                }
                bufferedOutputStream.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    dodgeGame.onReceivePacket(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
