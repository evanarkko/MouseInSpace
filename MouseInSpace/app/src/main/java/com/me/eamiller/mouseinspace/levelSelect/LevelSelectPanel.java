package com.me.eamiller.mouseinspace.levelSelect;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.buttons.Button;
import com.me.eamiller.mouseinspace.levelSelect.buttons.LevelNumberButton;
import com.me.eamiller.mouseinspace.levelSelect.buttons.worldChangeButtons.NextWorldButton;
import com.me.eamiller.mouseinspace.levelSelect.buttons.worldChangeButtons.PreviousWorldButton;
import com.me.eamiller.mouseinspace.levelSelect.buttons.worldChangeButtons.WorldChangeButton;

/**
 * Created by eamiller on 21.2.2017.
 */
public class LevelSelectPanel extends SurfaceView implements SurfaceHolder.Callback {
    private LevelSelectThread thread;
    private Context context;
    public static final int initialScreenHeight = 1740;
    public static final int initialScreenWidth = 1080;
    public static double yFactor;
    public static double xFactor;
    public static double scaleFactor;

    private World currentDisplayedWorld;
    private int initialWorldNumber;
    private WorldChangeButton[] worldChangeButtons = new WorldChangeButton[2];

    public LevelSelectPanel(Context context, int initialWorldNumber) {
        super(context);
        this.context = context;
        getHolder().addCallback(this);
        setFocusable(true);
        thread = new LevelSelectThread(getHolder(), this);
        this.initialWorldNumber = initialWorldNumber;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        yFactor = (1.0*getHeight()/(1.0*initialScreenHeight));
        xFactor = (1.0*getWidth()/(1.0*initialScreenWidth));
        scaleFactor = (yFactor + xFactor) / 2;

        currentDisplayedWorld = new World(context, initialWorldNumber);
        this.worldChangeButtons[0] = new PreviousWorldButton(currentDisplayedWorld);
        this.worldChangeButtons[1] = new NextWorldButton(currentDisplayedWorld);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            }catch (InterruptedException e){e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            for(Button b : worldChangeButtons){
                if(b.surroundsCoordinates((int)event.getX(), (int)event.getY())){
                    b.buttonAction();
                }
            }
            for(LevelNumberButton l : currentDisplayedWorld.getLevelNumberButtons()){
                if(l.surroundsCoordinates((int)event.getX(), (int)event.getY())){
                    if(l.isUnlocked()){
                        l.buttonAction();
                        ((Activity) context).finish();
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawBitmap(toImage(R.drawable.black), 0, 0, null);
        currentDisplayedWorld.draw(canvas);
        for(Button b : worldChangeButtons){
            b.draw(canvas);
        }
    }

    private Bitmap toImage(int i){
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), i), (int)(initialScreenWidth*xFactor),
                (int)(initialScreenHeight*yFactor), true);
    }


}
