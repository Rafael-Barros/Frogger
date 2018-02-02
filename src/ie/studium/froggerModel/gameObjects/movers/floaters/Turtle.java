package ie.studium.froggerModel.gameObjects.movers.floaters;

import processing.core.PApplet;
import processing.core.PVector;

public class Turtle extends Floater{

	public Turtle(PApplet p) {
		super(p);
		setColour(p.color(70, 0, 0));
		setSize(new PVector(p.width/11, p.height/20));
	}

	@Override
	public void display() {
		setSides();
		p.fill(getColour());
		p.ellipse(getPosition().x + getSize().x/2, getPosition().y + getSize().y/2, getSize().x, getSize().y);
		p.fill(p.color(50, 200, 50));
		p.ellipse(getPosition().x + getSize().x, getPosition().y + getSize().y/2, getSize().x/3, getSize().y/4);
	}

}
