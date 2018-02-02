package ie.studium.froggerModel.gameObjects.segments;

import ie.studium.froggerModel.gameObjects.Lives;
import ie.studium.froggerModel.gameObjects.Score;
import ie.studium.froggerModel.gameObjects.Timer;
import processing.core.PApplet;
import processing.core.PVector;

public class Status extends Segment{
	Score score;
	Lives lives;
	Timer timer;

	public Status(PApplet p) {
		super(p);
		setColour(100);
		createScore();
		createLives();
		createTimer();
	}

	@Override
	public void display() {
		drawContainer();
		drawScore();
		drawLives();
		drawTimer();
		
		updateFields();
	}

	public void drawContainer() {
		p.rectMode(p.CORNER);
		p.fill(getColour());
		p.rect(getPosition().x, getPosition().y, getSize().x, getSize().y);
	}
	
	public void createTimer() {
		timer = new Timer(p);
	}
	
	public void drawTimer() {
		timer.display();
	}
	
	public void createLives() {
		lives = new Lives(p);
	}
	
	public void drawLives() {
		lives.display();
	}
	
	public void createScore() {
		score = new Score(p);
		
	}
	
	public void drawScore() {
		score.display();
	}
	
	public void updateFields() {
		score.setSize(new PVector(getSize().x/11*4, getSize().y));
		score.setPosition(getPosition());
		lives.setSize(new PVector(getSize().x/11*3, getSize().y));
		lives.setPosition(new PVector(getPosition().x + getSize().x/11*4, getPosition().y));
		timer.setSize(new PVector(getSize().x/11*4, getSize().y));
		timer.setPosition(new PVector(getPosition().x + getSize().x/11*7, getPosition().y));
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Lives getLives() {
		return lives;
	}

	public void setLives(Lives lives) {
		this.lives = lives;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	
	
}
