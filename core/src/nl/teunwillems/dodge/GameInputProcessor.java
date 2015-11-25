package nl.teunwillems.dodge;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Teun on 13-11-2015.
 */
public class GameInputProcessor implements InputProcessor {

    private Vector2 mousePosition;

    public GameInputProcessor() {
        mousePosition = new Vector2(0,0);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        mousePosition = new Vector2(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        mousePosition = new Vector2(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mousePosition = new Vector2(screenX, screenY);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public Vector2 getMousePosition() {
        return mousePosition;
    }
}
