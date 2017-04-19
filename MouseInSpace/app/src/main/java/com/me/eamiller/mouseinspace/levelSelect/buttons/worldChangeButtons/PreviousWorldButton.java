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
public class PreviousWorldButton extends WorldChangeButton {
    public PreviousWorldButton(World world) {
        super(world);
        this.x = (int)(150*LevelSelectPanel.xFactor);
        this.image = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.arrow_left), width, height, false);

    }

    @Override
    public void buttonAction() {
        if(activeLeft){
            world.previousWorld();
            activeRight = true;
            if(world.firstWorld()) activeLeft = false;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if(activeLeft){
            super.draw(canvas);
        }
    }
}
