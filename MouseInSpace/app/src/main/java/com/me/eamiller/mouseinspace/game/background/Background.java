package com.me.eamiller.mouseinspace.game.background;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.interfaces.*;

import java.util.ArrayList;

/**
 * Created by eamiller on 25.1.2017.
 */
public class Background implements drawable, updateable {
    private int width, height;
    private Context context;
    private Bitmap spinningBackgroundImage;
    private Bitmap staticBackGroundImage;
    private ArrayList<Bitmap> spinningImages = new ArrayList<>();
    private ArrayList<Bitmap> staticImages = new ArrayList<>();
    private int currentImageIndex = 0;
    int cmx = (int)((GamePanel.initialScreenWidth*GamePanel.xFactor)/2);
    int cmy = (int)((GamePanel.initialScreenHeight*GamePanel.yFactor)/2);
    int angle = 0;
    int torque = 2;


    public Background(Context context){
        this.context = context;
        addImages();
        this.width = (int)(GamePanel.initialScreenWidth*GamePanel.xFactor);
        this.height = (int)(GamePanel.initialScreenHeight*GamePanel.yFactor);
        this.spinningBackgroundImage = Bitmap.createScaledBitmap(spinningImages.get(currentImageIndex), width, height, true);
        this.staticBackGroundImage = Bitmap.createScaledBitmap(staticImages.get(currentImageIndex), width, height, true);
    }

    public void nextImage(){
        currentImageIndex++;
        if(currentImageIndex>= staticImages.size()) currentImageIndex=0;
        this.staticBackGroundImage = Bitmap.createScaledBitmap(staticImages.get(currentImageIndex), width, height, true);
    }

    private void addImages(){
        staticImages.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.background1_blue));
        staticImages.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.background1_colour2));
        staticImages.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.doodle));
        staticImages.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.background1_colour1));


        spinningImages.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.doodle));
        spinningImages.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.background1_colour2));
        spinningImages.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.doodle));
        spinningImages.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.background1_colour1));
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(staticBackGroundImage, (int)0, (int)0, null);
        /*canvas.save();
        canvas.rotate(angle, cmx, cmy);
        canvas.drawBitmap(spinningBackgroundImage, (int)0, (int)0, null);
        canvas.restore();*/
    }

    @Override
    public void update() {
        updateAngle();
    }
    private void updateAngle(){
        angle += torque;
        if(angle>360){
            angle = angle - 360;
        }
    }
}
