package ie.studium.froggerModel.interfaces;

public interface Movable {
	void moveRight();
	void moveLeft();
	void moveUp();
	void moveDown();
	boolean isOutOfRight();
	boolean isOutOfLeft();
	boolean isOutOftop();
	boolean isOutOfBotton();
}
