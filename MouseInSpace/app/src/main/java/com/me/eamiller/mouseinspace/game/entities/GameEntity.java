package com.me.eamiller.mouseinspace.game.entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.interfaces.*;

/**
 * Created by eamiller on 26.1.2017.
 */
public class GameEntity implements updateable, drawable {
    protected Context context;
    protected Bitmap image;
    protected int x, y, cmx, cmy; //top left corner AND center of mass coordinates
    protected double dx, dy;
    protected int width, height;
    protected int angle;
    protected int torque;


    public GameEntity(Context c){
        this.context = c;
        configureCenterOfMass();
    }

    public GameEntity(Context c, int x, int y){
        this(c);
        this.x = (int)(x*GamePanel.xFactor);
        this.y = (int)(y*GamePanel.yFactor);
        configureCenterOfMass();
    }

    protected void configureCenterOfMass(){
        this.cmx = x + width/2;
        this.cmy = y + height/2;
    }


    protected void setImage(Bitmap b){
        this.image = b;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(angle, cmx, cmy);
        canvas.drawBitmap(image, (int)x, (int)y, null);
        canvas.restore();
    }


    @Override
    public void update() {
        x += dx;
        y += dy;
        cmx += dx;
        cmy += dy;
        updateAngle();
    }

    private void updateAngle(){
        angle += torque;
        if(angle>360){
            angle = angle - 360;
        }
    }

    public void ddx(double ddx){
        this.dx+=ddx;
    }
    public void ddy(double ddy){
        this.dy+=ddy;
    }
    public void dx(int dx){
        this.x+=dx;
        this.cmx+=dx;
    }
    public void dy(int dy){
        this.y+=dy;
        this.cmy+=dy;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getTorque() {
        return torque;
    }

    public double getTorqueInRadians(){
        return (torque/360)*2*Math.PI;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getCmx() {
        return cmx;
    }

    public double getCmy() {
        return cmy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }






    public void setCoordinates(int x, int y){
        this.x = x;
        this.y= y;
        configureCenterOfMass();
    }

    public void rotate(int angle){
        this.angle+=angle;
        if(this.angle>360){
            this.angle-=360;
        }else if(this.angle<0){
            this.angle+=360;
        }
    }

    public void stop(){
        if (this.dx != 0 || this.dy!=0) {
            this.dx=0;
            this.dy=0;
        }
    }

    public boolean isInMotion(){
        return !(this.dx == 0 && this.dy == 0);
    }


}
