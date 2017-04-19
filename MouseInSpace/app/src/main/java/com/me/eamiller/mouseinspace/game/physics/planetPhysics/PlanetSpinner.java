package com.me.eamiller.mouseinspace.game.physics.planetPhysics;

import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;

/**
 * Created by eamiller on 19.2.2017.
 */
public class PlanetSpinner extends PlanetMover {

    public PlanetSpinner(Planet p) {
        super(p);
    }

    @Override
    public void move(Planet planet) {
        spin(planet);
    }

    private void spin(Planet p){

    }
}
