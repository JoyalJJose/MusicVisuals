package C22756115;

import processing.core.*;

public class Scene2 {
    JoyalsVisual jv;
    Flock flock;

    public Scene2 (JoyalsVisual jv)
    {
        this.jv = jv;

        // Create flock of boids
        flock = new Flock();
        for (int i = 0; i < 1250; i++) {
            flock.addBoid(new Boid(jv.random(0,jv.width), jv.random(jv.height), jv));
        }
    }

    public void render()
    {
        jv.background(0);
        jv.image(jv.s2w, jv.width/2, jv.height/2, 1920, 1080);
        jv.colorMode(PApplet.RGB);
        flock.run();
    }

    // Add a new boid into the System
    void addBoidMouse() {
        flock.addBoid(new Boid(jv.mouseX, jv.mouseY, jv));
    }

}
