package ie.tudublin;

import C22756115.*;

public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        // processing.core.PApplet.runSketch(a, new MyVisual());
        processing.core.PApplet.runSketch(a, new JoyalsVisual());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}