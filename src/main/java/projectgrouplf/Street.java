package projectgrouplf;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.shape.Line;

public class Street {

    ArrayList<Street> streetArray = new ArrayList<>();
    ArrayList<Line> lineArray = new ArrayList<>();
    ArrayList<Coordinate> coordinateArray = new ArrayList<Coordinate>();

    /** creates the street where the enemies move, the number of parameter must be a even number*/
    public Street(Coordinate ...a) {
        for (int i = 0; i < a.length; i++) {
            lineArray.add(new Line(a[i].getCoordinateX(), a[i].getCoordinateY(), a[i = i+1].getCoordinateX(), a[i].getCoordinateY()));
        }
        for (int i = 0; i < a.length; i++)
            coordinateArray.add(a[i]);
    }

    /** creates the street where the enemies move, the number of parameter must be a even number*/
    public Street getRandomStreet() {
        addStreetsToArray();
        Random generator = new Random();
        int randomIndex = generator.nextInt(streetArray.size());
        return streetArray.get(randomIndex);
    }

    /** Adds the streets in this method to the array */
    private void addStreetsToArray() {
        newStreet1();
        newStreet2();
        newStreet3();
        newStreet4();
    }

    private void newStreet1() {
        // first street
        Coordinate d1 = new Coordinate(App.startingCord.getCoordinateX(), App.startingCord.getCoordinateY(), 0);
        Coordinate d2 = new Coordinate(App.startingCord.getCoordinateX() +200, App.startingCord.getCoordinateY() );

        Coordinate d3 = new Coordinate(App.startingCord.getCoordinateX() +200, App.startingCord.getCoordinateY(), -1);
        Coordinate d4 = new Coordinate(App.startingCord.getCoordinateX() +200, App.startingCord.getCoordinateY() +100 );

        Coordinate d5 = new Coordinate(App.startingCord.getCoordinateX() +200, App.startingCord.getCoordinateY() +100, 0);
        Coordinate d6 = new Coordinate(App.startingCord.getCoordinateX() +400, App.startingCord.getCoordinateY() +100);

        Coordinate d7 = new Coordinate(App.startingCord.getCoordinateX() +400, App.startingCord.getCoordinateY() +100, 1);
        Coordinate d8 = new Coordinate(App.startingCord.getCoordinateX() +400, App.startingCord.getCoordinateY() );

        Coordinate d9 = new Coordinate(App.startingCord.getCoordinateX() +400, App.startingCord.getCoordinateY(), 0);
        Coordinate d10 = new Coordinate(App.startingCord.getCoordinateX() +800, App.startingCord.getCoordinateY() );
        streetArray.add(new Street(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10));
    }

    private void newStreet2() {
        // second street
        Coordinate b1 = new Coordinate(App.startingCord.getCoordinateX(), App.startingCord.getCoordinateY(), 0);
        Coordinate b2 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() );

        Coordinate b3 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY(), -1);
        Coordinate b4 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() +175 );

        Coordinate b5 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() +175, 0);
        Coordinate b6 = new Coordinate(App.startingCord.getCoordinateX() +450, App.startingCord.getCoordinateY() +175);

        Coordinate b7 = new Coordinate(App.startingCord.getCoordinateX() +450, App.startingCord.getCoordinateY() +175, 1);
        Coordinate b8 = new Coordinate(App.startingCord.getCoordinateX() +450, App.startingCord.getCoordinateY() -25);

        Coordinate b9 = new Coordinate(App.startingCord.getCoordinateX() +450, App.startingCord.getCoordinateY() -25, 2);
        Coordinate b10 = new Coordinate(App.startingCord.getCoordinateX() +250, App.startingCord.getCoordinateY() -25 );

        Coordinate b11 = new Coordinate(App.startingCord.getCoordinateX() +250, App.startingCord.getCoordinateY() -25, 1);
        Coordinate b12 = new Coordinate(App.startingCord.getCoordinateX() +250, App.startingCord.getCoordinateY() -175 );

        Coordinate b13 = new Coordinate(App.startingCord.getCoordinateX() +250, App.startingCord.getCoordinateY() -175, 0);
        Coordinate b14 = new Coordinate(App.startingCord.getCoordinateX() +700, App.startingCord.getCoordinateY() -175 );

        Coordinate b15 = new Coordinate(App.startingCord.getCoordinateX() +700, App.startingCord.getCoordinateY() -175, -1);
        Coordinate b16 = new Coordinate(App.startingCord.getCoordinateX() +700, App.startingCord.getCoordinateY() +125 );

        Coordinate b17 = new Coordinate(App.startingCord.getCoordinateX() +700, App.startingCord.getCoordinateY() +125, 0);
        Coordinate b18 = new Coordinate(App.startingCord.getCoordinateX() +800, App.startingCord.getCoordinateY() +125 );
        streetArray.add(new Street(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18));
    }

    private void newStreet3() {
        // third street
        Coordinate c1 = new Coordinate(App.startingCord.getCoordinateX(), App.startingCord.getCoordinateY(), 0);
        Coordinate c2 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() );

        Coordinate c3 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY(), -1);
        Coordinate c4 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() +175 );

        Coordinate c5 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() +175, 0);
        Coordinate c6 = new Coordinate(App.startingCord.getCoordinateX() +600, App.startingCord.getCoordinateY() +175);

        Coordinate c7 = new Coordinate(App.startingCord.getCoordinateX() +600, App.startingCord.getCoordinateY() +175, 1);
        Coordinate c8 = new Coordinate(App.startingCord.getCoordinateX() +600, App.startingCord.getCoordinateY() -125);

        Coordinate c9 = new Coordinate(App.startingCord.getCoordinateX() +600, App.startingCord.getCoordinateY() -125, 2);
        Coordinate c10 = new Coordinate(App.startingCord.getCoordinateX() +200, App.startingCord.getCoordinateY() -125 );

        Coordinate c11 = new Coordinate(App.startingCord.getCoordinateX() +200, App.startingCord.getCoordinateY() -125, -1);
        Coordinate c12 = new Coordinate(App.startingCord.getCoordinateX() +200, App.startingCord.getCoordinateY() +75 );

        Coordinate c13 = new Coordinate(App.startingCord.getCoordinateX() +200, App.startingCord.getCoordinateY() +75, 0);
        Coordinate c14 = new Coordinate(App.startingCord.getCoordinateX() +400, App.startingCord.getCoordinateY() +75 );

        Coordinate c15 = new Coordinate(App.startingCord.getCoordinateX() +400, App.startingCord.getCoordinateY() +75, 1);
        Coordinate c16 = new Coordinate(App.startingCord.getCoordinateX() +400, App.startingCord.getCoordinateY() -25 );

        Coordinate c17 = new Coordinate(App.startingCord.getCoordinateX() +400, App.startingCord.getCoordinateY() -25, 0);
        Coordinate c18 = new Coordinate(App.startingCord.getCoordinateX() +800, App.startingCord.getCoordinateY() -25 );
        streetArray.add(new Street(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18));
    }

    private void newStreet4() {
        // fourth street
        Coordinate a1 = new Coordinate(App.startingCord.getCoordinateX(), App.startingCord.getCoordinateY(), 0);
        Coordinate a2 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() );

        Coordinate a3 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY(), 1);
        Coordinate a4 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() -125 );

        Coordinate a5 = new Coordinate(App.startingCord.getCoordinateX() +50, App.startingCord.getCoordinateY() -125, 0);
        Coordinate a6 = new Coordinate(App.startingCord.getCoordinateX() +300, App.startingCord.getCoordinateY() -125);

        Coordinate a7 = new Coordinate(App.startingCord.getCoordinateX() +300, App.startingCord.getCoordinateY() -125, -1);
        Coordinate a8 = new Coordinate(App.startingCord.getCoordinateX() +300, App.startingCord.getCoordinateY() +175);

        Coordinate a9 = new Coordinate(App.startingCord.getCoordinateX() +300, App.startingCord.getCoordinateY() +175, 0);
        Coordinate a10 = new Coordinate(App.startingCord.getCoordinateX() +700, App.startingCord.getCoordinateY() +175 );

        Coordinate a11 = new Coordinate(App.startingCord.getCoordinateX() +700, App.startingCord.getCoordinateY() +175, 1);
        Coordinate a12 = new Coordinate(App.startingCord.getCoordinateX() +700, App.startingCord.getCoordinateY() +25 );

        Coordinate a13 = new Coordinate(App.startingCord.getCoordinateX() +700, App.startingCord.getCoordinateY() +25, 2);
        Coordinate a14 = new Coordinate(App.startingCord.getCoordinateX() +500, App.startingCord.getCoordinateY() +25 );

        Coordinate a15 = new Coordinate(App.startingCord.getCoordinateX() +500, App.startingCord.getCoordinateY() +25, 1);
        Coordinate a16 = new Coordinate(App.startingCord.getCoordinateX() +500, App.startingCord.getCoordinateY() -125 );

        Coordinate a17 = new Coordinate(App.startingCord.getCoordinateX() +500, App.startingCord.getCoordinateY() -125, 0);
        Coordinate a18 = new Coordinate(App.startingCord.getCoordinateX() +800, App.startingCord.getCoordinateY() -125 );
        streetArray.add(new Street(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18));
    }

}
