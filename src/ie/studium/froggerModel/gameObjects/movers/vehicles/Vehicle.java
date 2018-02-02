package ie.studium.froggerModel.gameObjects.movers.vehicles;

import ie.studium.froggerModel.gameObjects.movers.Mover;
import processing.core.PApplet;

public abstract class Vehicle extends Mover{

	public Vehicle(PApplet p) {
		super(p);
	}
	
	@Override
	public void display() {
		setSides();
		drawContainer();
	}
	
	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
	}

}
