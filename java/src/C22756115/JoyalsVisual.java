package C22756115;

public class JoyalsVisual extends ie.tudublin.Visual {
    test t;
    Scene0 s0;

    int scene = 0;

    public void settings()
    {
        size(1024, 1000, P3D);
        // Fullscreen & P3D for 3D graphics
        // fullScreen(P3D, SPAN);
    }

    // Play/pause/rewind & scene selector
    public void keyPressed() {
		if (keyCode == ' ') { // Play/pause
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().play();
            }
        }
        if (key == ENTER) { // Rewind
            getAudioPlayer().rewind();
        }
        if (key >= '0' && key <= '9') { // Scene selection
			scene = key - '0';
		}
	}

    public void setup()
    {
        startMinim();
        // loadAudio("Am I Dreaming of Sunflowers Mashup.mp3");
        loadAudio("Am I Dreaming.mp3");
        getAudioPlayer().play();

        // Instantiate visuals
        t = new test(this);
        s0 = new Scene0(this);
    }

    public void draw()
    {
        calculateLerpedBuffer();

        if (getAudioPlayer().isPlaying())
        {
            // Switch between scenes based on num input
            switch (scene) {
                // Scene 0 - test
                case 0:
                    s0.render();
                    break;
                case 1:
                    t.render();
                    break;
                case 2:
                    background(0);
                    break;
                default:
                    background(0);
                    break;
            }
        }
    }

}