package C22756115;

import processing.core.PApplet;
import processing.core.PImage;

public class Scene3 {
    JoyalsVisual jv;
    Floor f;
    Hex hex;
    PImage s3w;

    Scene3 (JoyalsVisual jv)
    {
        this.jv = jv;
        f = new Floor(jv);
        hex = new Hex(jv);
        s3w = jv.loadImage("scene3.jpg");
    }

    public void render()
    {
        // Background image effect
        float k = PApplet.map(jv.getSmoothedAmplitude(), 0f, 1f, 0.7f, 1.5f);
        jv.image(s3w, jv.width/2, jv.height/3, (float)(1280*2.5*k), (float)(720*2.5*k));

        // Hex rings
        for (int i=350; i>-200; i-=65) {
            hex.render(i);
        }

        // Waveform Floor
        f.render();
    }

}
