
import java.awt.Graphics;

public class RedTower extends Tower {

	public static final int COST = 200, DAMAGE = 10, RELOAD_TIME = 1200, RANGE = 3;
	public static final String SPECIAL = "None";
	
	public RedTower(Handler handler, int x, int y) {
		super(handler, x, y);
		name = "Red Tower";
		centerNameOffset = 53;
		damage = DAMAGE;
		reloadTime = RELOAD_TIME;
		range = RANGE;
		special = SPECIAL;
		upgradeCost = 30;
		sellPrice = 75;
	}
	
	public void upgradeTower() {
		upgradeCount++;
		damage += 2;
		reloadTime -= 100;
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
		g.drawImage(Gfx.redTower, x + 1, y + 1, 47, 47, null);
	}

}
