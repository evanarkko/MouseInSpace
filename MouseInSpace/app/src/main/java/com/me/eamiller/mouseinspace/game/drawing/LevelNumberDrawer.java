package com.me.eamiller.mouseinspace.game.drawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.interfaces.*;
import com.me.eamiller.mouseinspace.levelSelect.buttons.LevelNumberButton;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eamiller on 8.3.2017.
 */
public class LevelNumberDrawer implements drawable {
    private HashMap<Integer, Bitmap> numberImages = new HashMap<>();
    private int levelNumber;
    private int width, height;

    public LevelNumberDrawer(Context context, int levelNumber){
        this.levelNumber = levelNumber;
        width = (int)(50*GamePanel.xFactor);
        height = (int)(80*GamePanel.yFactor);
        System.out.println("WIDTH:"+width + " HEIGHT" +height);
        numberImages.put(0, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_nil), width, height, true));
        numberImages.put(1, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_one), width, height, true));
        numberImages.put(2, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_two), width, height, true));
        numberImages.put(3, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_three), width, height, true));
        numberImages.put(4, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_four), width, height, true));
        numberImages.put(5, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_five), width, height, true));
        numberImages.put(6, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_six), width, height, true));
        numberImages.put(7, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_seven), width, height, true));
        numberImages.put(8, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_eight), width, height, true));
        numberImages.put(9, Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.numbers_nine), width, height, true));

    }
    @Override
    public void draw(Canvas canvas) {
        String luku = ""+levelNumber;
        int luvunPituus = luku.length();
        int marginX = (int)(10*GamePanel.xFactor);
        int marginY = (int)(20*GamePanel.yFactor);
        for(int i = 0; i < luvunPituus; i++){
            canvas.drawBitmap(numberImages.get(Integer.parseInt(""+luku.charAt(i))), marginX, marginY, null);
            marginX += width;
        }
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
}
