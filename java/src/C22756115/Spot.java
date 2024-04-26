package C22756115;

public class Spot {
    JoyalsVisual jv;

    public Spot(JoyalsVisual jv) {
        this.jv = jv;
    } 

    public void createSpots(int x) {
        for (int i = 0; i < x; i++) {
            jv.image(jv.s1.spot, jv.random(jv.width), jv.random(jv.height), jv.random(5, 15), jv.random(5,15));
        }
    }
}
