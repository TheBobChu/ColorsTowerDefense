
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private Handler handler;

	public HUD(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", 0, 20));
		g.drawString("Wave: " + handler.getWaveManager().getWave(), 680, 26);
		g.drawString("Health: " + handler.getPlayer().getHealth(), 680, 48);
		g.drawString("Money: " + handler.getPlayer().getMoney(), 680, 70);
		
		g.setFont(new Font("arial", 0, 14));
		g.drawString("Available Towers", 684, 90);
		g.drawString("Selected Tower", 684, 390);
		g.drawString("Controls", 684, 537);
	}
	
}
