package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class UI {
	
	public static BufferedImage heart = Game.spritesheet.getSprite(0,16,8,8);

	public void render(Graphics g) {
		for(int i = 0; i < (int)Game.life; i++) {
			g.drawImage(heart, 20 + (i*42), 10, 36, 36, null);
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString("$ " + Game.money, (Game.WIDTH * Game.SCALE) - 100,  30);
	}
	
}
