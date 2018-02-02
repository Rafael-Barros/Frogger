package ie.studium.froggerModel.screens;

import ie.studium.froggerModel.gameObjects.segments.Grass;
import ie.studium.froggerModel.gameObjects.segments.Highway;
import ie.studium.froggerModel.gameObjects.segments.Paviment;
import ie.studium.froggerModel.gameObjects.segments.Rivers;
import ie.studium.froggerModel.gameObjects.segments.Status;
import ie.studium.froggerModel.gameObjects.movers.Frog;
import ie.studium.froggerModel.gameObjects.movers.floaters.Floater;
import ie.studium.froggerModel.gameObjects.movers.floaters.Log;
import ie.studium.froggerModel.gameObjects.movers.floaters.Turtle;
import ie.studium.froggerModel.gameObjects.movers.vehicles.Bike;
import ie.studium.froggerModel.gameObjects.movers.vehicles.Bus;
import ie.studium.froggerModel.gameObjects.movers.vehicles.Car;
import ie.studium.froggerModel.gameObjects.movers.vehicles.Vehicle;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import processing.core.PApplet;
import processing.core.PVector;

public class GamePlay{
	PApplet p;
	private static File background_sound = new File("data/frogger_background_sound.wav");
	private static File dying_frog = new File("data/dying_frog.wav");
	private static File leap_frog = new File("data/leap_sound.wav");
	private static File sink_frog = new File("data/sink_sound.wav");
	private Clip clip;
	private Paviment[] paviments;
	private Highway highway;
	private Rivers rivers;
	private Grass grass;
	private Status status;
	private Vehicle[][] vehicles;
	private Floater[][] floaters;
	private Frog frog;
	private boolean gameWon = false;

	public GamePlay(PApplet p) {
		this.p = p;
		loadBackgroundSound(background_sound);
		createPaviments();
		createHighway();
		createVehicles();
		createRivers();
		createFloaters();
		createGrass();
		createStatus();
		createFrog();
	}
	
	public void display() {
		playBackgroundSound();
		drawStatus();
		drawPaviments();
		drawHighway();
		drawVehicles();
		drawRivers();
		drawFloaters();
		drawGrass();
		drawFrog();
		
		statusController();
		vehiclesController();
		floatersController();	
		frogController();
		housesController();
	}
	
	//  CLASS'S METHODS  //  //  CLASS'S METHODS  //  //  CLASS'S METHODS  //
	
	public void createFrog() {
		frog = new Frog(p);
		frog.setSize(new PVector(p.width/22, p.height/20));
		frog.setPosition(new PVector(p.width/11*5 + frog.getSize().x/2, p.height/10*9 + frog.getSize().y/2));
	}
	
	public void drawFrog() {
		frog.display();
	}
	
	public void playSound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void loadBackgroundSound(File sound) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			
		} catch (Exception e) {
			System.out.println("Check the name and/or the location of the sound file");
			e.printStackTrace();
		}
	}
	
	public void playBackgroundSound() {
		if(!clip.isRunning()) {
			clip.loop(-1);
		}else {	}	
	}
	
	public void stopBackgroundSound() {
		clip.stop();
	}
	
	public void createFloaters() {
		floaters = new Floater[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				floaters[i][0] = new Log(p);
				floaters[i][0].setPosition(new PVector(0 + i*p.width*0.4f, p.height/10*2 + p.height*0.03f));
				floaters[i][0].setSpeed(new PVector(1.5f, 2));
				
				floaters[i][1] = new Turtle(p);
				floaters[i][1].setPosition(new PVector(0 + floaters[i][1].getSize().x/2 + i*p.width*0.35f, p.height/10*3 + p.height*0.03f));
				
				floaters[i][2] = new Log(p);
				floaters[i][2].setPosition(new PVector(0 + i*p.width*0.4f, p.height/10*4 + p.height*0.03f));
			}
		}
	}
	
	public void drawFloaters() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				floaters[i][j].display();
			}
		}
	}
	
	public void createVehicles() {
		vehicles = new Vehicle[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				vehicles[i][0] = new Car(p); 
				vehicles[i][0].setPosition(new PVector(p.width/22 + i*p.width*0.4f, p.height/10*6 + p.height/10*0.2f));
				vehicles[i][0].setSpeed(new PVector(2,2));
				
				vehicles[i][1] = new Bus(p);
				vehicles[i][1].setPosition(new PVector(p.width/30 + i*p.width*0.4f, p.height/10*7 + p.height/10*0.17f));
				vehicles[i][1].setSpeed(new PVector(1.5f,3));
				
				vehicles[i][2] = new Bike(p);
				vehicles[i][2].setPosition(new PVector(p.width/22 + i*p.width*0.4f, p.height/10*8 + p.height/10*0.4f));
				vehicles[i][2].setSpeed(new PVector(3,3));
			}
		}	
	}
	
	public void drawVehicles() {
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j++) {
				vehicles[i][j].display();
			}
		}
	}
	
	public void createStatus() {
		status = new Status(p);
	}
	
	public void drawStatus() {
		status.display();
	}
	
	public void createGrass() {
		grass = new Grass(p);
		grass.setPosition(new PVector(0, p.height/10*1));
	}
	
	public void drawGrass() {
		grass.display();
	}
	
	public void createRivers() {
		rivers = new Rivers(p);
		rivers.setPosition(new PVector(0, p.height/10*2));
		rivers.setSize(new PVector(p.width, p.height/10*3));
	}
	
	public void drawRivers() {
		rivers.display();
	}
	
	public void createHighway() {
		highway = new Highway(p);
		highway.setPosition(new PVector(0, p.height/10*6));
		highway.setSize(new PVector(p.width, p.height/10*3));
	}
	
	public void drawHighway() {
		highway.display();
	}
	
	public void createPaviments() {
		paviments = new Paviment[2];
		for(int i = 0; i < paviments.length; i++) {
			paviments[i] = new Paviment(p);
		}
	}
	
	public void drawPaviments() {
		for(int i = 0; i < paviments.length; i++) {
			paviments[0].setPosition(new PVector(0, p.height/10*5));
			paviments[1].setPosition(new PVector(0, p.height/10*9));
			paviments[i].display();
		}
	}
	
	//  CLASS'S CONTROLLERS  //  //  CLASS'S CONTROLLERS  //  //  CLASS'S CONTROLLERS  //
	
	public void statusController() {
		
		if(status.getLives().getLives() > 0 && !gameWon) {
			status.getTimer().startTimer();
			
			}else if(status.getLives().getLives() <= 0 && !gameWon){
				p.fill(255);
				p.textSize(70);
				p.text("GAME OVER", p.width/7, p.height/2);
				clip.stop();
				clip.close();
				status.getTimer().stopTimer();
			}
	}
	
	public void frogController() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {

				if(frog.overlaps(vehicles[i][j])) {
					playSound(dying_frog);
					frog.setPosition(new PVector(p.width/11*5 + frog.getSize().x/2, p.height/10*9 + frog.getSize().y/2));
					status.getLives().subtractLife();
				}
				
				if(frog.isOver(floaters[i][j]) && floaters[i][j].getClass() == Log.class) {
					frog.getPosition().x -= floaters[i][j].getSpeed().x;
				}else if(frog.isOver(floaters[i][j]) && floaters[i][j].getClass() == Turtle.class){
					frog.getPosition().x += floaters[i][j].getSpeed().x;
				}
				
				if(!(frog.isOver(floaters[0][0]) || frog.isOver(floaters[0][1]) || frog.isOver(floaters[0][2]) ||
				     frog.isOver(floaters[1][0]) || frog.isOver(floaters[1][1]) || frog.isOver(floaters[1][2]) ||
				     frog.isOver(floaters[2][0]) || frog.isOver(floaters[2][1]) || frog.isOver(floaters[2][2])) && 
				    (frog.getPosition().y > p.height/10*2 && frog.getPosition().y < p.height/10*5)) {
					
					playSound(sink_frog);
					frog.setPosition(new PVector(p.width/11*5 + frog.getSize().x/2, p.height/10*9 + frog.getSize().y/2));
					status.getLives().subtractLife();
				}
				
				if(frog.isOutOfBotton()) {
					frog.setPosition(new PVector(frog.getPosition().x, p.height/10*9 + frog.getSize().y/2));
				}
				
				if(frog.isOutOfLeft()) {
					frog.setPosition(new PVector(frog.getSize().x/2, frog.getPosition().y));
				}
				
				if(frog.isOutOfRight()) {
					frog.setPosition(new PVector(p.width - frog.getSize().x*1.45f, frog.getPosition().y));
				}
			}
		}
	}
	
	public void housesController() {
		for(int i = 0; i < 5; i++) {
			if(frog.isOver(grass.getHouses()[i])) {
				grass.getHouses()[i].setOccupied(true);
				frog.setPosition(new PVector(p.width/11*5 + frog.getSize().x/2, p.height/10*9 + frog.getSize().y/2));
				status.getScore().increaseValue(250 - status.getTimer().getTime()/10 + status.getLives().getLives()*100);
			}
			
			if(grass.getHouses()[i].isOccupied()) {
				grass.getHouses()[i].drawOccupied();	
			}
			
			if(grass.getHouses()[0].isOccupied() && grass.getHouses()[1].isOccupied() && 
			   grass.getHouses()[2].isOccupied() && grass.getHouses()[3].isOccupied() &&
			   grass.getHouses()[4].isOccupied()) {
				
				p.fill(255);
				p.textSize(50);
				p.text("Congratulations!!!", p.width/7, p.height/2);
				gameWon = true;
				status.getTimer().stopTimer();
			}
		}
	}
	
	public void vehiclesController() {
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j++) {
				if(j != 1) {
					vehicles[i][j].moveRight();
					if(vehicles[i][j].isOutOfRight()) {
						vehicles[i][j].setPosition(new PVector(0 - vehicles[i][j].getSize().x, vehicles[i][j].getPosition().y));
					}
				}else {
					vehicles[i][j].moveLeft();
					if(vehicles[i][j].isOutOfLeft()) {
						vehicles[i][j].setPosition(new PVector(p.width + vehicles[i][j].getSize().x/2, vehicles[i][j].getPosition().y));
					}
				}
			}
		}
	}

	public void floatersController() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(j != 1) {
					floaters[i][j].moveLeft();
					if(floaters[i][j].isOutOfLeft()) {
						floaters[i][j].setPosition(new PVector(p.width, floaters[i][j].getPosition().y));
					}
				}else {
					floaters[i][j].moveRight();
					if(floaters[i][j].isOutOfRight()) {
						floaters[i][j].setPosition(new PVector(0 - floaters[i][j].getSize().x/2, floaters[i][j].getPosition().y));
					}
				}
			}
		}
	}

	public Frog getFrog() {
		return frog;
	}

	public void setFrog(Frog frog) {
		this.frog = frog;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public File getLeap_frog() {
		return leap_frog;
	}

	public void setLeap_frog(File leap_frog) {
		this.leap_frog = leap_frog;
	}

	public boolean isGameWon() {
		return gameWon;
	}

	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
	}
	
}
