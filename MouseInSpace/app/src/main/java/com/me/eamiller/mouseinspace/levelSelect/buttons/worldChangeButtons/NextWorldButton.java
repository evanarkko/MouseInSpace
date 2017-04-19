package com.me.eamiller.mouseinspace.levelSelect.buttons.worldChangeButtons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.levelSelect.LevelSelectPanel;
import com.me.eamiller.mouseinspace.levelSelect.World;

/**
 * Created by eamiller on 22.2.2017.
 */
public class NextWorldButton extends WorldChangeButton {
    public NextWorldButton(World world) {
        super(world);
        this.x = (int)((LevelSelectPanel.initialScreenWidth-150)*LevelSelectPanel.xFactor-width);
        this.image = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.arrow_right), width, height, false);

    }

    @Override
    public void buttonAction() {
        if(activeRight){
            world.nextWorld();
            activeLeft = true;
            if(world.lastWorld()) activeRight = false;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if(activeRight){
            super.draw(canvas);
        }
    }
}
