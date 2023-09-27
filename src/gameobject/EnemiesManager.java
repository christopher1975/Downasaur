package gameobject;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.Resource;

public class EnemiesManager {
	
    private BufferedImage cactus1;
    private BufferedImage cactus2;
    private BufferedImage boss;
    private BufferedImage lightning;
    private AudioClip soundlightning;
    private Random rand;
	
    private List<Enemy> enemies;
    private MainCharacter mainCharacter;
	
    public EnemiesManager(MainCharacter mainCharacter) {
	rand = new Random();
	cactus1 = Resource.getResouceImage("data/cactus1.png");
	cactus2 = Resource.getResouceImage("data/cactus2.png");
        boss = Resource.getResouceImage("data/boss.png");
        lightning = Resource.getResouceImage("data/lightning.png");
	enemies = new ArrayList<Enemy>();
        this.mainCharacter = mainCharacter;
	enemies.add(createEnemy());
        try {
            soundlightning = Applet.newAudioClip(new URL("file","","data/lightning.wav"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
	
    public void update() {
        for(Enemy e : enemies) {
            e.update();
        }
        Enemy enemy = enemies.get(0);
        if(enemy.isOutOfScreen()) {
            mainCharacter.upScore();
            int comeBoss = mainCharacter.score % 100;
            enemies.clear();
            if(comeBoss == 0){
                enemies.add(createBoss());
                soundlightning.play();
                enemies.add(createLightning());
                mainCharacter.nyawa += 10;
            }else{
                enemies.add(createEnemy());
            }
        }
    }
	
    public void draw(Graphics g) {
	for(Enemy e : enemies) {
            e.draw(g);
	}
    }
	
    private Enemy createEnemy() {
	// if (enemyType = getRandom)
        int type = rand.nextInt(2);
        if(type == 0) {
            return new Cactus(mainCharacter, 800, cactus1.getWidth() - 10, cactus1.getHeight() - 10, cactus1);
        } else {
            return new Cactus(mainCharacter, 800, cactus2.getWidth() - 10, cactus2.getHeight() - 10, cactus2);
        }
    }
    
    private Enemy createBoss(){
        return new Boss(mainCharacter, 800, boss.getWidth() - 10, boss.getHeight() - 10, boss);
    }
    
    private Enemy createLightning(){
        return new Lightning(mainCharacter, 20, lightning.getWidth() - 10, lightning.getHeight() - 10, lightning);
    }
	
    public boolean isCollision() {
        for(Enemy e : enemies) {
            if (mainCharacter.getBound().intersects(e.getBound())) {
                return true;
            }
        }
            return false;
    }
	
    public void reset() {
	enemies.clear();
	enemies.add(createEnemy());
    }
	
}
