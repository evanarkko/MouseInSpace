package com.me.eamiller.mouseinspace.game.physics.mousePhysics;

import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;

/**
 * Created by eamiller on 30.1.2017.
 */
public class MouseImpactor {
    protected Mouse mouse;
    protected Planet planet;

    public MouseImpactor(Mouse m, Planet p){
        this.mouse = m;
        this.planet = p;
    }

    public void impact(){

    }
}
