package ie.studium.froggerModel.gameObjects.segments;

import ie.studium.froggerModel.gameObjects.movers.vehicles.Car;
import processing.core.PApplet;
import processing.core.PVector;

public class Road extends Segment{

	public Road(PApplet p) {
		super(p);
		setColour(25);
	}

	@Override
	public void display() {
		setSides();
		drawContainer();
		drawSplitLines();
	}
	
	// CLASS'S METHODS //  // CLASS'S METHODS //  // CLASS'S METHODS //

	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
	}
	
	public void drawSplitLines() {
		for(int i = 0; i < getSize().x; i += getSize().x/11) {
			for(int j = 0; j < getSize().y; j += getSize().y/2) {
				p.rectMode(p.CORNER);
				p.noStroke();
				p.fill(255);
				p.rect(getPosition().x + i, getPosition().y + j*1.925f, getPosition().x + getSize().x/20, getSize().y/20);
				p.stroke(1);
			}
		}
	}
}
