package C22756115;

public class Scene3 {
    JoyalsVisual jv;
    Floor f;
    Hex hex;

    Scene3 (JoyalsVisual jv)
    {
        this.jv = jv;
        f = new Floor(jv);
        hex = new Hex(jv);
    }

    public void render()
    {
        for (int i=1000; i>100; i-=200) {
            hex.render(i);
        }
        f.render();
        // jv.background(0);
        // jv.strokeWeight(2);
        // jv.noFill();
        // // rectMode(CENTER);
        // jv.translate(jv.width/2, jv.height/2, 0);
        // for(int i = 0 ; i < jv.getAudioBuffer().size() ; i+=250)
        // {
        //     float hue = jv.map(i, 0, jv.getAudioBuffer().size() , 0, 256);
        //     jv.stroke(hue, 255, 255);
        //     // lights();
        //     // sphere(250 + i * smoothedAmplitude);
        //     jv.box(100 + i * jv.getSmoothedAmplitude() * 4.0f);
        //     jv.rotate(jv.PI/15);
        // }
    }

}
