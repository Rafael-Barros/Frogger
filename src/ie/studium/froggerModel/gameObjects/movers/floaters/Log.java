package ie.studium.froggerModel.gameObjects.movers.floaters;

import processing.core.PApplet;
import processing.core.PVector;

public class Log extends Floater{

	public Log(PApplet p) {
		super(p);
		setColour(p.color(51, 0, 0));
		setSize(new PVector(p.width/6, p.height/25));
	}

	@Override
	public void display() {
		setSides();
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y, 25);
		
	}

}
