package C22756115;

import processing.core.*;

public class Scene0
{
    JoyalsVisual jv;
    float halfH;
    Rain rain;
    PImage logo;

    public Scene0(JoyalsVisual jv)
    {
        this.jv = jv;
        halfH = this.jv.height / 2;
        rain = new Rain(jv);
        logo = jv.loadImage("logo.png");
    }

    public void render()
    {
        // jv.image(jv.s1w, jv.width/2, jv.height/2);

        // Top horizontal EQ
        jv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < jv.getAudioBuffer().size() ; i++)
        {
            // Blue: 225-245 , Red: 330-10
            float hue = PApplet.map(i, 0, jv.getAudioBuffer().size() , 330, 10) % 360;
            jv.stroke(hue, 255, 255);
            // jv.line(i, 0, i, jv.map(halfH - Math.abs(jv.getLerpedBuffer()[i]) * halfH * 5f, halfH, 0f, halfH, (float)(jv.height*0.15)));
            jv.line(i, 3, i, 3 + Math.abs(jv.getLerpedBuffer()[i]) * halfH * 5f);
        }
        
        // Spiderman logo EQ
        float k = PApplet.map(jv.getSmoothedAmplitude(), 0f, 1f, 0.7f, 1.5f);
        jv.image(logo, jv.width/2, jv.height/2, 108*6*k, 192*6*k);
        
        // Rain animation
        rain.render();
    }

}
