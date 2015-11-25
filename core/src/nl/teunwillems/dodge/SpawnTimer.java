package nl.teunwillems.dodge;

/**
 * Created by Teun on 13-11-2015.
 */
public class SpawnTimer {

    public static final float SPAWN_TIMER = 2.f;

    private float timeElapsed;
    private DodgeGame game;

    public SpawnTimer(DodgeGame game) {
        this.game = game;
        timeElapsed = 0.f;
    }

    public void update(float delta) {
        timeElapsed += delta;

        if (timeElapsed > SPAWN_TIMER) {
            game.spawnAI();
            reset();
        }
    }

    public void reset() {
        timeElapsed = 0.f;
    }

}
