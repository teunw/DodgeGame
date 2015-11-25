package nl.teunwillems.dodge;

/**
 * Created by Teun on 23-11-2015.
 */
public interface GamePacketListener {

    void onReceivePacket(String packet);
}
