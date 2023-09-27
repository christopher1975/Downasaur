package userinterface;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	 
	public static final int SCREEN_WIDTH = 600; //set lebar max game 
	private GameScreen gameScreen;
	
	public GameWindow() { //mengatur posisi game pada window
		super("Java T-Rex game");
		setSize(SCREEN_WIDTH, 175);
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		gameScreen = new GameScreen();
		addKeyListener(gameScreen);
		add(gameScreen);
	}
	//start game 
	public void startGame() {
		setVisible(true);
		gameScreen.startGame();
	}
	//main untuk start game
	public static void main(String args[]) {
		(new GameWindow()).startGame();
	}
}
