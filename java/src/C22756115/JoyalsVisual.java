package C22756115;

public class JoyalsVisual extends ie.tudublin.Visual {

    test t;

    public void settings()
    {
        size(1024, 1000, P3D);
        // fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        startMinim();
        // loadAudio("Am I Dreaming of Sunflowers Mashup.mp3");
        loadAudio("Am I Dreaming.mp3");
        playAudio();

        t = new test(this);
    }

    public void draw()
    {
        background(0);
        t.render();
    }

}