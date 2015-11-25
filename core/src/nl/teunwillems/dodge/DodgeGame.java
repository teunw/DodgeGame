package nl.teunwillems.dodge;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

public class DodgeGame extends ApplicationAdapter implements GamePacketListener {

	private ArrayList<Ball> ballArrayList;
	private ShapeRenderer batch;
	private Camera camera;

	private GameInputProcessor gameInputProcessor;

	private Vector2 mousePosition;
	private SpawnTimer spawnTimer;

	private GameClient gameClient;

	public DodgeGame() {

	}

	@Override
	public void create () {
		batch = new ShapeRenderer();
		batch.setAutoShapeType(true);
		camera = new OrthographicCamera(10, 10);
		ballArrayList = new ArrayList<Ball>();
		ballArrayList.add(new PlayerBall(this));
		spawnAI();
		mousePosition = new Vector2(0,0);
		gameInputProcessor = new GameInputProcessor();
		Gdx.input.setCursorCatched(true);
		Gdx.input.setInputProcessor(gameInputProcessor);
		spawnTimer = new SpawnTimer(this);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		mousePosition = gameInputProcessor.getMousePosition();

		float delta = Gdx.graphics.getDeltaTime();
		for (Ball ball : ballArrayList) {
			ball.update(delta);
		}
		spawnTimer.update(delta);
		checkCollision();

		batch.begin(ShapeRenderer.ShapeType.Filled);
			for (Ball ball : ballArrayList) {
				batch.setColor(ball.getColor());
				ball.draw(batch);
			}
		batch.end();
	}

	private void checkCollision() {
		int ball1 = 0;
		int ball2 = 1;
		final int amount = ballArrayList.size();
		for (;ball1 < amount - 1; ball1++) {
			for (;ball2 < amount; ball2++){
				Ball b1 = ballArrayList.get(ball1);
				Ball b2 = ballArrayList.get(ball2);
				if (b1.getCircle().overlaps(b2.getCircle())) {
					if (b1 instanceof OnCollisionListener)
						((OnCollisionListener) b1).onCollision(b2);

					if (b2 instanceof OnCollisionListener)
						((OnCollisionListener) b2).onCollision(b1);
				}
			}
		}
	}

	public void onReceivePacket(String packet) {
		System.out.println(packet);
	}

	public void sendPacket(String msg) {

	}

	public ShapeRenderer getBatch() {
		return batch;
	}

	public Vector2 getMousePosition() {
		return mousePosition;
	}

	public void spawnAI() {
		AIBall aiBall = new AIBall(this);
		ballArrayList.add(aiBall);
	}

	public Camera getCamera() {
		return camera;
	}
}
