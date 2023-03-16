
import java.awt.Graphics;

public class GrayTower extends Tower {

	public static final int COST = 500, DAMAGE = 25, RELOAD_TIME = 750, RANGE = 5;
	public static final String SPECIAL = "None";
	
	public GrayTower(Handler handler, int x, int y) {
		super(handler, x, y);
		name = "Gray Tower";
		centerNameOffset = 50;
		damage = DAMAGE;
		reloadTime = RELOAD_TIME;
		range = RANGE;
		special = SPECIAL;
		upgradeCost = 75;
		sellPrice = 180;
	}
	
	public void upgradeTower() {
		upgradeCount++;
		damage += 5;
		reloadTime -= 50;
		range += 1;
		upgradeCost += (int)(upgradeCost * 0.6f);
		sellPrice += (int)(upgradeCost * 0.4f);
	}
	
	public void tick() {
		target = findTarget(findEnemiesInRange());
		if (target != null) {
			attack(target);
		}
	}

	public void render(Graphics g) {
		g.drawImage(Gfx.grayTower, x + 1, y + 1, 47, 47, null);
	}
}
