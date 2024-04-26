package C22756115;

import processing.core.*;

public class Raindrop {
    JoyalsVisual jv;

    float x, y, z; // Position
    float speed; // Falling speed
    float length; // Vary speed according to length

    Raindrop(JoyalsVisual jv, float x, float y, float z) {
        this.jv = jv;
        this.x = x;
        this.y = y;
        this.z = z;
        length = jv.random(8, 20);
        // Larger raindrops fall faster
        speed = (float)(jv.random(6, 8) * (length*0.1));
    }

    // Moving raindrop down & drawing it
    public void fall() {
        y = y + speed;
        // jv.fill(0, 10, 200, 180);
        jv.line(x, y, z, x, y-length, z);
    }

    public void tingle() {}

    // Make splash effect when hitting ground
    public void splash(PImage splash) {
        jv.image(splash, x, y, jv.random(50, 75), jv.random(50, 75));
    }

    // Check if touching ground to trigger splash()
    boolean onGround() {
        return y+10 > jv.height;
    }

    // Check if offscreen to re-render
    boolean offScreen() {
        return y-length > jv.height;
    }

}
