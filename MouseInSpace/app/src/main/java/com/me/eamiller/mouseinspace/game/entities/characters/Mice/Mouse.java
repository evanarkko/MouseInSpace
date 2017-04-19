package com.me.eamiller.mouseinspace.game.entities.characters.Mice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.drawing.Animator;
import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.entities.GameEntity;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;
import com.me.eamiller.mouseinspace.game.physics.mousePhysics.MouseImpactor;
import com.me.eamiller.mouseinspace.game.physics.mousePhysics.MousePhysic;

import java.util.ArrayList;

/**
 * Created by eamiller on 27.1.2017.
 */
public class Mouse extends GameEntity {
    private State state = State.GRAVITATING;
    public static Direction mouseDirection = Direction.LEFT;
    private Animator mouseAnimator;
    private Planet interactingPlanet;
    private int jumpForce = 15;
    private MouseImpactor mouseImpactor;

    public Mouse(Context c) {
        super(c);
        x = (int)(100*GamePanel.xFactor); y = (int)(1200*GamePanel.yFactor);
        width = (int)(70 * GamePanel.xFactor); height = (int)(40*GamePanel.yFactor);
        configureCenterOfMass();
        createAnimator();

    }

    public Mouse(Context c, int x, int y){
        this(c);
        this.x = (int)(x*GamePanel.xFactor);
        this.y = (int)(y*GamePanel.yFactor);
        configureCenterOfMass();
        createAnimator();
    }



    public void jump(){
        this.dx*=0.7;
        this.dy*=0.7;

        double distX = Math.abs(this.getCmx()- interactingPlanet.getCmx());
        double distY = Math.abs(this.getCmy()- interactingPlanet.getCmy());

        double ddx = jumpForce*(distX/(distX+distY))*GamePanel.xFactor;
        double ddy = jumpForce*(1-ddx/jumpForce)*GamePanel.yFactor;


        int a = (int)(this.getCmx()- interactingPlanet.getCmx());
        int b = (int)(this.getCmy()- interactingPlanet.getCmy());

        if(a<0){
            ddx *= -1;
        }
        if(b<0) ddy *= -1;

        //moveMouseAwayFromPlanetSoItCanJump(distX, distY, a, b);
        this.dx((int)ddx);
        this.dy((int)ddy);
        this.ddx(ddx);
        this.ddy(ddy);
        this.setState(State.GRAVITATING);
        interactingPlanet.setMice(interactingPlanet.getMice()-1);
    }

    private void moveMouseAwayFromPlanetSoItCanJump(double distX, double distY, int a, int b){
        int totalMoveDist = (int)(25*GamePanel.scaleFactor);
        double dx = totalMoveDist*(distX/(distX+distY));
        double dy = totalMoveDist*(1-dx/totalMoveDist);
        if(a<0){
            dx *= -1;
        }
        if(b<0) dy *= -1;

        this.dx((int)dx);
        this.dy((int)dy);
    }

    @Override
    public void draw(Canvas canvas) {
        int shittyCodeRepairInteger = 5;
        if(mouseDirection == mouseDirection.LEFT && this.getState() == State.RUNNING) shittyCodeRepairInteger+=200;
        canvas.save();
        canvas.rotate(angle + shittyCodeRepairInteger, cmx, cmy);
        canvas.drawBitmap(mouseAnimator.getImage(), x, y, null);
        canvas.restore();
    }

    public void setMouseImpactorPlanet(Planet p) {
        this.mouseImpactor = new MousePhysic(this, p);
    }

    public void setMouseImpactor(MouseImpactor mouseImpactor) {
        this.mouseImpactor = mouseImpactor;
    }

    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }


    @Override
    public void update() {
        setMouseImpactorPlanet(interactingPlanet);
        mouseImpactor.impact();
        mouseAnimator.update();
        super.update();
    }

    public Direction getDirection() {
        return mouseDirection;
    }

    public void setInteractingPlanet(Planet interactingPlanet) {
        this.interactingPlanet = interactingPlanet;
    }

    public Planet getInteractingPlanet() {
        return interactingPlanet;
    }

    public void createAnimator(){
        this.mouseAnimator = new Animator();
        ArrayList<Bitmap> frames = new ArrayList<>();
        if(this.mouseDirection == mouseDirection.RIGHT){
            frames.add(Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(context.getResources(), R.drawable.mouse_right2_anim3), width, height, true));
            frames.add(Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(context.getResources(), R.drawable.mouse_right2_anim4), width, height, true));
        }else{
            frames.add(Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(context.getResources(), R.drawable.mouse_left_anim4), width, height, true));
            frames.add(Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(context.getResources(), R.drawable.mouse_left_anim3), width, height, true));
        }
        mouseAnimator.setFrames(frames);
    }
}
