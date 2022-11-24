package asteroids;
//David Grot CSI2999

import javafx.scene.shape.Polygon;

//Ammo class extends character class.
public class Ammo extends Character{

	//Draw ammo polygon using a super to hold coordinates for a small square.
    public Ammo(int x, int y){
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
    }

}
