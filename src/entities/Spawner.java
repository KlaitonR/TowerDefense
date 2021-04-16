package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Spawner extends Entity{
	
	private int timer = 60;
	private int curTimer = 0;

	public Spawner(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		curTimer++;
		if(curTimer == timer) {
			curTimer = 0;
			timer = Entity.rand.nextInt(60) + 30;
			Enemy en = new Enemy((int)x, (int)y, 16, 16, Entity.rand.nextDouble(), null);
			Game.entities.add(en);
		}
	}

	public void render(Graphics g) {
//		g.setColor(Color.red);
//		g.fillRect((int)x, (int)y, width, height);
	}

}
