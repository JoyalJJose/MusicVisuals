package C22756115;

import processing.core.*;

public class Scene2 {
    JoyalsVisual jv;
    PImage s2w;
    Flock flock;

    public Scene2 (JoyalsVisual jv)
    {
        this.jv = jv;
        s2w = jv.loadImage("scene2.jpeg");

        // Create flock of boids
        flock = new Flock();
        for (int i = 0; i < 1250; i++) {
            flock.addBoid(new Boid(jv.random(0,jv.width), jv.random(jv.height), jv));
        }
    }

    public void render()
    {
        // Wallpaper
        jv.image(s2w, jv.width/2, jv.height/2, 1920, 1080);
        jv.colorMode(PApplet.RGB);
        // Run Boid's Simulation
        flock.run();

        // Add a new boid into the System
        if (jv.mousePressed == true) {
            jv.s2.addBoidMouse();
        }
    }

    // Create boids at position of mouse
    void addBoidMouse() {
        flock.addBoid(new Boid(jv.mouseX, jv.mouseY, jv));
    }

}
