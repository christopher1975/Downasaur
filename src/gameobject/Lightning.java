/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Arul
 */
public class Lightning extends Enemy{
    
    public static final int Y_LAND = 125;
	  
	private int posX;
	private int width;
	private int height;
	
	private BufferedImage image;
	private MainCharacter mainCharacter;
	
	private Rectangle rectBound;
        private int stop = 20;
        private int x = -100;
	
	public Lightning(MainCharacter mainCharacter, int posX, int width, int height, BufferedImage image) {
            this.posX = posX;
            this.width = width;
            this.height = height;
            this.image = image;
            this.mainCharacter = mainCharacter;
            rectBound = new Rectangle();
	}
	
    @Override
	public void update() {
            if(posX > stop){
                posX -= mainCharacter.getSpeedX();
            }else{
                posX = stop;
                if(x != stop){
                    x++;
                }else{
                    stop = -100;
                }
            }
	}
	
    @Override
	public void draw(Graphics g) {
            g.drawImage(image, posX, Y_LAND - image.getHeight(), null);
            g.setColor(Color.red);
//          Rectangle bound = getBound();
//          g.drawRect(bound.x, bound.y, bound.width, bound.height);
	}
	
    @Override
	public Rectangle getBound() {
            rectBound = new Rectangle();
            rectBound.x = (int) posX + (image.getWidth() - width)/2;
            rectBound.y = Y_LAND - image.getHeight() - 20 + (image.getHeight() - height)/2;
            rectBound.width = width;
            rectBound.height = height;
            return rectBound;
	}

    @Override
	public boolean isOutOfScreen() {
            if(posX <- image.getHeight()) {
            	return true;
            }
		return false;
	}
}
