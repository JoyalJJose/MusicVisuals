package C22756115;

import processing.core.PApplet;
import processing.core.PImage;

public class JoyalsVisual extends ie.tudublin.Visual {
    PImage spot;
    PImage logo;
    PImage sDim;
    PImage s2w;
    PImage splash;
    PImage splash2;
    
    Scene0 s0;
    Scene1 s1;
    Spider sp;
    ProgressBar pb;
    Rain rain;
    Spot spots;
    Scene2 s2;
    Scene3 s3;

    int trackLength;

    int scene = 0;
    int count = 0;

    boolean splashing;

    public void settings()
    {
        // size(1024, 1000, P3D);
        // Fullscreen & P3D for 3D graphics
        fullScreen(P3D, SPAN); //everything works in fullscreen :)
    }

    // Media controls & scene selector
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
            trackLength = getAudioPlayer().length();
        }
        if (key == BACKSPACE) { // Rewind
            getAudioPlayer().rewind();
        }
        if (keyCode == LEFT) { // Seek backwards 5s
            if (getAudioPlayer().position() - 5000 < 0) {
                getAudioPlayer().cue(0);
            } else {
                getAudioPlayer().cue(getAudioPlayer().position() - 5000);
            }
        }
        if (keyCode == RIGHT) { // Seek forwards 5s
            if (getAudioPlayer().position() + 5000 > trackLength) {
                getAudioPlayer().cue(trackLength - 750);
            } else {
                getAudioPlayer().cue(getAudioPlayer().position() + 5000);
            }
        }
        if (key >= '0' && key <= '9') { // Scene selection
			scene = key - '0';
            scene = scene % 4;
		}
	}

    public void setup()
    {
        startMinim();
        loadAudio("Am I Dreaming.mp3");
        getAudioPlayer().play();
        // Get length of loaded file in milliseconds
        trackLength = getAudioPlayer().length();

        // Instantiate visuals
        // t = new test(this);
        pb = new ProgressBar(this);
        s0 = new Scene0(this);
        s1 = new Scene1(this);
        sp = new Spider(this);
        rain = new Rain(this);
        spots = new Spot(this);
        spot = loadImage("spot.png");
        logo = loadImage("logo.png");
        sDim = loadImage("spottedDimension.png");
        s2w = loadImage("scene2.jpeg");
        splash = loadImage("splash.png");
        splash2 = loadImage("splash2.png");
        imageMode(CENTER);
        s2 = new Scene2(this);
        s3 = new Scene3(this);
    }

    public void draw()
    {
        // Lerp AudioBuffer values into lerpedBuffer[]
        calculateLerpedBuffer();
        // Average amplitude calculation
        calculateAverageAmplitude();

        if (getAudioPlayer().isPlaying())
        {
            setBackgroundColour(0);
            pb.render();
            // Switch between scenes based on num input
            switch (scene) {
                // Scene 0 - Logo & Rain
                case 0:
                    s0.render();
                    break;
                // Scene 1 - Spot images
                case 1:
                    s1.render();
                    break;
                // Scene 2 - Boids simulation
                case 2:
                    s2.render();
                    break;
                // Scene 3 - Floor & hex
                case 3:
                    s3.render();
                default:
                    break;
            }
        }
    }

}