package com.me.eamiller.mouseinspace.game.physics.mousePhysics;

import com.me.eamiller.mouseinspace.game.Collider;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.State;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;

/**
 * Created by eamiller on 30.1.2017.
 */
public class MousePhysic extends MouseImpactor {
    private MouseGravitator mg;
    private MouseRunner mr;
    private Collider c;
    public MousePhysic(Mouse m, Planet p) {
        super(m, p);
        this.mg=new MouseGravitator(m, p);
        this.mr=new MouseRunner(m, p);
        c = new Collider();
    }

    @Override
    public void impact() {
        if(mouse.getState()== State.GRAVITATING){
            if(c.mouseLands(mouse, planet)){
                //mouse.changeDirection();
                mouse.stop();
                mouse.setState(State.RUNNING);
                mouse.getInteractingPlanet().setMice(mouse.getInteractingPlanet().getMice()+1);
            }else{
                mg.impact();
            }
        }else{
            mr.impact();
        }
    }
}
