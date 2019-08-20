/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
    
    //STATIC STUFF HERE
    
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile sandTile = new SandTile(1);
    public static Tile stoneWallTile = new StoneWallTile(2);
    public static Tile tallGrass0Tile = new TallGrass0Tile(3);
    public static Tile tallGrass1Tile = new TallGrass1Tile(4);
    public static Tile tallGrass2Tile = new TallGrass2Tile(5);
    public static Tile tallGrass3Tile = new TallGrass3Tile(6);
    public static Tile tallGrass4Tile = new TallGrass4Tile(7);
    public static Tile tallGrass5Tile = new TallGrass5Tile(8);
    public static Tile fence0Tile = new Fence0Tile(9);
    public static Tile fence1Tile = new Fence1Tile(10);
    public static Tile fence2Tile = new Fence2Tile(11);
    public static Tile fence3Tile = new Fence3Tile(12);
    public static Tile fence4Tile = new Fence4Tile(13);
    public static Tile fence5Tile = new Fence5Tile(14);
    
    
    //CLASS
    
    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
    
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }
    
    
    
    public void tick(){
        
    }
    
    public void render(Graphics g, int x,int y){
        g.drawImage(texture, x, y, TILEWIDTH,TILEHEIGHT,null);
    }
    
    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }
    
    
}
