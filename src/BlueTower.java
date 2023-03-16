
import java.awt.Graphics;

public class BlueTower extends Tower {

	public static final int COST = 500, DAMAGE = 2, RELOAD_TIME = 2500, RANGE = 3;
	public static final String SPECIAL = "Freezes enemies";
	
	public BlueTower(Handler handler, int x, int y) {
		super(handler, x, y);
		name = "Blue Tower";
		centerNameOffset = 51;
		damage = DAMAGE;
		reloadTime = RELOAD_TIME;
		range = RANGE;
		special = SPECIAL;
		upgradeCost = 75;
		sellPrice = 180;
	}
	
	public void upgradeTower() {
		upgradeCount++;
		damage += 1;
		reloadTime -= 200;
		range += 0;
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
		g.drawImage(Gfx.blueTower, x + 1, y + 1, 47, 47, null);
	}

}
