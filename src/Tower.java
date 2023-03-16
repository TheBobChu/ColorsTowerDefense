
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Tower {

	protected Handler handler;
	protected int x, y;
	protected int cost, damage, reloadTime, range;
	protected int upgradeCost, sellPrice, upgradeCount;
	protected String name, special;
	protected int centerNameOffset;
	protected Enemy target;
	private long lastTime, timer;
	
	public Tower(Handler handler, int x, int y) {
		this.handler = handler;
		this.x = x;
		this.y = y;
	}
	
	public ArrayList<Enemy> findEnemiesInRange() {
		ArrayList<Enemy> enemiesInRange = new ArrayList<Enemy>();
		int radius = (int)(range / 2d * 48);
		int enemyRadius = 16;
		// Distance Formula To Find If Enemy Is Within Range
		for (int i = 0; i < handler.enemyList.size(); i++) {
			Enemy tempEnemy = handler.enemyList.get(i);
			int dx = tempEnemy.getX() - x;
			int dy = tempEnemy.getY() - y;
			int dr = radius + enemyRadius;
			if ((dx * dx) + (dy * dy) < (dr * dr)) {
				enemiesInRange.add(tempEnemy);
			}
		}
		return enemiesInRange;
	}
	
	public Enemy findTarget(ArrayList<Enemy> enemiesInRange) {
		if (enemiesInRange.isEmpty()) {
			return null;
		}
		Enemy tempEnemy = enemiesInRange.get(0);
		for (int i = 0; i < enemiesInRange.size(); i++) {
			if (enemiesInRange.get(i).closenessToEndOfPath > tempEnemy.closenessToEndOfPath) {
				tempEnemy = enemiesInRange.get(i);
			}
		}
		return tempEnemy;
	}
	
	public void attack(Enemy enemy) {
		if (handler.needsToSubtractPauseTime) {
			long pausedTime = handler.endPause - handler.startPause;
			timer -= pausedTime;
			handler.needsToSubtractPauseTime = false;
		}
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if (timer < reloadTime) {
			return;
		}
		handler.addBullet(new Bullet(handler, x + 24, y + 24, damage, enemy, this));
		timer = 0;
	}
	
	public abstract void upgradeTower();
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	// Getters
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getReloadTime() {
		return reloadTime;
	}
	
	public int getRange() {
		return range;
	}
	
}
