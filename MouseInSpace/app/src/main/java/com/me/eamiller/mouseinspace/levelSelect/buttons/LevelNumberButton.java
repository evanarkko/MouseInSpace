package com.me.eamiller.mouseinspace.levelSelect.buttons;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.buttons.Button;
import com.me.eamiller.mouseinspace.levelSelect.LevelSelectPanel;

/**
 * Created by eamiller on 21.2.2017.
 */
public class LevelNumberButton extends Button {
    private int currentLevel;
    private boolean unlocked;

    public LevelNumberButton(Context c, int i, Boolean unlocked){
        super();
        this.context = c;
        this.currentLevel = i;
        this.unlocked = unlocked;
        x = 0;
        y = 0;
        int side = 160;
        width = (int)(side * LevelSelectPanel.xFactor);
        height = (int)(side * LevelSelectPanel.yFactor);
        if(unlocked){
            this.image = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.level_number_button_green), width, height, false);
        }else{
            this.image = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.level_number_button_red), width, height, false);
        }

    }

    @Override
    public void draw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize((int)(50*LevelSelectPanel.scaleFactor));
        super.draw(canvas);
        canvas.drawText(""+currentLevel, x+width/2, y+width/2, p);
    }

    @Override
    public void buttonAction() {
        SharedPreferences sharedPref = context.getSharedPreferences("preference_file", Context.MODE_PRIVATE);
        int defaultWorld = 1;
        int world = sharedPref.getInt("current_world", defaultWorld);

        System.out.println(world);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("current_level", (world-1)*30+currentLevel);//change to R.string.current_level somehow
        editor.commit();
    }

    public boolean isUnlocked() {
        return unlocked;
    }
}
