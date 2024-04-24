package C22756115;

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
        s3w = jv.loadImage("scene3v2.jpg");
    }

    public void render()
    {
        float k = jv.map(jv.getSmoothedAmplitude(), 0f, 1f, 0.7f, 1.5f);
        // jv.image(jv.logo, jv.width/2, jv.height/2, 108*6*k, 192*6*k);
        jv.image(s3w, jv.width/2, jv.height/3, (float)(1280*2.5*k), (float)(720*2.5*k));
        for (int i=1000; i>0; i-=50) {
            hex.render(i);
        }
        f.render();
    }

}
