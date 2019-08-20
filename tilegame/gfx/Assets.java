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
public class Assets {
    
    
    
    
    private static final int width =32, height = 32;
    
    public static BufferedImage playerFb,grass0,tallGrass0,tallGrass1,tallGrass2,tallGrass3,tallGrass4,tallGrass5,sand,sand1,sand_patch,sand0,stone_wall,
                                tree0,bush0,fence0,fence1,fence2,fence3,fence4,fence5,stonePatch0,stonePatch1,stonePatch2,stonePatch3,stonePatch4,stonePatch5,flowerPatch0,flowerPatch1,flowerPatch2,flowerPatch3,flowerPatch4,flowerPatch5,cliffTile0,cliffTile1,cliffTile2,cliffTile3,cliffTile4,cliffTile5;
    public static BufferedImage[] player_down,player_up,player_right,player_left;
    public static BufferedImage[] ButtonStart;
    
    public static void init(){
        
        SpriteSheet startSheet = new SpriteSheet(ImageLoader.loadImage("/textures/play.jpg"));
        ButtonStart = new BufferedImage[2];
        ButtonStart[0] = startSheet.crop(0, 0, 357, 116);
        ButtonStart[1] = startSheet.crop(0, 119, 357, 116);
        
        SpriteSheet actorSheet = new SpriteSheet(ImageLoader.loadImage("/textures/actor110.png"));
        player_down = new BufferedImage[3];
        player_up = new BufferedImage[3];
        player_left = new BufferedImage[3];
        player_right = new BufferedImage[3];
        
        playerFb = actorSheet.crop(width, 0,width, height);
   
        //player Front - Facing down
        player_down [0] = actorSheet.crop(0, 0, width, height);
        player_down [1] = actorSheet.crop(width, 0,width, height);
        player_down [2] = actorSheet.crop(2*width, 0,width, height);
        
        //Player Left - Facing Left
        player_left[0] = actorSheet.crop(0, height, width, height);
        player_left[1] = actorSheet.crop(width, height, width, height);
        player_left[2] = actorSheet.crop(2*width, height, width, height);
        
        //player right - Facing Right
        player_right[0] = actorSheet.crop(0, 2*height, width, height);
        player_right[1] = actorSheet.crop(width, 2*height, width, height);
        player_right[2] = actorSheet.crop(2*width, 2*height, width, height);
        
        //player up - Facing Up
        player_up[0] = actorSheet.crop(0, 3*height, width, height);
        player_up[1] = actorSheet.crop(width, 3*height, width, height);
        player_up[2] = actorSheet.crop(2*width, 3*height, width, height);
        
        SpriteSheet tileSheet  = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheet.png"));
        //15 
        grass0 = tileSheet.crop(0, 0, width, height);//done
        
        tallGrass0 = tileSheet.crop(2*width, 3*height, width, height);//done
        tallGrass1 = tileSheet.crop(3*width, 3*height, width, height);//done
        tallGrass2 = tileSheet.crop(2*width, 4*height, width, height);//done
        tallGrass3 = tileSheet.crop(3*width, 4*height, width, height);//done
        tallGrass4 = tileSheet.crop(2*width, 5*height, width, height);//done
        tallGrass5 = tileSheet.crop(3*width, 5*height, width, height);//done
        
        sand1 = tileSheet.crop(7*width, 0, width, height);
        sand0 = tileSheet.crop(204, 43, width, height);//done
        sand_patch = tileSheet.crop(6*width, 0, width, height);
        stone_wall = tileSheet.crop(6*width, 3*height, width, height); //done
        
        fence0 = tileSheet.crop(2*width,0, width, height);
        fence1 = tileSheet.crop(3*width,0, width, height);
        fence2 = tileSheet.crop(2*width,height, width, height);
        fence3 = tileSheet.crop(3*width,height, width, height);
        fence4 = tileSheet.crop(2*width,2*height, width, height);
        fence5 = tileSheet.crop(3*width,2*height, width, height);
        
        
        stonePatch0 = tileSheet.crop(4*width,0, width, height);
        stonePatch1 = tileSheet.crop(5*width,0, width, height);
        stonePatch2 = tileSheet.crop(4*width,height, width, height);
        stonePatch3 = tileSheet.crop(5*width,height, width, height);
        stonePatch4 = tileSheet.crop(4*width,2*height, width, height);
        stonePatch5 = tileSheet.crop(5*width,2*height, width, height);
        
        //file patch tiles
        flowerPatch0 = tileSheet.crop(0,3*height, width, height);
        flowerPatch1 = tileSheet.crop(width,3*height, width, height);
        flowerPatch2 = tileSheet.crop(0,4*height, width, height);
        flowerPatch3 = tileSheet.crop(width,4*height, width, height);
        flowerPatch4 = tileSheet.crop(0,5*height, width, height);
        flowerPatch5 = tileSheet.crop(width,5*height, width, height);
        
        //elevation cliff tiles
        cliffTile0 = tileSheet.crop(2*width,6*height, width, height);
        cliffTile1 = tileSheet.crop(3*width,6*height, width, height);
        cliffTile2 = tileSheet.crop(2*width,7*height, width, height);
        cliffTile3 = tileSheet.crop(3*width,7*height, width, height);
        cliffTile4 = tileSheet.crop(2*width,8*height, width, height);
        cliffTile5 = tileSheet.crop(3*width,8*height, width, height);
        
        
        SpriteSheet RPGMapItem = new SpriteSheet(ImageLoader.loadImage("/textures/RPGMapItem.png"));
        tree0 = RPGMapItem.crop(15*width, height, width, 2*height);
        bush0 = RPGMapItem.crop(9*width, height, width, height);
        
        
        
        
        
        
        
        
        
    }
}
