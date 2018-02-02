package ie.studium.froggerModel.gameObjects.segments;

import processing.core.PApplet;
import processing.core.PVector;

public class Paviment extends Segment{

	public Paviment(PApplet p) {
		super(p);
		setColour(150);
		setSize(new PVector(p.width, p.height/10));
	}

	@Override
	public void display() {
		setSides();
		drawContainer();
		drawLines();
	}
	
	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
	}
	
	public void drawLines() {
		for(int i = 0; i < p.width; i += p.width/11) {
			p.line(getPosition().x + i, getPosition().y, getPosition().x + i, getPosition().y + getSize().y);
		}
	}
	
}
