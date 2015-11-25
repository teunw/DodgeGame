package nl.teunwillems.dodge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Teun on 11-11-2015.
 */
public class PlayerBall extends Ball {

    public PlayerBall(DodgeGame game) {
        super(game, Color.RED);
    }

    @Override
    public void update(float delta) {
        setLocation(new Vector2(game.getMousePosition().x, Gdx.graphics.getHeight() - game.getMousePosition().y));
    }


}
