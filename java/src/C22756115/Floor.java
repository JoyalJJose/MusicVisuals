package C22756115;

import ie.tudublin.*;

public class Floor extends Visual {
    JoyalsVisual jv;
    int scl = 30;
    int terrainMax = 50;
    int rows = 5000 / scl;
    int cols = 2000 / scl;
    float flying;
    float[][] terrain = new float[cols][rows];
    float halfWidth = width / 2;
    float halfHeight = height / 2;

    public Floor(JoyalsVisual jv) {
        this.jv = jv;
        this.terrain = new float[cols][rows];
    }

    public void createTerrain(float yoff) {
        for (int y = 0; y < cols; y++) {
            float xoff = 0;
            for (int x = 0; x < rows; x++) {
                terrain[y][x] = jv.map(noise(xoff, yoff), 0, 1, -terrainMax - jv.getSmoothedAmplitude(), terrainMax + jv.getSmoothedAmplitude());
                xoff += 0.4f;
            }
            yoff += 0.4f;   
        }
    }

    public void drawTerrain() {
        for (int y = 10; y < cols - 1; y++) {
            jv.beginShape(TRIANGLE_STRIP);
            for (int x = 0; x < rows; x++) {
                jv.vertex(x * 30, y * 30, terrain[y][x]);
                jv.vertex(x * 30, (y + 1) * 30, terrain[y + 1][x]);
            }
            jv.endShape();
        }
    }

    public void render()
    {
        jv.colorMode(RGB);
        jv.pushMatrix();
        jv.translate(halfWidth, halfHeight);

        // Waves
        jv.beginShape();
        flying -= jv.getSmoothedAmplitude()/4;

        // float yoff = flying;
        jv.translate(0, 30, 100);
        createTerrain(flying);
        jv.translate(jv.width / 6 + 200, (jv.height / 2) + 15, -400);
        jv.rotateX(PI / 2);
        jv.translate(-jv.width / 2, -jv.height / 2);
        jv.fill(0);
        jv.stroke(246, 94, 23);
        jv.strokeWeight(1);
        drawTerrain();
        jv.endShape();
        jv.popMatrix();
    }

    public void render(int x)
    {
        jv.colorMode(RGB);
        jv.pushMatrix();
        jv.translate(halfWidth, halfHeight);

        // Waves
        jv.beginShape();
        flying -= jv.getSmoothedAmplitude()/4;

        float yoff = flying;
        jv.translate(0, 300, 50);
        createTerrain(yoff);
        jv.translate(jv.width / 6 + 200, (jv.height / 2) + 15, -400);
        jv.rotateX(PI / 2);
        jv.translate(-jv.width / 2, -jv.height / 2);
        jv.noFill();
        jv.stroke(x);
        jv.strokeWeight(2);
        drawTerrain();
        jv.endShape();
        jv.popMatrix();
    }
}        