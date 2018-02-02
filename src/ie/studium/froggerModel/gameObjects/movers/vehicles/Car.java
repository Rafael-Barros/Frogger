package ie.studium.froggerModel.gameObjects.movers.vehicles;

import processing.core.PApplet;
import processing.core.PVector;

public class Car extends Vehicle{

	public Car(PApplet p) {
		super(p);
		setColour(p.color(200, 50, 50));
		setSize(new PVector(p.width/11*1.5f, p.height/10*0.6f));
	}
	
}
