/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.states;



import dev.codenmore.tilegame.Handler;
import java.awt.Graphics;

/**
 *
 * @author Adeesha
 */
public abstract class State {
    
    
    private static State currentState = null;
    
    public static void setState(State state){
        currentState = state;
        }
    
    public static State getState(){
        return currentState;
    }
    
    //Class
    
    protected Handler handler;
    
    public State(Handler handler)
    {
        this.handler = handler;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
            
    
}
