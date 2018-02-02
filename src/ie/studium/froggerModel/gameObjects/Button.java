package ie.studium.froggerModel.gameObjects;

import ie.studium.froggerModel.interfaces.Clickable;
import processing.core.PApplet;
import processing.core.PVector;

public class Button extends GameObject implements Clickable{
	private String text;
	private int textColour, textSize, leftPadding, topPadding, alpha;
	

	public Button(PApplet p, String text) {
		super(p);
		this.text = text;
		setSize(new PVector(100, 35));
		textColour = 0;
		textSize = (int) getSize().x/7;
		leftPadding = (int) (getSize().x*0.365f);
		topPadding = (int) (getSize().y*0.6f);
		alpha = 255;
	}

	@Override
	public void display() {
		setSides();
		drawContainer();
		drawText();
		
	}
	
	@Override
	public boolean isClicked() {
		if(isHovered() && p.mousePressed) {return true;}
		else{return false;}
	}
	
	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour(), alpha);
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y, 30);
		
	}
	
	public void drawText() {
		p.textSize(textSize);
		p.fill(textColour);
		p.text(text, getPosition().x + leftPadding, getPosition().y + topPadding);
	}

	
	//  GETTERS AND SETTERS  //  //  GETTERS AND SETTERS  //  //  GETTERS AND SETTERS  //

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTextColour() {
		return textColour;
	}

	public void setTextColour(int textColour) {
		this.textColour = textColour;
	}

	public int getTextSize() {
		return textSize;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	public int getLeftPadding() {
		return leftPadding;
	}

	public void setLeftPadding(int leftPadding) {
		this.leftPadding = leftPadding;
	}

	public int getTopPadding() {
		return topPadding;
	}

	public void setTopPadding(int topPadding) {
		this.topPadding = topPadding;
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

}
