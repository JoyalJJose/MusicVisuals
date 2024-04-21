package C22756115;

public class JoyalsVisual extends ie.tudublin.Visual {
    test t;
    Scene0 s0;
    Scene1 s1;
    Spider sp;

    int scene = 0;
    int count = 0;

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
        if (key == ENTER) { // Change song
            count = ++count % 2;
            getAudioPlayer().close();
            switch (count) {
                case 0:
                    loadAudio("Am I Dreaming.mp3");
                    break;
                case 1:
                    loadAudio("Spot Holes 2.mp3");
                    break;
            } getAudioPlayer().play();
        }
        if (key == BACKSPACE) { // Rewind
            getAudioPlayer().rewind();
        }
        if (key >= '0' && key <= '9') { // Scene selection
			scene = key - '0';
		}
	}

    public void setup()
    {
        startMinim();
        loadAudio("Am I Dreaming.mp3");
        getAudioPlayer().play();

        // Instantiate visuals
        t = new test(this);
        s0 = new Scene0(this);
        s1 = new Scene1(this);
        // sp = new Spider(this);
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
                    s1.render();
                    // sp.render();
                    break;
                case 2:
                    t.render();
                    break;
                default:
                    background(0);
                    break;
            }
        }
    }

}