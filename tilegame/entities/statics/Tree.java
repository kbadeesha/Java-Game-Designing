/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.entities.statics;


import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;
import java.awt.Graphics;

/**
 *
 * @author Adeesha
 */
public class Tree extends StaticEntity{

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
        bounds.x = 10;
        bounds.y = (int)(height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int)(height - height/1.5);
     }
    
    @Override
    public void tick(){
        
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.tree0,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), null);
    }
}
