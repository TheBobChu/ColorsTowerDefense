
public class WaveManager {

	private Handler handler;
	private int wave;
	private int enemyCount;
	
	public WaveManager(Handler handler) {
		this.handler = handler;
		wave = 0;
		enemyCount = 0;
	}

	public void nextWave() {
		wave++;
		handler.enemiesSpawnTimer = 100;
		enemyCount = 0;
	}
	
	public void spawnEnemies() {
		// 3 Red
		if (wave == 1 && enemyCount < 3) {
			handler.waitCooldown = 7000;
			handler.addEnemy(new RedEnemy(handler, 48, 0));
			enemyCount++;
		}
		// 2 Red, 2 Blue
		else if (wave == 2 && enemyCount < 4) {
			handler.waitCooldown = 9000;
			if (enemyCount < 2) {
				handler.addEnemy(new RedEnemy(handler, 48, 0));
			}
			else {
				handler.addEnemy(new BlueEnemy(handler, 48, 0));
			}
			enemyCount++;
		}
		// 7 Red
		else if (wave == 3 && enemyCount < 7) {
			handler.waitCooldown = 15000;
			handler.addEnemy(new RedEnemy(handler, 48, 0));
			enemyCount++;
		}
		// 4 Blue
		else if (wave == 4 && enemyCount < 4) {
			handler.waitCooldown = 9000;
			handler.addEnemy(new BlueEnemy(handler, 48, 0));
			enemyCount++;
		}
		// 3 Red, 3 Blue, 1 Green
		else if (wave == 5 && enemyCount < 7) {
			handler.waitCooldown = 15000;
			if (enemyCount < 4) {
				handler.addEnemy(new RedEnemy(handler, 48, 0));
			}
			else if (enemyCount >= 3 && enemyCount < 6) {
				handler.addEnemy(new BlueEnemy(handler, 48, 0));
			}
			else {
				handler.addEnemy(new GreenEnemy(handler, 48, 0));
			}
			enemyCount++;
		}
		// 3 Green
		else if (wave == 6 && enemyCount < 3) {
			handler.waitCooldown = 7000;
			handler.addEnemy(new GreenEnemy(handler, 48, 0));
			enemyCount++;
		}
		// 5 Green
		else if (wave == 7 && enemyCount < 5) {
			handler.waitCooldown = 11000;
			handler.addEnemy(new GreenEnemy(handler, 48, 0));
			enemyCount++;
		}
		// 3 Blue, 5 Green
		else if (wave == 8 && enemyCount < 8) {
			handler.waitCooldown = 17000;
			if (enemyCount < 3) {
				handler.addEnemy(new BlueEnemy(handler, 48, 0));
			}
			else {
				handler.addEnemy(new GreenEnemy(handler, 48, 0));
			}
			enemyCount++;
		}
		// 1 Black, 3 Green
		else if (wave == 9 && enemyCount < 4) {
			handler.waitCooldown = 9000;
			if (enemyCount < 1) {
				handler.addEnemy(new BlackEnemy(handler, 48, 0));
			}
			else {
				handler.addEnemy(new GreenEnemy(handler, 48, 0));
			}
			enemyCount++;
		}
		// 3 Black
		else if (wave == 10 && enemyCount < 3) {
			handler.waitCooldown = 7000;
			handler.addEnemy(new BlackEnemy(handler, 48, 0));
			enemyCount++;
		}
		else if (wave == 11 && enemyCount < 5) {
			handler.waitCooldown = 11000;
			handler.addEnemy(new BlackEnemy(handler, 48, 0));
			enemyCount++;
		}
		else if (wave == 12 && enemyCount < 10) {
			handler.waitCooldown = 21000;
			if (enemyCount < 5) {
				handler.addEnemy(new BlackEnemy(handler, 48, 0));
			}
			else {
				handler.addEnemy(new GreenEnemy(handler, 48, 0));
			}
			enemyCount++;
		}
		else if (wave == 13 && enemyCount < 10) {
			handler.waitCooldown = 21000;
			handler.addEnemy(new BlackEnemy(handler, 48, 0));
			enemyCount++;
		}
		else if (wave == 14 && enemyCount < 15) {
			handler.waitCooldown = 31000;
			handler.addEnemy(new BlackEnemy(handler, 48, 0));
			enemyCount++;
		}
		else if (wave == 15 && enemyCount < 20) {
			handler.waitCooldown = 41000;
			handler.addEnemy(new BlackEnemy(handler, 48, 0));
			enemyCount++;
		}
	}
	
	public void reset() {
		wave = 0;
	}
	
	public int getWave() {
		return wave;
	}
	
	public int getEnemyCount() {
		return enemyCount;
	}
	
}
