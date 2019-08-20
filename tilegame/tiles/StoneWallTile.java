/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

/**
 *
 * @author Adeesha
 */
public class StoneWallTile extends Tile{
    
    public StoneWallTile(int id) {
        super(Assets.stone_wall, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
    
}
