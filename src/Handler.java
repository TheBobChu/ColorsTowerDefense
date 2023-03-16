
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {

	ArrayList<Tower> towerList = new ArrayList<Tower>();
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	public int[][] mapArray = { {0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 9},
								{0, 9, 0, 0, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 9, 9, 9, 9},
								{0, 9, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 9, 0, 9, 9, 9, 9},
								{0, 9, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 9, 0, 9, 9, 9, 9},
								{0, 9, 0, 0, 9, 0, 0, 0, 9, 9, 9, 9, 9, 0, 9, 9, 9, 9},
								{0, 9, 9, 9, 9, 0, 0, 0, 9, 0, 0, 0, 0, 0, 9, 9, 9, 9},
								{0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 9, 9, 9, 9},
								{0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 9, 9, 0, 9, 9, 9, 9},
								{0, 0, 9, 9, 9, 9, 0, 0, 0, 0, 0, 0, 9, 0, 9, 9, 9, 9},
								{0, 0, 9, 0, 0, 9, 0, 0, 0, 0, 0, 0, 9, 0, 9, 9, 9, 9},
								{0, 0, 9, 0, 0, 9, 9, 9, 9, 9, 9, 9, 9, 0, 9, 9, 9, 9},
								{0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 9} };
	
	private Game game;
	public int renderTowerInHand = 0;
	public int mx, my;
	public int hoverUITower = 0;
	public boolean nextWaveAvailable = true;
	public int nextWaveWaitTimer = 0;
	public boolean paused;
	public int enemiesSpawnTimer = 100;
	public boolean selectedATower;
	public Tower tempTower;
	public long startPause, endPause;
	public boolean needsToSubtractPauseTime = false;
	public int waitCooldown = 1000;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void tick() {
		enemiesSpawnTimer++;
		if (enemiesSpawnTimer > 75) {
			try {
				getWaveManager().spawnEnemies();
			} catch (NullPointerException e) {
				
			}
			enemiesSpawnTimer = 0;
		}
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).tick();
		}
		for (int i = 0; i < towerList.size(); i++) {
			towerList.get(i).tick();
		}
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < towerList.size(); i++) {
			towerList.get(i).render(g);
		}
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).render(g);
		}
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).render(g);
		}
		
		// If A Tower Was Just Purchased And Is Being Dragged To Be Placed Somewhere
		if (renderTowerInHand != 0) {
			if (renderTowerInHand == 1) {
				g.drawImage(Gfx.redTower, mx - 23, my - 23, 47, 47, null);
				g.setColor(Color.gray);
				g.drawOval(mx - 24 - ((24 * RedTower.RANGE) - 24), my - 24 - ((24 * RedTower.RANGE) - 24), RedTower.RANGE * 48, RedTower.RANGE * 48);
				g.setColor(new Color(64, 64, 64, 64));
				g.fillOval(mx - 24 - ((24 * RedTower.RANGE) - 24), my - 24 - ((24 * RedTower.RANGE) - 24), RedTower.RANGE * 48, RedTower.RANGE * 48);
			}
			else if (renderTowerInHand == 2) {
				g.drawImage(Gfx.orangeTower, mx - 23, my - 23, 47, 47, null);
				g.setColor(Color.gray);
				g.drawOval(mx - 24 - ((24 * OrangeTower.RANGE) - 24), my - 24 - ((24 * OrangeTower.RANGE) - 24), OrangeTower.RANGE * 48, OrangeTower.RANGE * 48);
				g.setColor(new Color(64, 64, 64, 64));
				g.fillOval(mx - 24 - ((24 * OrangeTower.RANGE) - 24), my - 24 - ((24 * OrangeTower.RANGE) - 24), OrangeTower.RANGE * 48, OrangeTower.RANGE * 48);
			}
			else if (renderTowerInHand == 3) {
				g.drawImage(Gfx.yellowTower, mx - 23, my - 23, 47, 47, null);
				g.setColor(Color.gray);
				g.drawOval(mx - 24 - ((24 * YellowTower.RANGE) - 24), my - 24 - ((24 * YellowTower.RANGE) - 24), YellowTower.RANGE * 48, YellowTower.RANGE * 48);
				g.setColor(new Color(64, 64, 64, 64));
				g.fillOval(mx - 24 - ((24 * YellowTower.RANGE) - 24), my - 24 - ((24 * YellowTower.RANGE) - 24), YellowTower.RANGE * 48, YellowTower.RANGE * 48);
			}
			else if (renderTowerInHand == 4) {
				g.drawImage(Gfx.greenTower, mx - 23, my - 23, 47, 47, null);
				g.setColor(Color.gray);
				g.drawOval(mx - 24 - ((24 * GreenTower.RANGE) - 24), my - 24 - ((24 * GreenTower.RANGE) - 24), GreenTower.RANGE * 48, GreenTower.RANGE * 48);
				g.setColor(new Color(64, 64, 64, 64));
				g.fillOval(mx - 24 - ((24 * GreenTower.RANGE) - 24), my - 24 - ((24 * GreenTower.RANGE) - 24), GreenTower.RANGE * 48, GreenTower.RANGE * 48);
			}
			else if (renderTowerInHand == 5) {
				g.drawImage(Gfx.blueTower, mx - 23, my - 23, 47, 47, null);
				g.setColor(Color.gray);
				g.drawOval(mx - 24 - ((24 * BlueTower.RANGE) - 24), my - 24 - ((24 * BlueTower.RANGE) - 24), BlueTower.RANGE * 48, BlueTower.RANGE * 48);
				g.setColor(new Color(64, 64, 64, 64));
				g.fillOval(mx - 24 - ((24 * BlueTower.RANGE) - 24), my - 24 - ((24 * BlueTower.RANGE) - 24), BlueTower.RANGE * 48, BlueTower.RANGE * 48);
			}
			else if (renderTowerInHand == 6) {
				g.drawImage(Gfx.purpleTower, mx - 23, my - 23, 47, 47, null);
				g.setColor(Color.gray);
				g.drawOval(mx - 24 - ((24 * PurpleTower.RANGE) - 24), my - 24 - ((24 * PurpleTower.RANGE) - 24), PurpleTower.RANGE * 48, PurpleTower.RANGE * 48);
				g.setColor(new Color(64, 64, 64, 64));
				g.fillOval(mx - 24 - ((24 * PurpleTower.RANGE) - 24), my - 24 - ((24 * PurpleTower.RANGE) - 24), PurpleTower.RANGE * 48, PurpleTower.RANGE * 48);
			}
			else if (renderTowerInHand == 7) {
				g.drawImage(Gfx.grayTower, mx - 23, my - 23, 47, 47, null);
				g.setColor(Color.gray);
				g.drawOval(mx - 24 - ((24 * GrayTower.RANGE) - 24), my - 24 - ((24 * GrayTower.RANGE) - 24), GrayTower.RANGE * 48, GrayTower.RANGE * 48);
				g.setColor(new Color(64, 64, 64, 64));
				g.fillOval(mx - 24 - ((24 * GrayTower.RANGE) - 24), my - 24 - ((24 * GrayTower.RANGE) - 24), GrayTower.RANGE * 48, GrayTower.RANGE * 48);
			}
			else if (renderTowerInHand == 8) {
				g.drawImage(Gfx.rainbowTower, mx - 23, my - 23, 47, 47, null);
				g.setColor(Color.gray);
				g.drawOval(mx - 24 - ((24 * RainbowTower.RANGE) - 24), my - 24 - ((24 * RainbowTower.RANGE) - 24), RainbowTower.RANGE * 48, RainbowTower.RANGE * 48);
				g.setColor(new Color(64, 64, 64, 64));
				g.fillOval(mx - 24 - ((24 * RainbowTower.RANGE) - 24), my - 24 - ((24 * RainbowTower.RANGE) - 24), RainbowTower.RANGE * 48, RainbowTower.RANGE * 48);
			}
		}
		// If The Player Is Hovering Over A Tower In The Shop
		if (hoverUITower != 0) {
			g.setColor(Color.white);
			g.setFont(new Font("arial", 0, 15));
			if (hoverUITower == 1) {
				g.drawString("Red Tower", 730, 414);
				g.drawString("Cost: " + RedTower.COST, 684, 434);
				g.drawString("Damage: " + RedTower.DAMAGE, 684, 454);
				g.drawString("Reload Time: " + RedTower.RELOAD_TIME + "s", 684, 474);
				g.drawString("Range: " + RedTower.RANGE, 684, 494);
				g.drawString("Special: " + RedTower.SPECIAL, 684, 514);
			}
			else if (hoverUITower == 2) {
				g.drawString("Orange Tower", 718, 414);
				g.drawString("Cost: " + OrangeTower.COST, 684, 434);
				g.drawString("Damage: " + OrangeTower.DAMAGE, 684, 454);
				g.drawString("Reload Time: " + OrangeTower.RELOAD_TIME + "s", 684, 474);
				g.drawString("Range: " + OrangeTower.RANGE, 684, 494);
				g.drawString("Special: " + OrangeTower.SPECIAL, 684, 514);
			}
			else if (hoverUITower == 3) {	
				g.drawString("Yellow Tower", 722, 414);
				g.drawString("Cost: " + YellowTower.COST, 684, 434);
				g.drawString("Damage: " + YellowTower.DAMAGE, 684, 454);
				g.drawString("Reload Time: " + YellowTower.RELOAD_TIME + "s", 684, 474);
				g.drawString("Range: " + YellowTower.RANGE, 684, 494);
				g.drawString("Special: " + YellowTower.SPECIAL, 684, 514);
			}
			else if (hoverUITower == 4) {
				g.drawString("Green Tower", 722, 414);
				g.drawString("Cost: " + GreenTower.COST, 684, 434);
				g.drawString("Damage: " + GreenTower.DAMAGE, 684, 454);
				g.drawString("Reload Time: " + GreenTower.RELOAD_TIME + "s", 684, 474);
				g.drawString("Range: " + GreenTower.RANGE, 684, 494);
				g.drawString("Special: " + GreenTower.SPECIAL, 684, 514);
			}
			else if (hoverUITower == 5) {
				g.drawString("Blue Tower", 728, 414);
				g.drawString("Cost: " + BlueTower.COST, 684, 434);
				g.drawString("Damage: " + BlueTower.DAMAGE, 684, 454);
				g.drawString("Reload Time: " + BlueTower.RELOAD_TIME + "s", 684, 474);
				g.drawString("Range: " + BlueTower.RANGE, 684, 494);
				g.drawString("Special: " + BlueTower.SPECIAL, 684, 514);
			}
			else if (hoverUITower == 6) {
				g.drawString("Purple Tower", 722, 414);
				g.drawString("Cost: " + PurpleTower.COST, 684, 434);
				g.drawString("Damage: " + PurpleTower.DAMAGE, 684, 454);
				g.drawString("Reload Time: " + PurpleTower.RELOAD_TIME + "s", 684, 474);
				g.drawString("Range: " + PurpleTower.RANGE, 684, 494);
				g.drawString("Special: " + PurpleTower.SPECIAL, 684, 514);
			}
			else if (hoverUITower == 7) {
				g.drawString("Gray Tower", 726, 414);
				g.drawString("Cost: " + GrayTower.COST, 684, 434);
				g.drawString("Damage: " + GrayTower.DAMAGE, 684, 454);
				g.drawString("Reload Time: " + GrayTower.RELOAD_TIME + "s", 684, 474);
				g.drawString("Range: " + GrayTower.RANGE, 684, 494);
				g.drawString("Special: " + GrayTower.SPECIAL, 684, 514);
			}
			else if (hoverUITower == 8) {
				g.drawString("Rainbow Tower", 714, 414);
				g.drawString("Cost: " + RainbowTower.COST, 684, 434);
				g.drawString("Damage: " + RainbowTower.DAMAGE, 684, 454);
				g.drawString("Reload Time: " + RainbowTower.RELOAD_TIME + "s", 684, 474);
				g.drawString("Range: " + RainbowTower.RANGE, 684, 494);
				g.drawString("Special: " + RainbowTower.SPECIAL, 684, 514);
			}
		}
		// If The Player Clicked On A Placed Tower
		if (selectedATower) {
			tempTower = findSelectedTower(mx, my);
			g.setColor(Color.gray);
			g.drawOval(tempTower.getX() - ((24 * tempTower.getRange()) - 24), tempTower.getY() - ((24 * tempTower.getRange()) - 24), tempTower.getRange() * 48, tempTower.getRange() * 48);
			g.setColor(new Color(64, 64, 64, 64));
			g.fillOval(tempTower.getX() - ((24 * tempTower.getRange()) - 24), tempTower.getY() - ((24 * tempTower.getRange()) - 24), tempTower.getRange() * 48, tempTower.getRange() * 48);
			g.setColor(Color.white);
			g.setFont(new Font("arial", 0, 12));
			g.drawString(tempTower.name, 684 + tempTower.centerNameOffset, 408);
			g.drawString("Damage: " + tempTower.damage, 684, 424);
			g.drawString("Reload Time: " + tempTower.reloadTime + "s", 684, 440);
			g.drawString("Range: " + tempTower.range, 684, 456);
			g.drawString("Special: " + tempTower.special, 684, 472);
			g.drawImage(Gfx.upgrade, 684, 478, 64, 24, null);
			g.drawImage(Gfx.sell, 788, 478, 64, 24, null);
			if (tempTower.upgradeCount < 5) {
				g.drawString("Upgrade: " + tempTower.upgradeCost, 684, 516);
			}
			else if (tempTower.upgradeCount == 5) {
				g.drawString("Upgrade: MAXED", 684, 516);
			}
			g.drawString("Sell: " + tempTower.sellPrice, 788, 516);
		}
		// Handling Next Wave Cooldown Stuff
		if (!nextWaveAvailable) {
			g.drawImage(Gfx.wait, 678, 544, 104, 24, null);
			if (!paused) {
				nextWaveWaitTimer++;
				if (nextWaveWaitTimer > waitCooldown) {
					nextWaveWaitTimer = 0;
					nextWaveAvailable = true;
				}
			}
		}
		else if (nextWaveAvailable) {
			g.drawImage(Gfx.nextWave, 678, 544, 104, 24, null);
		}
		// Handling Pause And Resume Stuff
		if (paused) {
			g.drawImage(Gfx.resume, 786, 544, 72, 24, null);
		}
		else if (!paused) {
			g.drawImage(Gfx.pause, 786, 544, 72, 24, null);
		}
	}
	
	public Tower findSelectedTower(int x, int y) {
		for (int i = 0; i < towerList.size(); i++) {
			if (towerList.get(i).getX() == x && towerList.get(i).getY() == y) {
				return towerList.get(i);
			}
		}
		return null;
	}
	
	public void reset() {
		towerList.clear();
		enemyList.clear();
		game.getWaveManager().reset();
		game.getPlayer().setMoney(500);
		game.getPlayer().setHealth(100);
	}
	
	public void addTower(Tower tower) {
		towerList.add(tower);
	}
	
	public void removeTower(Tower tower) {
		towerList.remove(tower);
	}
	
	public void addEnemy(Enemy enemy) {
		enemyList.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		enemyList.remove(enemy);
	}
	
	public void addBullet(Bullet bullet) {
		bulletList.add(bullet);
	}
	
	public void removeBullet(Bullet bullet) {
		bulletList.remove(bullet);
	}
	
	// Getters and Setters
	
	public WaveManager getWaveManager() {
		return game.getWaveManager();
	}
	
	public Player getPlayer() {
		return game.getPlayer();
	}
	
}
