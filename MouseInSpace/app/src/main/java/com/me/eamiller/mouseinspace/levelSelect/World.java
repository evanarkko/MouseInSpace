package com.me.eamiller.mouseinspace.levelSelect;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.interfaces.*;
import com.me.eamiller.mouseinspace.levelSelect.buttons.LevelNumberButton;

import java.util.ArrayList;

/**
 * Created by eamiller on 22.2.2017.
 */
public class World implements drawable{
    private Context context;
    private int worldNumber; //also index of background
    private ArrayList<Bitmap> backgrounds = new ArrayList<>();

    private ArrayList<LevelNumberButton> levelNumberButtons = new ArrayList<>();//All on display
    private int totalNumberOfDisplayedLevels = 30;
    private int numberOfUnlockedLevels;


    public World(Context c, int worldNumber){
        this.context = c;
        this.worldNumber = worldNumber;
        initializeLevelNumberButtons();//This is why you create world-entities in the surfaceCreated() method
        addBackgroundImages();
    }

    private void addBackgroundImages(){
        backgrounds.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.planet1));
        backgrounds.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.planet2));
        backgrounds.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.planet3));
        backgrounds.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.doodle));
        backgrounds.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.space_time));
    }

    private void initializeLevelNumberButtons(){
        configureNumberOfUnlockedLevels();
        LevelNumberButton dimensionExtractionButtonObject = new LevelNumberButton(context, 0, true);
        int buttonHeight = dimensionExtractionButtonObject.getHeight();
        int buttonWidth = dimensionExtractionButtonObject.getWidth();
        int leftMargin = (int)(40*LevelSelectPanel.xFactor);
        int topMargin = (int)(350*LevelSelectPanel.yFactor);
        int widthMargin = (int)(50*LevelSelectPanel.xFactor);
        int heightMargin = (int)(15*LevelSelectPanel.yFactor);

        int worldFactor = (worldNumber-1)*30;
        int i = 0;
        for(int column = 0; column < 6; column++){
            for(int row = 0; row < 5; row++){
                levelNumberButtons.add(i, new LevelNumberButton(context, i + 1, worldFactor + i < numberOfUnlockedLevels));//i < nr of unlocked levels
                levelNumberButtons.get(i).setX(row*(buttonWidth+widthMargin)+leftMargin);
                levelNumberButtons.get(i).setY(column*(buttonHeight+heightMargin)+topMargin);
                i++;
                if(i >= totalNumberOfDisplayedLevels) break;
            }
        }
    }

    private void configureNumberOfUnlockedLevels(){
        SharedPreferences sharedPref = context.getSharedPreferences("preference_file", Context.MODE_PRIVATE);
        int defaultLevel = 1;
        int highestLevel = sharedPref.getInt("highest_level", defaultLevel);
        numberOfUnlockedLevels = highestLevel;
    }

    public ArrayList<LevelNumberButton> getLevelNumberButtons() {
        return levelNumberButtons;
    }

    public void nextWorld(){
        worldNumber++;
        levelNumberButtons.clear();
        initializeLevelNumberButtons();
        updateCurrentWorldinMemory();
    }

    public void previousWorld(){
        worldNumber--;
        levelNumberButtons.clear();
        initializeLevelNumberButtons();
        updateCurrentWorldinMemory();
    }

    private void updateCurrentWorldinMemory(){
        SharedPreferences sharedPref = context.getSharedPreferences("preference_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("current_world", worldNumber);
        System.out.println(worldNumber);
        editor.commit();
    }

    public boolean firstWorld(){
        return worldNumber == 1;
    }
    public boolean lastWorld(){
        return worldNumber == backgrounds.size();
    }

    @Override
    public void draw(Canvas canvas) {
        drawBackground(canvas);
        drawHeading(canvas);
        for(LevelNumberButton l : levelNumberButtons){
            l.draw(canvas);
        }
    }

    private void drawBackground(Canvas c){
        int width = (int)(LevelSelectPanel.initialScreenWidth*LevelSelectPanel.xFactor);
        int height = (int)(LevelSelectPanel.initialScreenHeight*LevelSelectPanel.yFactor);
        Bitmap toDraw = Bitmap.createScaledBitmap(backgrounds.get(worldNumber-1),width, height, true);
        c.drawBitmap(toDraw, 0,0,null);
                //c.drawBitmap(Bitmap.createScaledBitmap(backgrounds.get(worldNumber), (int)(LevelSelectPanel.initialScreenWidth*LevelSelectPanel.xFactor), (int)(LevelSelectPanel.initialScreenHeight*LevelSelectPanel.yFactor), true));
    }

    private void drawHeading(Canvas c){
        /*Typeface plain = Typeface.createFromAsset(assetManager, pathToFont);
        Typeface bold = Typeface.create(plain, Typeface.DEFAULT_BOLD)
        Paint paint = new Paint();
        paint.setTypeface(bold);*/

        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTypeface(Typeface.create(Typeface.SANS_SERIF,  Typeface.BOLD));
        p.setTextSize((float)(200*LevelSelectPanel.scaleFactor));
        c.drawText("World " + worldNumber, (int)(200*LevelSelectPanel.xFactor),(int)(250*LevelSelectPanel.yFactor), p);
    }

    public Context getContext() {
        return context;
    }
}
