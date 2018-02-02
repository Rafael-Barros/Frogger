package ie.studium.froggerModel.gameObjects;

import processing.core.PApplet;

public class Timer extends GameObject{
	private int time;
	
	public Timer(PApplet p) {
		super(p);
		setColour(p.color(100));
		time = 0;
	}

	@Override
	public void display() {
		drawContainer();
		drawTimer();
	}

	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
	}
	
	public void drawTimer() {
		p.fill(255);
		p.textSize(getSize().x*0.1f);
		p.text("TIME", getPosition().x + getSize().x*0.35f, getPosition().y + getSize().y*0.35f);
		p.text(time/100, getPosition().x + getSize().x*0.35f, getPosition().y + getSize().y*0.8f);
	}
	
	public void startTimer() {
		time++;
	}
	
	public void stopTimer() {
		time += 0;
	}
	
	public void resetTimer() {
		time = 0;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
