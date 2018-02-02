package ie.studium.froggerModel.screens;

import ie.studium.froggerModel.gameObjects.Button;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class MainMenu {
	PApplet p;
	public final String path = "ie.studium.froggerView.MainMenu";
	PImage logo;
	PImage background;
	Button[] buttons;
	
	private static boolean howToPlayClicked;
	private static boolean playClicked;
	private static boolean exitClicked;
	
	public MainMenu(PApplet p) {
		this.p = p;
		loadImages();
		createButtons();
		
	}
	
	public void display() {
		drawBackground();
		drawLogo();
		drawButtons();
		buttonControllers();
	}

	// CLASS'S METHODS //  // CLASS'S METHODS //  // CLASS'S METHODS //
	
	public void loadImages() {
		logo = p.loadImage("data/menu_image.png");
		background = p.loadImage("data/highway_background.png");
	}
	
	public void drawLogo() {
		p.imageMode(p.CENTER);
		p.image(logo, p.width*0.5f, p.height*0.3f, p.width*0.7f, p.height*0.5f);
	}
	
	public void drawBackground() {
		p.imageMode(p.CENTER);
		p.image(background, p.width/2, p.height/2, p.width, p.height);
	}
	
	public void createButtons() {
		buttons = new Button[3];
		
		buttons[0] = new Button(p, "How to play");
		buttons[0].setPosition(new PVector(p.width*0.4f, p.height*0.6f));
		buttons[0].setSize(new PVector(p.width/5, p.height/17));
		buttons[0].setColour(p.color(50, 200, 50));
		buttons[0].setTextSize(p.width/30);
		buttons[0].setLeftPadding(p.width/100);
		buttons[0].setTopPadding(p.width/25);
		
		buttons[1] = new Button(p, "Play");
		buttons[1].setPosition(new PVector(p.width*0.4f, p.height*0.7f));
		buttons[1].setSize(new PVector(p.width/5, p.height/17));
		buttons[1].setColour(p.color(50, 200, 50));
		buttons[1].setTextSize(p.width/25);
		buttons[1].setLeftPadding(p.width/15);
		buttons[1].setTopPadding(p.width/22);
		
		buttons[2] = new Button(p, "Exit");
		buttons[2].setPosition(new PVector(p.width*0.4f, p.height*0.8f));
		buttons[2].setSize(new PVector(p.width/5, p.height/17));
		buttons[2].setColour(p.color(50, 200, 50));
		buttons[2].setTextSize(p.width/25);
		buttons[2].setLeftPadding(p.width/15);
		buttons[2].setTopPadding(p.width/22);
	}
	
	public void drawButtons() {
		for(Button b : buttons) {
			b.display();
		}
	}
	
	//  CONTROLLER  //  //  CONTROLLER  //  //  CONTROLLER  //  //  CONTROLLER  //
	
	public void buttonControllers() {
		if(buttons[0].isClicked()) {
			howToPlayClicked = true;
		}else if(buttons[1].isClicked()) {
			playClicked = true;
		}else if(buttons[2].isClicked()) {
			exitClicked = true;
		}
		
		for(int i = 0; i < buttons.length; i++) {
			
			if(buttons[i].isHovered()) {
				buttons[i].setColour(p.color(200, 100, 100));
			
			}else {
				buttons[i].setColour(p.color(50, 200, 50));
			}
		}
	}
	
	
	//  GETTERS AND SETTERS  //  //  GETTERS AND SETTERS  //  //  GETTERS AND SETTERS  //

	public static boolean isHowToPlayClicked() {
		return howToPlayClicked;
	}

	public static void setHowToPlayClicked(boolean howToPlayClicked) {
		MainMenu.howToPlayClicked = howToPlayClicked;
	}

	public static boolean isPlayClicked() {
		return playClicked;
	}

	public static void setPlayClicked(boolean playClicked) {
		MainMenu.playClicked = playClicked;
	}

	public static boolean isExitClicked() {
		return exitClicked;
	}

	public static void setExitClicked(boolean exitClicked) {
		MainMenu.exitClicked = exitClicked;
	}


}
