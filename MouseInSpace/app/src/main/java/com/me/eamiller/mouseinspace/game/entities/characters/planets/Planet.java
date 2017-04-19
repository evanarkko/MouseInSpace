package com.me.eamiller.mouseinspace.game.entities.characters.planets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.entities.GameEntity;

/**
 * Created by eamiller on 26.1.2017.
 */
public class Planet extends GameEntity {
    private boolean circular = true;
    private int r;
    private double pull = 1;

    private int mice;
    private int miceRequired=2;
    private boolean satisfied = false;


    public Planet(Context c) {
        super(c);
        width = (int)(300*GamePanel.scaleFactor); height = (int)(300*GamePanel.scaleFactor);
        if(circular)r = width/2;
        configureCenterOfMass();
        System.out.println("PlanetCM: x:"+this.cmx + " y:"+this.cmy);
        this.image = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.planet1), width, height, true);
        satisfied = true;
    }

    public Planet(Context c, int x, int y){
        super(c, x, y);
        width = (int)(300*GamePanel.scaleFactor); height = (int)(300*GamePanel.scaleFactor);
        if(circular)r = width/2;
        configureCenterOfMass();
        this.image = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.planet1), width, height, true);
        satisfied = true;
    }

    public Planet(Context c, int x, int y, int miceNeeded){
        super(c, x, y);
        width = (int)(300*GamePanel.scaleFactor); height = (int)(300*GamePanel.scaleFactor);
        if(circular)r = width/2;
        configureCenterOfMass();
        this.image = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.planet1), width, height, true);
        miceRequired = miceNeeded;
    }





    public void setR(int r) {
        this.r = r;
        this.width = r*2;
        this.height = r*2;
        configureCenterOfMass();
        this.image = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.planet1), width, height, true);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(!this.satisfied){
            drawStatus(canvas);
        }
    }

    private void drawStatus(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.RED);
        if(miceRequired-mice==0)p.setColor(Color.GREEN);
        p.setTextSize(100);/////////////////////!!!!!!!!Multipyli with scalefactor!!!!!!!!!!!!1
        c.drawText(""+(miceRequired-mice), cmx, cmy, p);
    }


    public boolean isSatisfied(){
        if(satisfied){
            return true;
        }else{
            return miceRequired-mice == 0;
        }
    }

    public void setMice(int mice) {
        this.mice = mice;
    }

    public int getMice() {
        return mice;
    }

    public double getPull() {
        return pull;
    }

    public int getR() {
        return r;
    }
}
