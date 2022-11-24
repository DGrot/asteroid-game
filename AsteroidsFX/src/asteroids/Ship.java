package asteroids;
//David Grot CSI2999

import javafx.scene.shape.Polygon;

	//Ship extends character class
public class Ship extends Character{

	//draw ship polygon using x,y coordinates using a super to make a V shape.
    public Ship(int x, int y){
        super(new Polygon(-10, -10, 15, 0, -10, 10, 0, 0),x,y);

	}

}