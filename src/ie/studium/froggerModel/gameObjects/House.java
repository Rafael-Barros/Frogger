package ie.studium.froggerModel.gameObjects;

import processing.core.PApplet;

public class House extends GameObject{
	private boolean occupied;

	public House(PApplet p) {
		super(p);
		setColour(p.color(50, 50, 200));
	}

	@Override
	public void display() {
		drawHouse();
	}
	
	public void drawHouse() {
		setSides();
		p.rectMode(p.CORNER);
		p.noStroke();
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
		p.stroke(1);
	}
	
	public void drawOccupied() {
		p.rectMode(p.CORNER);
		p.fill(p.color(50, 200, 50));
		p.rect(getPosition().x + getSize().x/4, getPosition().y + getSize().y/4, getSize().x/2, getSize().y/2);
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	


}
