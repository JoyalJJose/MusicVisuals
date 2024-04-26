package C22756115;

import processing.core.PApplet;
import processing.core.PConstants;

public class Hex {
    JoyalsVisual jv;
    float angle;

    Hex (JoyalsVisual jv) {
        this.jv = jv;
    }

    public void render(int size) {
        jv.colorMode(PConstants.RGB);
        
        float centerX = jv.width / 2;
        float centerY = jv.height / 2;

         // Radius of the hexagon based on smoothedAmp
        float radius = PApplet.map(jv.getSmoothedAmplitude()*1000+size, 0, 50, 1, 150);

        // Calculate rotation angle based on amplitude
        float rotationAngle = PApplet.map(jv.getSmoothedAmplitude(), 0, 1, 0, PConstants.TWO_PI);

        jv.pushMatrix();
        jv.translate(centerX, centerY);
        // Rotate based on amplitude
        jv.rotate(rotationAngle);
        jv.beginShape();

        jv.noFill();
        jv.strokeWeight(7);

        // Drawing hex rings
        // Orange rings
        jv.stroke(239, 0, 107);
        for(int i = 0; i < 6; i++) {
            // Angle for each vertex
            angle = PConstants.TWO_PI / 6 * i;
            float x = PApplet.cos(angle) * radius;
            float y = PApplet.sin(angle) * radius;
            jv.vertex(x, y);
        }

        // Blue rings
        jv.stroke(23, 2, 217);
        for(int i = 0; i < 6; i++) {
            angle = PConstants.TWO_PI / 6 * i;
            float x = PApplet.cos(angle) * radius+35;
            float y = PApplet.sin(angle) * radius+35;
            jv.vertex(x, y);
        }

        jv.endShape(PConstants.CLOSE);
        jv.popMatrix();


        // Comic book style motion rays
        jv.pushMatrix();
        jv.translate(centerX, centerY);

        for (int i=0; i<360; i+=5) {
            jv.strokeWeight(jv.random(1, 3));
            jv.stroke(115, 36, 164);

            float startR = jv.random(100, jv.width/2);
            float endR = startR+jv.random(15, 200);

            float x1 = startR * PApplet.cos(i);
            float y1 = startR * PApplet.sin(i);
            float x2 = endR * PApplet.cos(i);
            float y2 = endR * PApplet.sin(i);

            jv.line(x1, y1, x2, y2);
        }
        jv.popMatrix();
    }
}
