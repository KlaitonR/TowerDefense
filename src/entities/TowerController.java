package entities;

import java.awt.image.BufferedImage;

import main.Game;
import world.World;

public class TowerController extends Entity{
	
	public boolean isPress;
	public int xTarget, yTarget;

	public TowerController(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		
		if(isPress) {
			isPress = false;
			boolean liberado = true;
			int xx = (xTarget/16) * 16;
			int yy = (yTarget/16) * 16;
			Player tower = new Player(xx,yy,16,16,0, Entity.TOWER);
			
			for(int i=0; i < Game.entities.size(); i++) {
				Entity e = Game.entities.get(i);
				if(e instanceof Player) {
					if(Entity.isColidding(tower, e)) {
						liberado = false;
					}
				}
			}
			
			if(World.isFree(xx, yy)) {
				liberado = false;
			}
			
			if(liberado) {
				if(Game.money>=20) {
					Game.money -= 20;
					Game.entities.add(tower);		
				}
			}
		}
		
		if(Game.life <=0){
			System.exit(1);
		}
		
	}

}
