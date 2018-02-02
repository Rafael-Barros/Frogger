package ie.studium.froggerModel.gameObjects.segments;


import processing.core.PApplet;
import processing.core.PVector;

public class Rivers extends Segment{
	private River[] rivers;

	public Rivers(PApplet p) {
		super(p);
		createRivers();	
	}

	@Override
	public void display() {
		drawRivers();
		update();
	}
	
	public void drawRivers() {
		for(River r : rivers) {
			r.display();
		}
	}
	
	public void createRivers() {
		rivers = new River[3];
		for(int i = 0; i < rivers.length; i++) {
			rivers[i] = new River(p);
		}
	}
	
	public void update() {
		for(int i = 0; i < rivers.length; i++) {
			rivers[i].setSides();
			rivers[i].setSize(new PVector(getSize().x, getSize().y/3));
			rivers[i].setPosition(new PVector(getPosition().x, (getPosition().y) + getSize().y/3 * i));
		}
	}

	public River[] getRivers() {
		return rivers;
	}

	public void setRivers(River[] rivers) {
		this.rivers = rivers;
	}
	
	
}
