package com.me.eamiller.mouseinspace.game;

import android.graphics.Canvas;

import com.me.eamiller.mouseinspace.game.Threads.MainThread;
import com.me.eamiller.mouseinspace.game.buttons.Button;
import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;
import com.me.eamiller.mouseinspace.game.physics.mousePhysics.MouseImpactor;

import java.util.ArrayList;

/**
 * Created by eamiller on 23.1.2017.
 */
public class Game {
    private GamePanel gamePanel;
    private Canvas gameCanvas;
    private MainThread thread;
    private LevelManager levelManager;
    private boolean gameOver = false;
    private ArrayList<Button> inGameButtons = new ArrayList<>();

    private ArrayList<Planet> planets = new ArrayList<>();
    private ArrayList<Mouse> mice = new ArrayList<>();
    private MouseImpactor mouseImpactor;
    private Collider collider = new Collider();


    public Game(GamePanel gp){
        this.gamePanel = gp;
        this.thread = new MainThread(gp.getHolder(), this);
        this.levelManager = new LevelManager(this);

    }

    public void start(){
        thread.setRunning(true);
        thread.start();
    }


    public void advance(){
        if(!gameOver){
            gamePanel.update();
            updatePlanets();
            if(levelManager.levelCleared())levelManager.setNextLevel();
            updateAllMice();
            gamePanel.draw(gameCanvas);
        }

    }

    private void updatePlanets(){
        for(Planet p : planets){
            p.update();
        }
    }

    private void updateAllMice(){
        for(int mouseIndex = 0; mouseIndex < mice.size(); mouseIndex++){
            Planet closestPlanet = planets.get(indexOfClosestPlanet(mouseIndex));
            mice.get(mouseIndex).setInteractingPlanet(closestPlanet);
            mice.get(mouseIndex).update();
        }
    }

    private int indexOfClosestPlanet(int indexOfMouse){//make this mouse's method
        int smallestDistance = Integer.MAX_VALUE;
        int i = 0;
        int index = 0;
        for(Planet p : planets){
            int dis = collider.distance(mice.get(indexOfMouse), p)- p.getR();
            if(dis<smallestDistance){
                index = i;
                smallestDistance = dis;
            }
            i++;
        }
        return index;
    }

    public void exitGame(){
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            }catch (InterruptedException e){e.printStackTrace();}
            retry = false;
        }
    }

    public void setCanvas(Canvas canvas) {
        this.gameCanvas = canvas;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public ArrayList<Mouse> getMice() {
        return mice;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public Planet getPlanet(int i) {
        return planets.get(i);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void changeBackGround(){
        gamePanel.changeBackGround();
    }

    public ArrayList<Button> getInGameButtons() {
        return inGameButtons;
    }

    public void resetCurrentLevel(){
        this.levelManager.decLevel();
        this.levelManager.clearLevelSpecificObjects();
    }

    public int getCurrentLevel(){
        return this.levelManager.getCurrentLevel();
    }

    public void setCurrentLevel(int currentLevel){
        this.levelManager.setCurrentLevel(currentLevel);
    }
}
