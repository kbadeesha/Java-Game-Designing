/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.entities;


import dev.codenmore.tilegame.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Adeesha
 */
public abstract class Entity {
    
    protected Handler handler; 
    protected float x,y;
    protected int width , height;
    protected Rectangle bounds;
    

    public Entity(Handler handler, float x, float y,int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        
        bounds = new Rectangle(0, 0, width, height);
        
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x+bounds.x + xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
    }

    public float getX() {
        return x;
    }
    
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e: handler.getWorld().getEntityManager().getEntites()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
            
                return true;
        }
        return false;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
}
