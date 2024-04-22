package C22756115;

class Rain {
    JoyalsVisual jv;

    int numDrops = 0;
    Raindrop[] drops;
    int maxDrops = 100;

    Rain(JoyalsVisual jv) {
        this.jv = jv;
        drops = new Raindrop[maxDrops];
        // drops[0] = new Raindrop(jv, jv.random(jv.width), 0, 0);
    }

    void createRaindrop() {
        if (numDrops < drops.length && jv.random(10) < 1) {
            drops[numDrops] = new Raindrop(jv, jv.random(jv.width), 0, 0);
            numDrops++;
        }
    }

    void render() {
        createRaindrop();

        for (int i = 0; i < numDrops; i++) {
            drops[i].fall();
            // drops[i].tingle();
            if (drops[i].offScreen()) {
              // If raindrop is off screen, reset its position
              drops[i].y = 0;
              drops[i].x = jv.random(jv.width);
            } 
            else if (drops[i].onGround()) {
                // drops[i].splash();
            }
        }
    }
}
