
import java.awt.Color;
import java.awt.Graphics;

public class BlueEnemy extends Enemy {

	public BlueEnemy(Handler handler, int x, int y) {
		super(handler, x, y);
		health = 140;
		speed = 1;
		reward = 45;
		damage = 50;
		ogSpeed = speed;
		waveStrength();
		waveReward();
		color = calcColor();
		box = calcBox();
	}

	public void tick() {
		update();
	}

	public void render(Graphics g) {
		g.drawImage(Gfx.blueEnemy, x, y, 48, 48, null);
		g.setColor(Color.gray);
		g.drawRect(x + 8, y + 48, 32, 8);
		g.fillRect(x + 8, y + 48, 32, 8);
		g.setColor(Color.getHSBColor( (color * health) / 360, 1f, 1f));
		g.fillRect(x + 8, y + 48, (int)(box * health), 8);
	}

}
