
public class Player {

	private int money, health;
	
	public Player() {
		money = 500;
		health = 500;
	}
	
	public boolean alive() {
		if (health <= 0) {
			return false;
		}
		return true;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
