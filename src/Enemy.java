
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Enemy {

	protected Handler handler;
	protected int x, y;
	protected int health, speed, reward, damage, ogSpeed;
	protected long closenessToEndOfPath;
	protected boolean frozen = false, burning = false;
	private int frozenTime, burningTime;
	protected float color, box;
	
	public Enemy(Handler handler, int x, int y) {
		this.handler = handler;
		this.x = x;
		this.y = y;
	}
	
	public void waveReward() {
		reward += reward * 0.4 * handler.getWaveManager().getWave();
	}
	
	public void waveStrength() {
		int wave = handler.getWaveManager().getWave();
		health += health * 0.2 * wave;
		if (wave > 5) health += 250;
		if (wave > 10) health += 750;
	}
	
	public void update() {
		if (burning) {
			health -= 1;
			burningTime++;
			if (burningTime > 20) {
				burningTime = 0;
				burning = false;
			}
		}
		if (health <= 0) {
			handler.getPlayer().setMoney(handler.getPlayer().getMoney() + this.reward);
			handler.removeEnemy(this);
		}
		if (frozen) {
			speed = 0;
			frozenTime++;
			if (frozenTime > 50) {
				frozenTime = 0;
				frozen = false;
				speed = ogSpeed;
			}
			return;
		}
		if (y <= 240 && x == 48) {
			y += speed;
			closenessToEndOfPath++;
		}
		if (y == 240 && x >= 48 && x < 192) {
			x += speed;
			closenessToEndOfPath += 10;
		}
		if (x == 192 && y > 48 && y <= 240) {
			y -= speed;
			closenessToEndOfPath += 100;
		}
		if (x >= 192 && y == 48 && x < 576) {
			x += speed;
			closenessToEndOfPath += 1000;
		}
		if (x == 576 && y < 192) {
			y += speed;
			closenessToEndOfPath += 10000;
		}
		if (y == 192 && x > 384) {
			x -= speed;
			closenessToEndOfPath += 100000;
		}
		if (x == 384 && y >= 192 && y < 336) {
			y += speed;
			closenessToEndOfPath += 1000000;
		}
		if (y == 336 && x < 576) {
			x += speed;
			closenessToEndOfPath += 10000000;
		}
		if (x == 576 && y >= 336 && y < 480) {
			y += speed;
			closenessToEndOfPath += 100000000;
		}
		if (y == 480 && x > 240) {
			x -= speed;
			closenessToEndOfPath += 1000000000;
		}
		if (x == 240 && y > 384) {
			y -= speed;
			closenessToEndOfPath += 10000000000l;
		}
		if (y == 384 && x > 96 && x <= 240) {
			x -= speed;
			closenessToEndOfPath += 100000000000l;
		}
		if (x == 96 && y >= 384 && y < 576) {
			y += speed;
			closenessToEndOfPath += 1000000000000l;
		}
		if (x == 96 && y == 576) {
			handler.getPlayer().setHealth(handler.getPlayer().getHealth() - damage);
			handler.getPlayer().setMoney(handler.getPlayer().getMoney() + this.reward);
			handler.removeEnemy(this);
		}
	}
	
	public float calcColor() {
		return 100f / health;
	}
	
	public float calcBox() {
		return 32f / health;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 48, 48);
	}
	
	// Getters
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
