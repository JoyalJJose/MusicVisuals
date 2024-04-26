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
        // Get amount of song played in milliseconds
        time = jv.getAudioPlayer().position();
        jv.strokeWeight(3);

        // White line section - played
        jv.stroke(255);
        jv.line(0, 1, time/jv.trackLength * jv.width, 1);

        // Black line - unplayed
        jv.stroke(0);
        jv.line(time/jv.trackLength * jv.width, 1, jv.width, 1);
    }

}
