package states;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import logic.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author alvar
 */
public class Historia9 extends BasicGameState{
    private Image image;
    private Music fin;
    
    @Override
    public int getID() {
        return 28;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        //image = new Image("resources/historia/fin_4.png");
        fin = new Music("resources/sonidos/fin.ogg");
        fin.loop();
        fin.stop();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {   
        //g.drawImage(image,0, 0);
        g.setBackground(Color.black);
        g.setColor(Color.white);
        g.drawString("FIN", 930, 480);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if(container.getInput().isKeyPressed(Input.KEY_ENTER)){
            
            game.enterState(2);
        }
    }
}
