package ie.studium.froggerModel.gameObjects.movers.vehicles;

import processing.core.PApplet;
import processing.core.PVector;

public class Bus extends Vehicle{

	public Bus(PApplet p) {
		super(p);
		setColour(p.color(50, 50, 200));
		setSize(new PVector(p.width/11*1.8f, p.height/10*0.7f));
	}

}
