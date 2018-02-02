package ie.studium.froggerModel.gameObjects.segments;

import ie.studium.froggerModel.gameObjects.movers.vehicles.Vehicle;
import processing.core.PApplet;
import processing.core.PVector;

public class Highway extends Segment{
	private Road[] roads;

	public Highway(PApplet p) {
		super(p);
		createRoads();
	}

	@Override
	public void display() {
		drawRoads();
	}
	
	// CLASS'S METHODS //  // CLASS'S METHODS //  // CLASS'S METHODS //
	
	public void drawRoads() {
		updateRoads();
		for(Road r : roads) {
			r.display();
		}
	}

	public void createRoads() {
		roads = new Road[3];
		for(int i = 0; i < roads.length; i++) {
			roads[i] = new Road(p);
		}
	}
	
	public void updateRoads() {
		for(int i = 0; i < roads.length; i++) {
			roads[i].setSides();
			roads[i].setPosition(new PVector(getPosition().x, getPosition().y + i*getSize().y/3));
			roads[i].setSize(new PVector(getSize().x, getSize().y/3));

		}
	}

	//  GETTERS AND SETTERS //  //  GETTERS AND SETTERS //  //  GETTERS AND SETTERS //

	public Road[] getRoads() {
		return roads;
	}

	public void setRoads(Road[] roads) {
		this.roads = roads;
	}
}
