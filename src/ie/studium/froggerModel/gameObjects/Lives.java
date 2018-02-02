package ie.studium.froggerModel.gameObjects;

import processing.core.PApplet;

public class Lives extends GameObject{
	private int lives;

	public Lives(PApplet p) {
		super(p);
		setColour(100);
		defaultLife();
	}

	@Override
	public void display() {
		drawContainer();
		drawLives();
	}

	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
	}
	
	public void drawLives() {
		p.fill(255);
		p.textSize(getSize().x*0.135f);
		p.text("LIVES", getPosition().x + getSize().x*0.35f, getPosition().y + getSize().y*0.35f);
		p.text(lives, getPosition().x + getSize().x*0.45f, getPosition().y + getSize().y*0.8f);
	}
	
	public void subtractLife() {
		lives--;
	}
	
	public void defaultLife() {
		lives = 3;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	
}
