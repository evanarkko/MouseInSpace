package com.me.eamiller.mouseinspace.game.buttons;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.me.eamiller.mouseinspace.game.Game;
import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.interfaces.*;
/**
 * Created by eamiller on 5.2.2017.
 */
public class Button implements drawable {
    protected Context context;
    protected Bitmap image;

    protected int x, y, width = 180, height=70;


    public Button(){
        this.x = (int)(650*GamePanel.xFactor);
        this.y = (int)(70*GamePanel.yFactor);
        width = (int)(200 * GamePanel.xFactor);
        height = (int)(90 * GamePanel.yFactor);
    }

    public void buttonAction(){

    }

    public boolean surroundsCoordinates(int x, int y){
        if(y < this.y || y > this.y+height) return false;
        if(x < this.x || x > this.x+width) return false;
        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
