
import java.awt.Graphics;

public class RainbowTower extends Tower {

	public static final int COST = 1000, DAMAGE = 30, RELOAD_TIME = 1000, RANGE = 5;
	public static final String SPECIAL = "None";
	
	public RainbowTower(Handler handler, int x, int y) {
		super(handler, x, y);
		name = "Rainbow Tower";
		centerNameOffset = 41;
		damage = DAMAGE;
		reloadTime = RELOAD_TIME;
		range = RANGE;
		special = SPECIAL;
		upgradeCost = 180;
		sellPrice = 350;
	}
	
	public void upgradeTower() {
		upgradeCount++;
		damage += 4;
		reloadTime -= 150;
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
		g.drawImage(Gfx.rainbowTower, x + 1, y + 1, 47, 47, null);
	}
	
}
