package com.me.eamiller.mouseinspace.game.physics.mousePhysics;

import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Direction;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;

/**
 * Created by eamiller on 28.1.2017.
 */
public class MouseRunner extends MouseImpactor {
    public static final double trueOrbitalSpeed = (int) (15*GamePanel.scaleFactor);
    private double orbitalSpeed;

    private boolean flipped = false;

    public MouseRunner(Mouse m, Planet p){
        super(m, p);
    }

    @Override
    public void impact() {
        if(mouse.getDirection()== Direction.LEFT){
            orbitalSpeed = trueOrbitalSpeed - (planet.getTorque()*2);
            makeRunCounterClockWise();
        }else{
            orbitalSpeed = trueOrbitalSpeed +(planet.getTorque()*2);
            makeRunClockwise();
        }
    }

    public void makeRunClockwise(){//a1,b1 = startPos, a2,b2 = endPos
        int r = planet.getR()+mouse.getHeight()/3;
        System.out.println();

        int a1 = (int)(mouse.getCmx()-planet.getCmx());
        int b1 = (int)(mouse.getCmy()-planet.getCmy());

        if(b1<0){
            flipped = true;
        }else{
            flipped = false;
        }


        double startPositionAngle = Math.atan((double)a1/(double)b1);
        if(flipped){
            startPositionAngle+=Math.PI;
        }

        double orbitalAngle = -1* orbitalSpeed /planet.getR();
        double endPositionAngle = startPositionAngle + orbitalAngle;


        int a2 = (int)(r * Math.sin(endPositionAngle));
        int b2 = (int)(r * Math.cos(endPositionAngle));


        int dx = a2-a1;
        int dy = b2-b1;

        mouse.setDx(dx);
        mouse.setDy(dy);
        mouse.setAngle(-((int)((360*endPositionAngle)/(2*Math.PI))+180));
    }
    public void makeRunCounterClockWise(){//a1,b1 = startPos, a2,b2 = endPos
        int r = planet.getR()+mouse.getHeight()/3;

        int a1 = (int)(mouse.getCmx()-planet.getCmx());
        int b1 = (int)(mouse.getCmy()-planet.getCmy());

        if(b1<0){
            flipped = true;
        }else{
            flipped = false;
        }


        double startPositionAngle = Math.atan((double)a1/(double)b1);
        if(flipped){
            startPositionAngle+=Math.PI;
        }

        double orbitalAngle = orbitalSpeed /planet.getR();
        double endPositionAngle = startPositionAngle + orbitalAngle;


        int a2 = (int)(r * Math.sin(endPositionAngle));
        int b2 = (int)(r * Math.cos(endPositionAngle));


        int dx = a2-a1;
        int dy = b2-b1;

        mouse.setDx(dx);
        mouse.setDy(dy);
        mouse.setAngle(-((int)((360*endPositionAngle)/(2*Math.PI))));
    }

}
