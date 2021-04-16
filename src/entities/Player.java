package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Player extends Entity{

	public int xTarget, yTarget;
	public boolean isAttack;
	
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
	}
	
	public void tick(){
	
		Enemy en = null;
		for(int i=0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Enemy) {
				int xEnemy = e.getX();
				int yEnemy = e.getY();
				if(Entity.calculateDistance((int)this.getX(), (int)this.getY(), xEnemy, yEnemy) < 40)
					en = (Enemy) e;
			}
		}
		
		if(en != null) {
			isAttack = true;
			xTarget = en.getX();
			yTarget = en.getY();
			
			if(Entity.rand.nextInt() < 20)
				en.life -= Entity.rand.nextDouble();
			
		}else {
			isAttack = false;
		}
		
	}
	
	public void render(Graphics g) {
		super.render(g);
		
		if(isAttack) {
			
			g.setColor(Color.red);
			g.drawLine((int)x + 6, (int)y + 6, xTarget + 6, yTarget + 6);
			
		}
		
	}
	
	


}
