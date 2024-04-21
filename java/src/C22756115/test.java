package C22756115;

import processing.core.*;

public class test
{
    JoyalsVisual jv;
    float cy = 0;

    public test(JoyalsVisual jv)
    {
        this.jv = jv;
        cy = this.jv.height / 2;
    }

    public void render()
    {
        jv.background(0);
        jv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < jv.getAudioBuffer().size() ; i ++)
        {
            jv.stroke(
                PApplet.map(i, 0, jv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            jv.line(i, cy, i, cy + cy * jv.getAudioBuffer().get(i));
        }
    }
}
