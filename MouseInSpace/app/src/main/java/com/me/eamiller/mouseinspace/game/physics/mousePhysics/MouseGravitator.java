package com.me.eamiller.mouseinspace.game.physics.mousePhysics;

import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.*;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;

/**
 * Created by eamiller on 28.1.2017.
 */
public class MouseGravitator extends MouseImpactor {//this class creates pull and rotates mouse when mouse is in gravitating state


    public MouseGravitator(Mouse m, Planet p){
        super(m, p);
    }

    @Override
    public void impact(){
        createPull();
        rotate();
    }

    private void createPull(){
        double distX = Math.abs(mouse.getCmx()-planet.getCmx());
        double distY = Math.abs(mouse.getCmy()-planet.getCmy());

        double portionX = distX/(distX+distY);
        double portionY = 1-portionX;

        double ddx = planet.getPull()*portionX*GamePanel.xFactor;
        double ddy = planet.getPull()*portionY*GamePanel.yFactor;

        if(mouse.getCmx()>planet.getCmx()) ddx = Math.abs(ddx)*-1;//Laiskuutta
        else ddx = Math.abs(ddx);
        if(mouse.getCmy()>planet.getCmy()) ddy = Math.abs(ddy)*-1;
        else ddy = Math.abs(ddy);

        mouse.ddx(ddx);
        mouse.ddy(ddy);
    }

    public void rotate(){
        double distX = mouse.getCmx()-planet.getCmx();
        double distY = mouse.getCmy()-planet.getCmy();
        double alpha = Math.atan(distY/distX);//assumes that mouse is in the bottom right
        double beta = alpha + Math.PI/2;
        int angle = (int)((360*beta)/(2*Math.PI));
        if(mouse.getCmx()<planet.getCmx())angle+=180;

        if(Math.abs(angle-mouse.getAngle())>10){
            if(Math.abs(mouse.getTorque())<8){
                if(mouse.getDirection()==Direction.LEFT){
                    mouse.setTorque(-20);
                }else{
                    mouse.setTorque(20);
                }
            }
        }else{
            mouse.setTorque(0);
        }
    }

    private int getDesiredAngle(int angle){
        int da = angle-180;
        if(da < 0) da+=360;
        return da;
    }
}
