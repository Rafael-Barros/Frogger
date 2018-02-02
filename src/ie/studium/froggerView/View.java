package ie.studium.froggerView;

import ie.studium.froggerModel.screens.GamePlay;
import ie.studium.froggerModel.screens.HowToPlay;
import ie.studium.froggerModel.screens.MainMenu;
import processing.core.PApplet;

public class View extends PApplet{
	private int screenWidth = 550;
	private int screenHeight = 600;
	
	private MainMenu mainMenu;
	private GamePlay gamePlay;
	private HowToPlay howToPlay;
	
	public static boolean playClicked;
	public static boolean howToPlayClicked;
	public static boolean exitClicked;
	
	public void settings() {
		setSize(screenWidth, screenHeight);
	}
	
	public void setup() {
		mainMenu = new MainMenu(this);
		gamePlay = new GamePlay(this);
		howToPlay = new HowToPlay(this);
	}
	
	public void draw() {
		screensController();
	}
	
	public void screensController() {
		howToPlayClicked = MainMenu.isHowToPlayClicked();
		playClicked = MainMenu.isPlayClicked();
		exitClicked = MainMenu.isExitClicked();
		
		if(!playClicked && !howToPlayClicked && !exitClicked) {mainMenu.display();}
		else if(playClicked) {gamePlay.display();}
		else if(howToPlayClicked) {howToPlay.display();}
		else if(exitClicked) {this.exit();}
	}
	
	public void keyPressed() {
		if(playClicked && gamePlay.getStatus().getLives().getLives() > 0 && !gamePlay.isGameWon()) {
			if(key == 'i') {
				gamePlay.playSound(gamePlay.getLeap_frog());
				gamePlay.getFrog().moveUp();
			}else if(key == 'j') {
				gamePlay.playSound(gamePlay.getLeap_frog());
				gamePlay.getFrog().moveLeft();
			}else if(key == 'l') {
				gamePlay.playSound(gamePlay.getLeap_frog());
				gamePlay.getFrog().moveRight();
			}else if(key == 'k') {
				gamePlay.playSound(gamePlay.getLeap_frog());
				gamePlay.getFrog().moveDown();
			}
		}
	}

}
