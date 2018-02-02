package ie.studium.froggerModel.gameObjects.movers;

import ie.studium.froggerModel.gameObjects.House;
import ie.studium.froggerModel.gameObjects.movers.floaters.Floater;
import ie.studium.froggerModel.gameObjects.segments.River;
import ie.studium.froggerModel.gameObjects.segments.Rivers;
import processing.core.PApplet;
import processing.core.PVector;

public class Frog extends Mover{
	PVector pointA, pointB, pointC;

	public Frog(PApplet p) {
		super(p);
		setColour(p.color(50, 200, 50));
		setSize(new PVector(50, 60));
		setSpeed(new PVector(p.width/11, p.height/10));
		pointA = new PVector(getPosition().x, getPosition().y + getSize().y);
		pointB = new PVector(getPosition().x + getSize().x/2, getPosition().y);
		pointC = new PVector(getPosition().x + getSize().x, getPosition().y + getSize().y);
	}

	@Override
	public void display() {
		setSides();
		updatePoints();
		p.fill(getColour());
		p.triangle(pointA.x, pointA.y, pointB.x, pointB.y, pointC.x, pointC.y);
	}
	
	public void updatePoints() {
		pointA = new PVector(getPosition().x, getPosition().y + getSize().y);
		pointB = new PVector(getPosition().x + getSize().x/2, getPosition().y);
		pointC = new PVector(getPosition().x + getSize().x, getPosition().y + getSize().y);
	}
	
	public boolean overlaps(Mover m) {
		boolean overlaps = getRight() >= m.getLeft() && getLeft() <= m.getRight() &&
						   getTop() <= m.getBottom() && getBottom() >= m.getTop();
						   
		if(overlaps) {return true;}
		else {return false;}
	}
	
	public boolean isOver(Floater m) {
		boolean overlaps = getRight() - getSize().x/2 >= m.getLeft() && getLeft() + getSize().x/2 <= m.getRight() &&
						   getTop() <= m.getBottom() && getBottom() >= m.getTop();
						   
		if(overlaps) {return true;}
		else {return false;}
	}
	
	public boolean isOver(House m) {
		boolean overlaps = getRight() - getSize().x/2 >= m.getLeft() && getLeft() + getSize().x/2 <= m.getRight() &&
						   getTop() <= m.getBottom() && getBottom() >= m.getTop();
						   
		if(overlaps) {return true;}
		else {return false;}
	}
	
	public boolean isOver(River m) {
		boolean overlaps = getRight() - getSize().x/2 >= m.getLeft() && getLeft() + getSize().x/2 <= m.getRight() &&
						   getTop() <= m.getBottom() && getBottom() >= m.getTop();
						   
		if(overlaps) {return true;}
		else {return false;}
	}

}
