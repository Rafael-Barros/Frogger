package ie.studium.froggerModel.gameObjects;

import ie.studium.froggerModel.interfaces.Displayable;
import ie.studium.froggerModel.interfaces.Hoverable;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class GameObject implements Displayable, Hoverable{
	protected PApplet p;
	private PVector position, size;
	private float right, left, top, bottom;
	private int colour;
	
	public GameObject(PApplet p) {
		this.p = p;
		this.position = new PVector(0, 0);
		this.size = new PVector(100, 50);
		colour = 255;
		setSides();
	}

	@Override
	public abstract void display();
	
	@Override
	public boolean isHovered() {
		boolean hovered = p.mouseX >= left && p.mouseX <= right && p.mouseY >= top && p.mouseY <= bottom;
		if(hovered) {return true;}
		else {return false;}
	}
	
	public void setSides() {
		right = position.x + size.x;
		left = position.x;
		top = position.y;
		bottom = position.y + size.y;
	}
	
	
	//GETTERS AND SETTERS //  //GETTERS AND SETTERS //  //GETTERS AND SETTERS //  //GETTERS AND SETTERS //
	

	public PVector getPosition() {
		return position;
	}

	public void setPosition(PVector position) {
		this.position = position;
	}

	public PVector getSize() {
		return size;
	}

	public void setSize(PVector size) {
		this.size = size;
	}

	public float getRight() {
		return right;
	}

	public void setRight(float right) {
		this.right = right;
	}

	public float getLeft() {
		return left;
	}

	public void setLeft(float left) {
		this.left = left;
	}

	public float getTop() {
		return top;
	}

	public void setTop(float top) {
		this.top = top;
	}

	public float getBottom() {
		return bottom;
	}

	public void setBottom(float bottom) {
		this.bottom = bottom;
	}

	public int getColour() {
		return colour;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}

}
