package ie.studium.froggerModel.gameObjects;

import processing.core.PApplet;

public class Score extends GameObject{
	private int value;

	public Score(PApplet p) {
		super(p);
		setColour(100);
		value = 0;
	}

	@Override
	public void display() {
		drawContainer();
		drawScore();
	}
	
	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
	}
	
	public void drawScore() {
		p.fill(255);
		p.textSize(getSize().x*0.1f);
		p.text("SCORE", getPosition().x + getSize().x*0.35f, getPosition().y + getSize().y*0.35f);
		p.text(value, getPosition().x + getSize().x*0.35f, getPosition().y + getSize().y*0.8f);
	}
	
	public void increaseValue(int v) {
		value += v;
	}

}
