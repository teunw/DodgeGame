package nl.teunwillems.dodge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Teun on 11-11-2015.
 */
public class AIBall extends Ball implements OnCollisionListener {

    private Vector2 speed;
    private Rectangle windowArea;

    public AIBall(DodgeGame game) {
        super(game, Color.BLUE);
        this.setLocation(new Vector2(100, 100));
        this.speed = new Vector2(500,500);
    }

    @Override
    public void update(float delta) {
        setLocation(getLocation().add(speed.x * delta, speed.y * delta));
        calcRectangle();

        if (!windowArea.contains(getLocation())) {
            speed.rotate90(1);
        }
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        super.draw(shapeRenderer);
    }

    private void calcRectangle() {
        float startX = 0;
        float startY = 0;
        float endX = (Gdx.graphics.getWidth());
        float endY = (Gdx.graphics.getHeight());
        windowArea = new Rectangle(startX, startY, endX - startX, endY - startY);
    }

    @Override
    public boolean onCollision(Ball ball) {
        if (ball instanceof AIBall) {
            speed.rotate(180);
            return true;
        }
        return false;
    }
}
