package asteroids;
//David Grot CSI2999

import java.util.Random;
//Asteroid extends character class
public class Asteroid extends Character{
    
	//Declare double for rotation movement
	private double rotationalMovement;


	//Declare public asteroid using x,y.
    public Asteroid (int x, int y){
    	//Super asteroid factory will create an asteroid on the x,y coordinate.
        super(new AsteroidFactory().createAsteroid(),x,y);
        //random function
        Random rnd = new Random();
        //super set rotation randomly from 0 to 360 degrees
        super.getCharacter().setRotate(rnd.nextInt(360));
        //integer acceleration from asteroids from 1 to 11
        int accelerationAmount = 1 + rnd.nextInt(10);
        //if the acceleration amount is greater than 0 make the asteroid accelerate
        for (int i = 0; i < accelerationAmount; i++) {
            accelerate();
        }
        //set rotation movement speed of asteroids
        this.rotationalMovement = 1.0 - rnd.nextDouble();
    }

    //insert into move
    @Override
    public void move() {
        super.move();
        super.getCharacter().setRotate(super.getCharacter().getRotate() + rotationalMovement);
    }
}
