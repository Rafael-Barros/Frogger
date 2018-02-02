package ie.studium.froggerModel.gameObjects.movers;

import ie.studium.froggerModel.gameObjects.GameObject;
import ie.studium.froggerModel.interfaces.Movable;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class Mover extends GameObject implements Movable{
	private PVector speed;
	
	public Mover(PApplet p) {
		super(p);
		speed = new PVector(2, 2);
	}

	@Override
	public void moveRight() {
		getPosition().x += speed.x;
	}

	@Override
	public void moveLeft() {
		getPosition().x -= speed.x;
	}

	@Override
	public void moveUp() {
		getPosition().y -= speed.y;
	}

	@Override
	public void moveDown() {
		getPosition().y += speed.y;
	}
	
	@Override
	public boolean isOutOfRight() {
		boolean right = getPosition().x > p.width;
		if(right) {return true;}
		else {return false;}
	}

	@Override
	public boolean isOutOfLeft() {
		boolean left = getPosition().x + getSize().x < 0;
		if(left) {return true;}
		else {return false;}
	}

	@Override
	public boolean isOutOftop() {
		boolean top = getPosition().y < 0;
		if(top) {return true;}
		else {return false;}
	}

	@Override
	public boolean isOutOfBotton() {
		boolean botton = getPosition().y + getSize().y > p.width;
		if(botton) {return true;}
		else {return false;}
	}
	
	
	
	// GETTERS AND SETTERS //  // GETTERS AND SETTERS //  // GETTERS AND SETTERS //

	public PVector getSpeed() {
		return speed;
	}

	public void setSpeed(PVector speed) {
		this.speed = speed;
	}

}
