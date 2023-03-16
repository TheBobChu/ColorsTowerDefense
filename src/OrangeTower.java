
import java.awt.Graphics;

public class OrangeTower extends Tower {

	public static final int COST = 360, DAMAGE = 5, RELOAD_TIME = 1500, RANGE = 3;
	public static final String SPECIAL = "Burns enemies";
	
	public OrangeTower(Handler handler, int x, int y) {
		super(handler, x, y);
		name = "Orange Tower";
		centerNameOffset = 43;
		damage = DAMAGE;
		reloadTime = RELOAD_TIME;
		range = RANGE;
		special = SPECIAL;
		upgradeCost = 65;
		sellPrice = 130;
	}
	
	public void upgradeTower() {
		upgradeCount++;
		damage += 1;
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
		g.drawImage(Gfx.orangeTower, x + 1, y + 1, 47, 47, null);
	}
	
}
