package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import C22756115.JoyalsVisual;

public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new MyVisual());
        // processing.core.PApplet.runSketch(a, new JoyalsVisual());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}