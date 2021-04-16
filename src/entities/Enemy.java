package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import world.AStar;
import world.Vector2i;
import world.World;

public class Enemy extends Entity{
	
	public boolean right = true,left = false;
	
	public double life = 30;
	
	public int dir = 0;
	
	private int framesAnimation;
	private int maxFrames = 15;
	int curSprite;
	int maxSprite = 2;
	
	public static BufferedImage[] ENEMY_RIGHT = {Game.spritesheet.getSprite(32, 0, 16, 16), Game.spritesheet.getSprite(48, 0, 16, 16)};
	public static BufferedImage[] ENEMY_LEFT = {Game.spritesheet.getSprite(32, 48, 16, 16), Game.spritesheet.getSprite(48, 48, 16, 16)};
	public static BufferedImage[] ENEMY_UP = {Game.spritesheet.getSprite(32, 16, 16, 16), Game.spritesheet.getSprite(48, 16, 16, 16)};
	public static BufferedImage[] ENEMY_DOWN = {Game.spritesheet.getSprite(32, 32, 16, 16), Game.spritesheet.getSprite(48, 32, 16, 16)};

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		path = AStar.findPath(Game.world, new Vector2i(World.xInitial, World.yInitial), new Vector2i(World.xFinal, World.yFinal));
	}
	
	public void tick() {
		
		followPath(path, this);
		
		if(x >= Game.WIDTH) {
			Game.life-= Entity.rand.nextDouble();
			Game.entities.remove(this);
			return;
		}
		
		if(life <= 0) {
			Game.entities.remove(this);
			Game.money++;
			return;
		}
		
		framesAnimation++;
		if(framesAnimation == maxFrames) {
			curSprite++;
			framesAnimation = 0;
			if(curSprite == maxSprite) {
				curSprite = 0;
			}
		}
	}
	
	public void render(Graphics g) {
		super.render(g);

		if(dir == 0) {
			this.SetSprite(ENEMY_RIGHT[curSprite]);
		}else if(dir == 1) {
			this.SetSprite(ENEMY_LEFT[curSprite]);
		}else if(dir == 2) {
			this.SetSprite(ENEMY_UP[curSprite]);
		}else if(dir == 3) {
			this.SetSprite(ENEMY_DOWN[curSprite]);
		}
		
		g.setColor(Color.red);
		g.fillRect((int)x - 2, (int)y -5, 20, 4);
		g.setColor(Color.green);
		g.fillRect((int)x - 2, (int)y -5, (int)((life/30)*30), 4);
		
	}

}
