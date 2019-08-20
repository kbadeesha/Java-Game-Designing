/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

/**
 *
 * @author Adeesha
 */
public class Fence4Tile extends Tile{
    public Fence4Tile(int id) {
        super(Assets.fence4, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
}
