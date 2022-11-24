package asteroids;
//David Grot CSI2999

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

//character or entity class
public class Character {

	//declare private variables
    private Polygon character;
    private Point2D movement;
    private Boolean alive;
  
    //set character parameters and styling
    public Character(Polygon polygon, int x, int y) {
        alive = true;
        this.character = polygon;
        this.movement = new Point2D(0, 0);
        character.setTranslateX(x);
        character.setTranslateY(y);
        character.setFill(Color.TRANSPARENT);
        character.setStroke(Color.WHITE);
        character.setStrokeWidth(3);
        character.setStrokeType(StrokeType.CENTERED);
    }

    //set alive method
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    //is alive method
    public Boolean isAlive() {
        return alive;
    }

    //get character method
    public Polygon getCharacter() {
        return character;
    }
    
    //turn left rotate speed at -3
    public void turnLeft() {
        character.setRotate(character.getRotate() - 3);
    }

    //turn right rotate speed at +3
    public void turnRight() {
        character.setRotate(character.getRotate() + 3);
    }

    //point 2d get movement method
    public Point2D getMovement() {
        return movement;
    }

    
    //point 2d set movement
    public void setMovement(Point2D movement) {
        this.movement = movement;
    }


    //move method to keep everything on screen
    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());

        //if less than 0 pixels on the x axis, move to the max width pixel
        if (this.character.getTranslateX() < 0) {
            this.character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
        }

        //if more than width pixels on the x axis, move to the lowest width pixel
        if (this.character.getTranslateX() > AsteroidsApplication.WIDTH) {
            this.character.setTranslateX(this.character.getTranslateX() % AsteroidsApplication.WIDTH);
        }

        //if less than 0 pixels on the y axis, move to the max height pixel
        if (this.character.getTranslateY() < 0) {
            this.character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
        }

        //if more than height pixels on the y axis, move to the lowest height pixel
        if (this.character.getTranslateY() > AsteroidsApplication.HEIGHT) {
            this.character.setTranslateY(this.character.getTranslateY() % AsteroidsApplication.HEIGHT);
        }

    }

    //accelerate method (changes speed of all character entities)
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.character.getRotate()));
        changeX *= 0.05;
        changeY *= 0.05;

        this.movement = this.movement.add(changeX, changeY);
        this.character = getCharacter();
    }

    //collide between characters
    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

}