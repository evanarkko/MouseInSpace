package com.me.eamiller.mouseinspace.game;

import com.me.eamiller.mouseinspace.game.entities.GameEntity;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;

/**
 * Created by eamiller on 27.1.2017.
 */
public class Collider {
    public Collider(){

    }

    public int distance(Mouse mouse, Planet planet){
        double distX = Math.abs(mouse.getCmx()-planet.getCmx());
        double distY = Math.abs(mouse.getCmy()-planet.getCmy());
        return (int)Math.sqrt(Math.pow(distX,2)+Math.pow(distY,2));
    }



    public boolean mouseLands(Mouse m, Planet p){
        if(distance(m, p)-m.getHeight()/3<p.getR()){
            return true;
        }
        return false;
    }

    public boolean collide(GameEntity gc1, GameEntity gc2){
        return collideByWidth(gc1, gc2) & collideByHeight(gc1, gc2);
    }

    private boolean collideByWidth(GameEntity gc1, GameEntity gc2){
        GameEntity onLeft;
        GameEntity onRight;
        if(gc1.getX()<gc2.getX()){
            onLeft = gc1;
            onRight = gc2;
        }else{
            onLeft = gc2;
            onRight = gc1;
        }
        if(onRight.getX()<onLeft.getX()+onLeft.getWidth()){
            return true;
        }
        return false;
    }

    private boolean collideByHeight(GameEntity gc1, GameEntity gc2){
        GameEntity onTop;
        GameEntity onBottom;
        if(gc1.getY()<gc2.getY()){
            onTop = gc1;
            onBottom = gc2;
        }else{
            onTop = gc2;
            onBottom = gc1;
        }
        if(onBottom.getY()<onTop.getY()+onTop.getHeight()){
            return true;
        }
        return false;
    }
}
