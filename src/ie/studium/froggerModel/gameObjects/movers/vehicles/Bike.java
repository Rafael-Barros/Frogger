package ie.studium.froggerModel.gameObjects.movers.vehicles;

import processing.core.PApplet;
import processing.core.PVector;

public class Bike extends Vehicle {

	public Bike(PApplet p) {
		super(p);
		setColour(p.color(50, 100, 50));
		setSize(new PVector(p.width/11*1.15f, p.height/10*0.25f));
	}

}
