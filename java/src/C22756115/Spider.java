package C22756115;

import processing.core.*;

public class Spider {
    JoyalsVisual jv;
    PShape spider;
    
    public Spider(JoyalsVisual jv)
    {
        this.jv = jv;
        spider = jv.loadShape("java/data/Spider/yf9ivy9n4nb4-spider/spider.obj");
    }   
    
    void render() {
        jv.shape(spider);
    }
}
