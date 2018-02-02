package ie.studium.froggerModel.gameObjects.segments;

import ie.studium.froggerModel.gameObjects.House;
import processing.core.PApplet;
import processing.core.PVector;

public class Grass extends Segment{
	private House[] houses;

	public Grass(PApplet p) {
		super(p);
		setColour(p.color(50, 150, 50));
		createHouses();
	}

	@Override
	public void display() {
		drawContainer();
		drawHouses();
		updateHouses();
		
	}

	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
	}
	
	public void updateHouses() {
		for(int i = 0; i < houses.length; i ++) {
			houses[i].setPosition(new PVector((getPosition().x + getSize().x/11) + i*getSize().x/11*2, getPosition().y+2));
			houses[i].setSize(new PVector(getSize().x/11, getSize().y));
		}
	}
	
	public void drawHouses() {
		for(int i = 0; i < houses.length; i ++) {
			houses[i].setSides();
			houses[i].display();
		}
	}
	
	public void createHouses() {
		houses = new House[5];
		for(int i = 0; i < houses.length; i++) {
			houses[i] = new House(p);
		}
	}

	public House[] getHouses() {
		return houses;
	}

	public void setHouses(House[] houses) {
		this.houses = houses;
	}
	
}
