package gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Boss extends Enemy{
    
    public static final int Y_LAND = 125;
	
    private int posX;
    private int width;
    private int height;
	
    private BufferedImage image;
    private MainCharacter mainCharacter;
    
    private Rectangle rectBound;
    private int stop = 450;
    private int x = 400;

    public Boss(MainCharacter mainCharacter, int posX, int width, int height, BufferedImage image) {
        this.posX = posX;
        this.width = width;
        this.height = height;
        this.image = image;
        this.mainCharacter = mainCharacter;
        rectBound = new Rectangle();
    }
    
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
    
    public void draw(Graphics g) {
        g.drawImage(image, posX, Y_LAND - image.getHeight() - 40, null);
        g.setColor(Color.red);
//      Rectangle bound = getBound();
//      g.drawRect(bound.x, bound.y, bound.width, bound.height);
    }
	
    public Rectangle getBound() {
        rectBound = new Rectangle();
        rectBound.x = (int) posX + (image.getWidth() - width)/2;
        rectBound.y = Y_LAND - image.getHeight() - 40 + (image.getHeight() - height);
        rectBound.width = width;
        rectBound.height = height;
        return rectBound;
    }

    @Override
    public boolean isOutOfScreen() {
        if(posX <- image.getWidth()) {
            return true;
        }
            return false;
	}
}
