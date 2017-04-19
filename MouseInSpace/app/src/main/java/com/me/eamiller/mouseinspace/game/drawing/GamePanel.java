package com.me.eamiller.mouseinspace.game.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.me.eamiller.mouseinspace.game.Game;
import com.me.eamiller.mouseinspace.game.Threads.MainThread;
import com.me.eamiller.mouseinspace.game.background.Background;
import com.me.eamiller.mouseinspace.game.buttons.Button;
import com.me.eamiller.mouseinspace.game.buttons.ResetButton;
import com.me.eamiller.mouseinspace.game.buttons.SwitchDirectionsButton;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.State;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;
import com.me.eamiller.mouseinspace.game.interfaces.*;

/**
 * Created by eamiller on 23.1.2017.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback, drawable, updateable{
    private Game game;
    private MainThread thread;
    private Background background;
    private Context contextToPass;
    private LevelNumberDrawer lvlDraw;

    public static final int initialScreenHeight = 1740;
    public static final int initialScreenWidth = 1080;
    public static double yFactor;
    public static double xFactor;
    public static double scaleFactor;

    public GamePanel(Context context) {
        super(context);
        this.contextToPass = context;
        getHolder().addCallback(this);//add callBack to interpret events (finger tapping etc.)
        setFocusable(true);//make gamePanel focusable so it can handle events
        this.game = new Game(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        yFactor = (1.0*getHeight()/(1.0*initialScreenHeight));
        xFactor = (1.0*getWidth()/(1.0*initialScreenWidth));
        scaleFactor = (yFactor + xFactor) / 2;


        lvlDraw = new LevelNumberDrawer(contextToPass, game.getCurrentLevel());
        game.getInGameButtons().add(new ResetButton(game));
        game.getInGameButtons().add(new SwitchDirectionsButton(game));
        background = new Background(contextToPass);
        game.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        game.exitGame();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean buttonHasBeenPressed = false;
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            for(Button b : game.getInGameButtons()){
                if(b.surroundsCoordinates((int)event.getX(), (int)event.getY())){
                    b.buttonAction();
                    buttonHasBeenPressed = true;
                }
            }
            if(!buttonHasBeenPressed){
                for(Mouse m : game.getMice()){
                    if(m.getState() == State.RUNNING){
                        m.jump();//!!!!!!!!!!!mouse.jumo()!!!!!!!!!!!!!!!!!!!!!
                    }
                }
            }

        }
        return super.onTouchEvent(event);
    }

    @Override
    public void draw(Canvas c){
        super.draw(c);
        background.draw(c);
        for(Planet p : game.getPlanets()){
            p.draw(c);
        }
        for(Mouse m : game.getMice()){
            m.draw(c);
        }
        for(Button b : game.getInGameButtons()){
            b.draw(c);
        }
        drawLvl(c);
    }

    private void drawLvl(Canvas c){
        lvlDraw.draw(c);
        /*Paint p = new Paint();
        p.setTextSize((float)(100*GamePanel.yFactor));
        c.drawText(""+game.getCurrentLevel(), (int)(10*xFactor), (int)(100*yFactor), p);*/
    }


    public void changeBackGround(){
        background.nextImage();
    }

    public void setLevel(int level){
        System.out.println("LEVEL:"+level);
        game.setCurrentLevel(level-1);
    }

    public void setLevelNumber(int lvl){
        this.lvlDraw.setLevelNumber(lvl);
    }

    @Override
    public void update() {
        background.update();
    }
}
