package C22756115;

import processing.core.*;

class Rain {
    JoyalsVisual jv;
    PImage splash;

    int numDrops = 0;
    Raindrop[] drops;
    int maxDrops = 100;

    Rain(JoyalsVisual jv) {
        this.jv = jv;
        drops = new Raindrop[maxDrops];
        splash = jv.loadImage("splash.png");
    }

    // Create raindrops with random length & position
    void createRaindrops() {
        if (numDrops < drops.length && jv.random(10) < 1) {
            drops[numDrops] = new Raindrop(jv, jv.random(jv.width), 0, 0);
            numDrops++;
        }
    }

    void render() {
        // Create raindrop objects
        createRaindrops();

        for (int i = 0; i < numDrops; i++) {
            drops[i].fall();
            // drops[i].tingle();
            if (drops[i].offScreen()) {
              // If raindrop is off screen, reset its position
              drops[i].y = 0;
              drops[i].x = jv.random(jv.width);
            } 
            // Trigger splash effect - pass splash image to Raindrop
            else if (drops[i].onGround()) {
                drops[i].splash(splash);
            }
        }
    }
}
