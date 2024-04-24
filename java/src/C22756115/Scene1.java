package C22756115;

import processing.core.*;

public class Scene1 {
    JoyalsVisual jv;
    float halfH;
    Floor f;

    public Scene1(JoyalsVisual jv)
    {
        this.jv = jv;
        halfH = this.jv.height / 2;
        f = new Floor(jv);
    }

    public void render()
    {
        // jv.blendMode(1);
        jv.image(jv.sDim, jv.width/2, jv.height/2, 1920, 1080);
        f.render(0);
        jv.spots.createSpots(200);


        jv.translate(jv.width/2, jv.height/2, 0);
        float r1 = 200;
        float r2;
        float angle = 0;
        float inc = jv.TWO_PI / 360;

        for (int i = 0; i < 360; i++) {
            r2 = r1 + (Math.abs(jv.getLerpedBuffer()[i]) * halfH * 5f);

            float x1 = r1 * jv.cos(angle);
            float y1 = r1 * jv.sin(angle);
            float x2 = r2 * jv.cos(angle);
            float y2 = r2 * jv.sin(angle);
            angle = angle + inc;
            
            jv.strokeWeight(2);
            jv.stroke(0);
            jv.line(x1, y1, x2, y2);

            jv.strokeWeight(2);
            jv.stroke(0);
            jv.noFill();
            jv.sphereDetail(24);
            if (i % 360 == 0) {
                jv.sphere(jv.map(r1 * Math.abs(jv.getLerpedBuffer()[i]), 0, 10, r1-5, r1+5));
                // jv.sphere(r1 * r1 * Math.abs(jv.getLerpedBuffer()[i]));
            }
        }
    }

}
