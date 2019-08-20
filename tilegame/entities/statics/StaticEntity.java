/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.entities.statics;


import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;

/**
 *
 * @author Adeesha
 */
public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
    
    
    
}
