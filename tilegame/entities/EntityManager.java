/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.entities;


import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Adeesha
 */
public class EntityManager {
    
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entites;
    private Comparator<Entity> renderSorter = new Comparator<Entity>(){
        @Override
        public int compare(Entity a, Entity b) { 
            if(a.getY() + a.getHeight() < b.getY()+ b.getHeight())
            return -1;
        return 1;    
            
            
        }
    };
    
        

    public EntityManager(Handler handler, Player player) {
       
        this.handler = handler;
        this.player = player;
        entites = new ArrayList<Entity>();
        addEntity(player);
        
        
    }
    
    public void tick(){
        for(int i=0; i< entites.size();i++){
            Entity e = entites.get(i);
            e.tick();
        }
        entites.sort(renderSorter);
    }
    public void render(Graphics g){
        for(Entity e : entites){
            e.render(g);
        }
        
    }

    public void addEntity(Entity e){
        entites.add(e);
    }
    
    //Getters and Setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntites() {
        return entites;
    }

    public void setEntites(ArrayList<Entity> entites) {
        this.entites = entites;
    }
    
    
}
