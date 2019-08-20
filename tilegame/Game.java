/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

   
    
    private Thread thread;
    private Display display;

    private BufferStrategy bs;
    private Graphics g;
    
    //States 
    //private State gameState;
    //private State menuState;
    public State gameState;
    public State menuState;
    
    //Inputs
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    
    private GameCamera gameCamera;
    
    //handler
    private Handler handler;
    
    private int width, height;
    public String title;
    private boolean running = false;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager(); 
        mouseManager = new MouseManager();

    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        handler  = new Handler(this);
        gameCamera = new GameCamera(handler,0, 0);
        
        
        //States
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);
        
        
    }

    private void tick() {
        keyManager.tick();
        
        if(State.getState() != null)
            State.getState().tick();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear screen
        g.clearRect(0, 0, width, height);
        //Draw here
        if(State.getState() != null)
            State.getState().render(g);
        
        
               
        //End Draw
        bs.show();
        g.dispose();
    }

    public void run() {

        init();
        
        int fps = 60;
        double timePerTick = 1000000000/ fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer =0;
        long ticks =0;
        

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1){
            tick();
            render();
            ticks++;
            delta--;
            }
            if(timer >= 1000000000)
            {
                System.out.println("Ticks and Frames:" +ticks);
                ticks=0;
                timer =0;
            }
        }
        stop();
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }
    
    
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
    
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
