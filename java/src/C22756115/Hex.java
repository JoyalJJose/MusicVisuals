package C22756115;

public class Hex {
    JoyalsVisual jv;
    float angle;

    Hex (JoyalsVisual jv) {
        this.jv = jv;
    }

    public void render(int size) {
        jv.colorMode(jv.RGB);
        jv.stroke(239, 0, 107);
        jv.strokeWeight(7);
        
        float centerX = jv.width / 2;
        float centerY = jv.height / 2;
         // Radius of the hexagon based on smoothedAmp
        float radius = jv.map(jv.getSmoothedAmplitude()*1000+size, 0, 50, 1, 150);

        // Calculate rotation angle based on amplitude
        float rotationAngle = jv.map(jv.getSmoothedAmplitude(), 0, 1, 0, jv.TWO_PI);

        jv.pushMatrix();
        jv.translate(centerX, centerY);
        // Rotate based on amplitude
        jv.rotate(rotationAngle);
        jv.beginShape();

        // jv.fill(255, 101, 29);
        for(int i = 0; i < 6; i++) {
            // Angle for each vertex
            angle = jv.TWO_PI / 6 * i;
            float x = jv.cos(angle) * radius;
            float y = jv.sin(angle) * radius;
            jv.vertex(x, y);
        }

        jv.noFill();
        jv.stroke(23, 2, 217);
        for(int i = 0; i < 6; i++) {
            angle = jv.TWO_PI / 6 * i;
            float x = jv.cos(angle) * radius+35;
            float y = jv.sin(angle) * radius+35;
            jv.vertex(x, y);
        }

        jv.endShape(jv.CLOSE);
        jv.popMatrix();
    }
}
