package asteroids;
//David Grot CSI2999

import java.util.Random;
import javafx.scene.shape.Polygon;

//asteroid creation class
public class AsteroidFactory {

	//Asteroid Polygon Creation
    public Polygon createAsteroid(){
    	//random function
        Random rnd = new Random();
        //double size 8 pixels + random number from 25
        double size = 8 + rnd.nextInt(25);

        //set polygon name to polygon.
        Polygon polygon = new Polygon();
        //set doubles
        double c1 = 0.3;
        double c2 = 0.8;
        double s1 = 0.95;
        double s2 = 0.6;
        //polygon get edges in relation to the set size
        polygon.getPoints().addAll(
                size, 0.0,
                size * c1, -1 * size * s1,
                -1 * size * c2, -1 * size * s2,
                -1 * size * c2, size * s2,
                size * c1, size * s1);

        //for each polygon get the edges and size
        for (int i = 0; i < polygon.getPoints().size(); i++) {
            //polygon set points, set count, get points, get count 
            polygon.getPoints().set(i, polygon.getPoints().get(i));
        }
        return polygon;
    }

}