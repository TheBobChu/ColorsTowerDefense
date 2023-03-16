
import java.awt.Graphics;

public class PurpleTower extends Tower {

	public static final int COST = 100, DAMAGE = 7, RELOAD_TIME = 1000, RANGE = 2;
	public static final String SPECIAL = "None";
	
	public PurpleTower(Handler handler, int x, int y) {
		super(handler, x, y);
		name = "Purple Tower";
		centerNameOffset = 46;
		damage = DAMAGE;
		reloadTime = RELOAD_TIME;
		range = RANGE;
		special = SPECIAL;
		upgradeCost = 20;
		sellPrice = 30;
	}
	
	public void upgradeTower() {
		upgradeCount++;
		damage += 1;
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
		g.drawImage(Gfx.purpleTower, x + 1, y + 1, 47, 47, null);
	}
	
}
