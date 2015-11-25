package nl.teunwillems.dodge;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Teun on 6-11-2015.
 */
public abstract class Ball {

    public static final float BALL_SIZE = .000012f * Gdx.graphics.getWidth() * Gdx.graphics.getHeight();

    protected DodgeGame game;
    private Color color;
    protected Circle circle;

    public Ball(DodgeGame game, Color color) {
        this.game = game;
        this.color = color;
        circle = new Circle(0,0, BALL_SIZE);
    }

    public abstract void update(float delta);

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(getLocation().x, getLocation().y, circle.radius);
    }

    public Vector2 getLocation() {
        return new Vector2(circle.x, circle.y);
    }

    public Circle getCircle() {
        return circle;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    protected void setCircle(Circle circle) {
        this.circle = circle;
    }

    protected void setLocation(Vector2 location) {
        this.circle.setPosition(location);
    }

    public Color getColor() {
        return color;
    }

}
