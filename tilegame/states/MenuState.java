/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.states;



import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.ui.UIImageButton;
import dev.codenmore.tilegame.ui.UIManager;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Adeesha
 */
public class MenuState extends State {
    
    private UIManager uiManager;
    
    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);  
        
        uiManager.addObject(new UIImageButton(230, 200, 128, 64, Assets.ButtonStart, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }
    
    @Override
    public void tick() {
        uiManager.tick();
        
        //temp to go directly to game state
        handler.getMouseManager().setUIManager(null);
        State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
       uiManager.render(g);
    }
    
}
