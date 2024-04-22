package C22756115;

public class ProgressBar {
    JoyalsVisual jv;
    float time;

    public ProgressBar(JoyalsVisual jv)
    {
        this.jv = jv;
    }

    void render()
    {
        time = jv.getAudioPlayer().position();
        jv.strokeWeight(3);
        jv.stroke(255);
        // jv.line(-jv.width/2, 3 - jv.height/2, time/jv.trackLength * jv.width - jv.width/2, 3 - jv.height/2);
        jv.line(0, 3, time/jv.trackLength * jv.width, 3);
    }

}
