
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Gfx {
	
	public static BufferedImage map;
	public static BufferedImage sheet;
	public static BufferedImage redTower, orangeTower, yellowTower, greenTower,
								blueTower, purpleTower, grayTower, rainbowTower;
	public static BufferedImage nextWave, wait, pause, resume;
	public static BufferedImage redEnemy, blueEnemy, greenEnemy, blackEnemy;
	public static BufferedImage upgrade, sell;
	
	public static void init() {
		map = loadImage("/map.png");
		sheet = loadImage("/sheet.png");
		
		redTower = crop(sheet, 0, 0, 48, 48);
		orangeTower = crop(sheet, 48, 0, 48, 48);
		yellowTower = crop(sheet, 96, 0, 48, 48);
		greenTower = crop(sheet, 144, 0, 48, 48);
		blueTower = crop(sheet, 0, 48, 48, 48);
		purpleTower = crop(sheet, 48, 48, 48, 48);
		grayTower = crop(sheet, 96, 48, 48, 48);
		rainbowTower = crop(sheet, 144, 48, 48, 48);
		
		nextWave = crop(sheet, 0, 144, 104, 24);
		wait = crop(sheet, 0, 192, 104, 24);
		pause = crop(sheet, 144, 144, 72, 24);
		resume = crop(sheet, 144, 192, 72, 24);
		
		redEnemy = crop(sheet, 240, 0, 48, 48);
		blueEnemy = crop(sheet, 288, 0, 48, 48);
		greenEnemy = crop(sheet, 240, 48, 48, 48);
		blackEnemy = crop(sheet, 288, 48, 48, 48);
		
		upgrade = crop(sheet, 240, 144, 64, 24);
		sell = crop(sheet, 336, 144, 64, 24);
	}
	
	public static BufferedImage crop(BufferedImage sheet, int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
	
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Gfx.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
