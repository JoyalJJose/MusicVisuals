package C22756115;

public class Hex {
    JoyalsVisual jv;
    float angle;

    Hex (JoyalsVisual jv) {
        this.jv = jv;
    }

    public void render(int size) {
        jv.colorMode(jv.RGB);
        // jv.fill(255, 101, 29); // Semi-transparent blue fill
        jv.noFill();
        // jv.noStroke();
        jv.stroke(255);
        jv.strokeWeight(2);
        
        float centerX = jv.width / 2;
        float centerY = jv.height / 2;
         // Radius of the hexagon based on smoothedAmp
        float radius = jv.map(jv.getSmoothedAmplitude()*1000+size, 0, 50, 1, 150);

        // Calculate rotation angle based on amplitude
        float rotationAngle = jv.map(jv.getSmoothedAmplitude(), 0, 1, 0, jv.TWO_PI);

        jv.pushMatrix(); // Save the current transformation matrix
        jv.translate(centerX, centerY); // Translate to the center of the hexagon
        jv.rotate(rotationAngle); // Rotate based on amplitude
        jv.beginShape();

        for(int i = 0; i < 6; i++) {
            // Angle for each vertex
            angle = jv.TWO_PI / 6 * i;
            float x = jv.cos(angle) * radius;
            float y = jv.sin(angle) * radius;
            jv.vertex(x, y);
        }

        jv.endShape(jv.CLOSE);  // Close the shape to form a hexagon
        jv.popMatrix(); // Restore the original transformation matrix
    }
}
