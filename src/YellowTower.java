
import java.awt.Graphics;

public class YellowTower extends Tower {

	public static final int COST = 320, DAMAGE = 20, RELOAD_TIME = 1800, RANGE = 4;
	public static final String SPECIAL = "20% Crit Chance";
	
	public YellowTower(Handler handler, int x, int y) {
		super(handler, x, y);
		name = "Yellow Tower";
		centerNameOffset = 44;
		damage = DAMAGE;
		reloadTime = RELOAD_TIME;
		range = RANGE;
		special = SPECIAL;
		upgradeCost = 60;
		sellPrice = 120;
	}
	
	public void upgradeTower() {
		upgradeCount++;
		damage += 4;
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
		g.drawImage(Gfx.yellowTower, x + 1, y + 1, 47, 47, null);
	}
	
}
