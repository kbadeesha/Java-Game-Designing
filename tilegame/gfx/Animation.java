/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Adeesha
 */
public class Animation {
    
    private int speed , index;
    private long lastTime,timer=0;
    private BufferedImage[] frames;
    
    public Animation(int speed, BufferedImage[] frames ){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        lastTime = System.currentTimeMillis();
    }
    
    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        if(timer > speed){
            index ++;
            timer = 0;
            if(index >= frames.length)
                index =0;
        }
    }
    
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
    
}
