package ie.studium.froggerModel.gameObjects.segments;

import processing.core.PApplet;

public class River extends Segment{

	public River(PApplet p) {
		super(p);
		setColour(p.color(50, 50, 200));
	}

	@Override
	public void display() {
		drawContainer();	
	}
	
	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.noStroke();
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
		p.stroke(1);
	}
}
