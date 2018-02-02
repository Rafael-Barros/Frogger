package ie.studium.froggerModel.gameObjects.segments;

import ie.studium.froggerModel.gameObjects.GameObject;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class Segment extends GameObject{

	public Segment(PApplet p) {
		super(p);
		setSize(new PVector(p.width, p.height/10));
	}

	@Override
	public abstract void display();
}
