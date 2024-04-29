package C22756115;

import processing.core.*;

public class Scene1 {
    JoyalsVisual jv;

    PImage sDim;
    PImage spot;

    Floor f;
    Rain rain;
    Spot spots;

    public Scene1(JoyalsVisual jv)
    {
        this.jv = jv;
        spots = new Spot(jv);
        f = new Floor(jv);
        sDim = jv.loadImage("spottedDimension.png");
        spot = jv.loadImage("spot.png");
    }

    public void render()
    {
        // jv.blendMode(1);
        // Background image
        jv.image(sDim, jv.width/2, jv.height/2, 1920, 1080);
        // Render terrain map floor
        f.render(0);
        // Spot image noise
        spots.createSpots(100);

        // Central sphere & circular waveform
        jv.translate(jv.width/2, jv.height/2, 0);
        float r1 = 200;
        float r2;
        float angle = 0;
        float inc = PConstants.TWO_PI / 360;

        for (int i = 0; i < 360; i++) {
            r2 = r1 + (Math.abs(jv.getLerpedBuffer()[i]) * jv.height/2 * 7f);

            float x1 = r1 * PApplet.cos(angle);
            float y1 = r1 * PApplet.sin(angle);
            float x2 = r2 * PApplet.cos(angle);
            float y2 = r2 * PApplet.sin(angle);
            angle = angle + inc;
            
            jv.strokeWeight(2);
            jv.stroke(0);
            jv.line(x1, y1, x2, y2);

            jv.strokeWeight(2);
            jv.stroke(0);
            jv.noFill();
            jv.sphereDetail(24);
            if (i % 360 == 0) {
                jv.sphere(PApplet.map(r1 * Math.abs(jv.getLerpedBuffer()[i]), 0, 10, r1-5, r1+5));
                // jv.sphere(r1 * r1 * Math.abs(jv.getLerpedBuffer()[i]));
            }
        }
    }

}
