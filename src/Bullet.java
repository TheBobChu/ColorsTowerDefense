
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {

	private Handler handler;
	private int x, y;
	private float velX, velY;
	private int damage;
	private Enemy target;
	private Tower tower;
	
	public Bullet(Handler handler, int x, int y, int damage, Enemy target, Tower tower) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.damage = damage;
		this.target = target;
		this.tower = tower;
		
		calculateVelocity(target.getX() + 24, target.getY() + 24, x, y);
	}
	
	public void calculateVelocity(int toX, int toY, int fromX, int fromY) {
		double distance = Math.sqrt(Math.pow((toX - fromX), 2) + Math.pow((toY - fromY), 2));
		float speed = 20f;
		velX = (float)((toX - fromX) * speed / distance);
		velY = (float)((toY - fromY) * speed / distance);
	}
	
	public boolean colliding(int x, int y, Rectangle myRect, Rectangle otherRect) {
		myRect.x = x;
		myRect.y = y;
		if (myRect.intersects(otherRect)) {
			return true;
		}
		return false;
	}
	
	public void collision() {
		if (colliding(x, y, getBounds(), target.getBounds())) {
			target.health -= damage;
			if (tower.special.equals("Burns enemies")) {
				target.burning = true;
			}
			if (tower.special.equals("20% Crit Chance")) {
				int chance = (int)(Math.random() * 100 + 1);
				if (chance <= 20) {
					target.health -= damage;
				}
			}
			if (tower.special.equals("Freezes enemies")) {
				target.frozen = true;
			}
			handler.removeBullet(this);
		}
	}
	
	public void tick() {
		collision();
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.drawOval(x, y, 8, 8);
		g.fillOval(x, y, 8, 8);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}
	
}
