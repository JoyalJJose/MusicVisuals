package C22756115;

import processing.core.*;

public class Spider {
    JoyalsVisual jv;
    PShape spider;
    PImage texture;
    
    public Spider(JoyalsVisual jv)
    {
        this.jv = jv;
        texture = jv.loadImage("/Spider/index.jpg");
        spider = jv.loadShape("/Spider/spider.obj");
        spider.setTexture(texture);
    }   
    
    void render() {
        jv.translate(jv.width/2, jv.height/2, 0);
        jv.scale(200);
        jv.rotateX(PConstants.PI/4);
        jv.rotateY(PConstants.PI);
        jv.shape(spider);
    }
}
