package C22756115;

public class Raindrop {
    JoyalsVisual jv;

    float x, y, z; // Position
    float speed; // Falling speed
    float length;

    Raindrop(JoyalsVisual jv, float x, float y, float z) {
        this.jv = jv;
        this.x = x;
        this.y = y;
        this.z = z;
        speed = jv.random(6, 8);
        length = jv.random(5, 20);
    }

    // Moving raindrop down & drawing it
    public void fall() {
        y = y + speed;
        // jv.fill(0, 10, 200, 180);
        jv.line(x, y, z, x, y-length, z);
    }

    public void tingle() {}

    // Make splash effect when hitting ground
    public void splash() {
        jv.image(jv.spot, x, y);
    }

    boolean onGround() {
        return y+10 > jv.height;
    }

    boolean offScreen() {
        return y-length > jv.height;
    }

}
