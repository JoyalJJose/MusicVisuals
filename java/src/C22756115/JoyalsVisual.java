package C22756115;

public class JoyalsVisual extends ie.tudublin.Visual {

    test t;
    int scene = 0;

    // Play/pause/rewind & scene selector
    public void keyPressed() {
		if (keyCode == ' ') {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().play();
            }
        }
        if (key == ENTER) {
            getAudioPlayer().rewind();
        }
        if (key >= '0' && key <= '9') {
			scene = key - '0';
		}
	}

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

        // Instanciate visuals
        t = new test(this);
    }

    public void draw()
    {
        if (getAudioPlayer().isPlaying())
        {
            // Switch between scenes based on num input
            switch (scene) {
                // Scene 0 - test
                case 0:
                    background(0);
                    t.render();
                    break;
                case 1:

                    break;
                case 2:

                    break;
            }
        }
    }

}