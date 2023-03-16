
import java.awt.Graphics;

public class GreenTower extends Tower {

	public static final int COST = 250, DAMAGE = 5, RELOAD_TIME = 500, RANGE = 2;
	public static final String SPECIAL = "None";
	
	public GreenTower(Handler handler, int x, int y) {
		super(handler, x, y);
		name = "Green Tower";
		centerNameOffset = 47;
		damage = DAMAGE;
		reloadTime = RELOAD_TIME;
		range = RANGE;
		special = SPECIAL;
		upgradeCost = 45;
		sellPrice = 90;
	}
	
	public void upgradeTower() {
		upgradeCount++;
		damage += 2;
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
		g.drawImage(Gfx.greenTower, x + 1, y + 1, 47, 47, null);
	}
}
