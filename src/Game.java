
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -6112428091888191314L;

	private boolean running = false;
	private Thread thread;
	
	private Handler handler;
	private HUD hud;
	private MouseInput mouseInput;
	private Player player;
	private WaveManager waveManager;
	
	public Game() {
		new Window("Colors Tower Defense", 878, 613, this);
		start();
		
		handler = new Handler(this);
		waveManager = new WaveManager(handler);
		player = new Player();
		hud = new HUD(handler);
		mouseInput = new MouseInput(handler);
		this.addMouseListener(mouseInput);
		this.addMouseMotionListener(mouseInput);
		
		Gfx.init();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
		stop();
	}
	
	private void tick() {
		if (!handler.paused) {
			handler.tick();
		}
		try {
			if (!getPlayer().alive()) {
				System.exit(1);
			}
		} catch (NullPointerException e) {
			
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		// Render Here
		
		try {
			initGrid(g);
			
			handler.render(g);
			hud.render(g);
		} catch(NullPointerException e) {
			
		}
		
		// End of Render
		
		g.dispose();
		bs.show();
	}
	
	private void initGrid(Graphics g) {
		g.drawImage(Gfx.map, 0, 0, 864, 576, null);
		g.setColor(Color.white);
		// Horizontal Lines
		for (int i = 1; i <= 11; i++) {
			g.drawLine(0, i * 48, 672, i * 48);
		}
		// Vertical Lines
		for (int i = 1; i <= 13; i++) {
			g.drawLine(i * 48, 0, i * 48, 576);
		}
	}

	public static void main(String[] args) {
		new Game();
	}

	// Getters and Setters
	
	public Player getPlayer() {
		return player;
	}

	public WaveManager getWaveManager() {
		return waveManager;
	}

}
