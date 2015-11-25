package nl.teunwillems.dodge.server;

import com.badlogic.gdx.net.Socket;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Teun on 14-11-2015.
 */
public class ServerSocket implements Socket {

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }

    @Override
    public OutputStream getOutputStream() {
        return null;
    }

    @Override
    public String getRemoteAddress() {
        return null;
    }

    @Override
    public void dispose() {

    }
}
