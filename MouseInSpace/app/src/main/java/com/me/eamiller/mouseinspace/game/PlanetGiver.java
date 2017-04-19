package com.me.eamiller.mouseinspace.game;
import android.content.Context;

import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.*;
/**
 * Created by eamiller on 27.1.2017.
 */
public class PlanetGiver {
    public static final Planet planet1(Context c){
        return new Planet(c);
    }
    public static final Planet planet1(Context c, int x, int y){
        return new Planet(c, x, y);
    }
    public static final Mouse mouse1(Context c){
        return new Mouse(c);
    }
}
