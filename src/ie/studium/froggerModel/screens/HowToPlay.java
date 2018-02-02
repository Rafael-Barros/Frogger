package ie.studium.froggerModel.screens;

import ie.studium.froggerModel.gameObjects.Button;
import ie.studium.froggerModel.screens.MainMenu;
import processing.core.PApplet;
import processing.core.PVector;

public class HowToPlay {
	PApplet p;
	Button button;

	public HowToPlay(PApplet p) {
		this.p = p;
		button = new Button(p, "Main Menu");
		button.setSize(new PVector(p.width/11*2, p.height/20));
		button.setPosition(new PVector(p.width/11*8, p.height/10*4));
		button.setLeftPadding((int)button.getSize().x/7);
		button.setColour(p.color(100, 200, 150));
	}
	
	public void display() {
		p.background(p.color(50, 150, 50));
		keyInstructions();
		button.setSides();
		button.display();
		
		if(button.isHovered()) {
			button.setColour(p.color(200, 100, 100));
		}else {
			button.setColour(p.color(100, 200, 150));
		}
		
		if(button.isClicked()) {
			MainMenu.setHowToPlayClicked(false);
		}
	}
	
	public void keyInstructions() {
		p.rectMode(p.CORNER);
		p.fill(p.color(50, 150, 50));
		p.rect(p.width/11*1, p.height/10*1.5f, p.width/11*9, p.height/10*2.25f);
		p.fill(255);
		p.textSize(p.width/11);
		p.text("Settings", p.width*0.35f, p.height/10*1);
		p.textSize(p.width/22);
		p.text("Move up:        'I'", p.width*0.1f, p.height/10*2f);
		p.text("Move down:   'K'", p.width*0.1f, p.height/10*2.5f);
		p.text("Move left:       'J'", p.width*0.1f, p.height/10*3f);
		p.text("Move right:     'L'", p.width*0.1f, p.height/10*3.5f);
	}
	

}
