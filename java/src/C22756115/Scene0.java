package C22756115;

public class Scene0
{
    JoyalsVisual jv;
    float halfH;

    public Scene0(JoyalsVisual jv)
    {
        this.jv = jv;
        halfH = this.jv.height / 2;
    }

    public void render()
    {
        jv.background(0);
        for(int i = 0 ; i < jv.getAudioBuffer().size() ; i++)
        {
            float hue = jv.map(i, 0, jv.getAudioBuffer().size() , 0, 256);
            jv.stroke(hue, 255, 255);
            jv.line(i, halfH, i, jv.map(halfH - Math.abs(jv.getLerpedBuffer()[i]) * halfH * 5f, halfH, 0f, halfH, (float)(jv.height*0.15)));
        }
    }

}
