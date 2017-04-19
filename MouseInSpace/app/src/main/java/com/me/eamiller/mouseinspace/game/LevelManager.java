package com.me.eamiller.mouseinspace.game;

import android.content.Context;
import android.content.SharedPreferences;

import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;
import com.me.eamiller.mouseinspace.game.entities.characters.planets.Planet;

/**
 * Created by eamiller on 2.2.2017.
 */
public class LevelManager {
    private int currentLevel = 0;
    private Game game;
    private Context context;

    private int centerX = (int)(GamePanel.initialScreenWidth/2);
    private int centerY = (int)(GamePanel.initialScreenHeight/2);

    public LevelManager(Game game){
        this.game = game;
        this.context = game.getGamePanel().getContext();

    }

    public boolean levelCleared(){
        for(Planet p : game.getPlanets()){
            if(!p.isSatisfied())return false;
        }
        return true;
    }

    public void clearLevelSpecificObjects(){
        game.getPlanets().clear();
        game.getMice().clear();
    }

    public void resetCurrentLevel(){
        if(currentLevel%5==0) game.changeBackGround();
        clearLevelSpecificObjects();
        switch(currentLevel) {
            case 1:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(new Planet(context, 500, 100));
                game.getPlanets().add(new Planet(context, 500, 500));
                game.getPlanets().add(new Planet(context, 500, 900, 1));
                break;
            case 2:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(planetOfTorque(100, 100, 150, 2));
                game.getPlanets().add(new Planet(context, 400, 400));
                game.getPlanets().add(new Planet(context, 700, 700, 1));
                break;
            case 3:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(new Planet(context, 500, 100));
                game.getPlanets().add(new Planet(context, 600, 500));
                game.getPlanets().add(new Planet(context, 300, 900, 1));
                break;
            case 4:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(new Planet(context, 200, 400));
                game.getPlanets().add(planetOfSize(300, 800, 50));
                game.getPlanets().add(new Planet(context, 500, 1200, 1));
                break;
            case 5:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(planetOfSize(400, 150, 50));
                game.getPlanets().add(planetOfSize(300, 500, 100));
                game.getPlanets().add(planetOfSize(300, 800, 50, 1));
                break;
            case 6:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(planetOfSize(500, 150, 75));
                game.getPlanets().add(planetOfSize(700, 300, 75));
                game.getPlanets().add(planetOfSize(300, 550, 75));
                game.getPlanets().add(planetOfSize(600, 700, 75));
                game.getPlanets().add(planetOfSize(100, 800, 75, 1));
                break;
            case 7:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(planetOfSize(100, 100, 75));
                game.getPlanets().add(planetOfSize(300, 300, 75));
                game.getPlanets().add(planetOfSize(500, 500, 75));
                game.getPlanets().add(planetOfSize(700, 700, 75));
                game.getPlanets().add(planetOfSize(900, 900, 75));
                game.getPlanets().add(planetOfSize(700, 1100, 75));
                game.getPlanets().add(planetOfSize(500, 1200, 75));
                game.getPlanets().add(planetOfSize(200, 1300, 75, 1));
                break;
            case 8:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(planetOfSize(100, 100, 75));
                game.getPlanets().add(planetOfSize(400, 100, 75));
                game.getPlanets().add(planetOfSize(700, 100, 75));
                game.getPlanets().add(planetOfSize(700, 400, 75));
                game.getPlanets().add(planetOfSize(800, 470, 75));
                game.getPlanets().add(planetOfSize(700, 700, 75));
                game.getPlanets().add(planetOfSize(500, 800, 75));
                game.getPlanets().add(planetOfSize(200, 900, 75, 1));
                break;
            case 9:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getPlanets().add(planetOfSize(300, 300, 75));
                game.getPlanets().add(planetOfSize(600, 600, 100));
                game.getPlanets().add(planetOfSize(900, 900, 75));
                game.getPlanets().add(planetOfSize(700, 1100, 75));
                game.getPlanets().add(planetOfSize(500, 1200, 75));
                game.getPlanets().add(planetOfSize(200, 1300, 75, 1));
                break;
            case 10:
                game.getMice().add(new Mouse(context, 100, 100));
                game.getMice().add(new Mouse(context, 1000, 100));
                game.getPlanets().add(planetOfSize(100, 100, 75));
                game.getPlanets().add(planetOfSize(300, 300, 75));
                game.getPlanets().add(planetOfSize(500, 500, 75));
                game.getPlanets().add(planetOfSize(700, 600, 75));
                game.getPlanets().add(planetOfSize(500, 700, 75));
                game.getPlanets().add(planetOfSize(700, 900, 75));
                game.getPlanets().add(planetOfSize(500, 1100, 75));
                game.getPlanets().add(planetOfSize(200, 1200, 75, 1));
                break;
            case 11:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getPlanets().add(planetOfSize(200, 200, 85));
                game.getPlanets().add(planetOfSize(550, 250, 75));
                game.getPlanets().add(planetOfSize(700, 350, 95));
                game.getPlanets().add(planetOfSize(900, 650, 75));
                game.getPlanets().add(planetOfSize(950, 850, 75));
                game.getPlanets().add(planetOfSize(100, 1000, 85));
                game.getPlanets().add(planetOfSize(800, 1150, 75));
                game.getPlanets().add(planetOfSize(500, 850, 155, 1));
                break;
            case 12:

                game.getMice().add(new Mouse(context, 1000, 100));
                game.getPlanets().add(planetOfSize(300, 120, 75));
                game.getPlanets().add(planetOfSize(600, 120, 75));
                game.getPlanets().add(planetOfTorque(400, 450, 250, 1));
                game.getPlanets().add(planetOfSize(300, 1100, 75));
                game.getPlanets().add(planetOfSize(600, 1200, 75, 1));



                break;
            case 13:

                game.getMice().add(new Mouse(context, 0, 0));
                game.getPlanets().add(planetOfTorque(200, 100, 135, 1));
                game.getPlanets().add(planetOfTorque(650, 350, 145, -2));
                game.getPlanets().add(planetOfTorque(200, 700, 155, 1));
                game.getPlanets().add(planetOfSize(660, 950, 165, 1));


                break;
            case 14:
                game.getMice().add(new Mouse(context, 0, 0));
                game.getPlanets().add(planetOfTorque(100, centerY-40, 80, 1));
                game.getPlanets().add(planetOfTorque(400, centerY, 80, -2));
                game.getPlanets().add(planetOfTorque(650, centerY-20, 80, 1));
                game.getPlanets().add(planetOfSize(900, centerY+10, 80, 1));


                break;
            case 15:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 1000, 600));
                game.getPlanets().add(planetOfSize(100, 600, 75));
                game.getPlanets().add(planetOfSize(500, 500, 120, 2));
                game.getPlanets().add(planetOfSize(900, 600, 75));


                break;
            case 16:

                game.getMice().add(new Mouse(context, 0, 0));
                for(int i = 0; i < 4; i++){
                    game.getPlanets().add(planetOfTorque(60+i*220, 200, 70, 1));
                    game.getPlanets().add(planetOfTorque(60+i*220, 500, 70, -1));
                    game.getPlanets().add(planetOfTorque(60+i*220, 800, 70, 2));
                }
                game.getPlanets().add(planetOfSize(900, 1400, 120, 1));


                break;
            case 17:

                game.getMice().add(new Mouse(context, 1000, 100));
                game.getPlanets().add(planetOfSize(300, 120, 75));
                game.getPlanets().add(planetOfSize(600, 120, 75));
                game.getPlanets().add(planetOfSize(500, 500, 145));
                game.getPlanets().add(planetOfSize(300, 1100, 75));
                game.getPlanets().add(planetOfSize(600, 1200, 75, 1));


                break;
            case 18:

                game.getMice().add(new Mouse(context, 520, 660));

                game.getPlanets().add(planetOfSize(200, 200, 75));
                game.getPlanets().add(planetOfSize(500, 100, 75));
                game.getPlanets().add(planetOfSize(750, 200, 75));
                game.getPlanets().add(planetOfSize(50, 700, 75));
                game.getPlanets().add(planetOfSize(800, 700, 75));
                game.getPlanets().add(planetOfSize(200, 1150, 75));
                game.getPlanets().add(planetOfSize(600, 1200, 75, 1));

                game.getPlanets().add(planetOfSize(500, 800, 10));
                break;
            case 19:

                game.getMice().add(new Mouse(context, 0, 600));
                for(int i = 0 ; i < 800 ; i+=200){
                    for(int j = 0; j < 1700; j+=200){
                        game.getPlanets().add(planetOfSize(i, j, 75));
                    }
                }

                game.getPlanets().add(planetOfSize(930, 920, 75, 1));
                break;
            case 20:

                game.getMice().add(new Mouse(context, 400, 750));
                game.getPlanets().add(planetOfSize(500, 700, 205));
                game.getPlanets().add(planetOfSize(700, 1300, 65));
                game.getPlanets().add(planetOfSize(500, 1600, 65));
                game.getPlanets().add(planetOfSize(100, 1600, 65));

                game.getPlanets().add(planetOfSize(-5, 800, 65));
                game.getPlanets().add(planetOfSize(8, 1250, 65));


                game.getPlanets().add(planetOfSize(100, 420, 75, 1));






                /**/
                break;
            case 21:

                game.getMice().add(new Mouse(context, 500, 0));

                game.getPlanets().add(planetOfSize(150, 150, 150));
                game.getPlanets().add(planetOfSize(650, 150, 150));

                game.getPlanets().add(planetOfSize(100, 650, 80));
                game.getPlanets().add(planetOfSize(700, 650, 80));

                game.getPlanets().add(planetOfSize(400, 760, 80));
                game.getPlanets().add(planetOfSize(400, 860, 80));
                game.getPlanets().add(planetOfSize(400, 960, 80));
                game.getPlanets().add(planetOfSize(400, 1060, 80));
                game.getPlanets().add(planetOfSize(400, 1160, 80));


                game.getPlanets().add(planetOfSize(700, 1500, 150, 1));





                break;
            case 22:
                game.getMice().add(new Mouse(context, 0, 0));
                //1st layer
                for(int i = 0; i < 1000; i+=20){
                    game.getPlanets().add(planetOfSize(i, 100, 40));
                }
                for(int i = 0; i < 1000; i+=20){
                    if(i<300||i>450) game.getPlanets().add(planetOfSize(i, 1550, 40));
                }
                for(int i = 0; i < 1500; i+=20){
                    game.getPlanets().add(planetOfSize(1000, 100+i, 40));
                }
                for(int i = 0; i < 1500; i+=20){
                    game.getPlanets().add(planetOfSize(1, 100+i, 40));
                }

                //2nd layer
                for(int i = 0; i < 640; i+=20){
                    game.getPlanets().add(planetOfSize(220+i, 350, 30));
                }
                for(int i = 0; i < 640; i+=20){
                    game.getPlanets().add(planetOfSize(220+i, 1300, 30));
                }
                for(int i = 0; i < 1000; i+=20){
                    game.getPlanets().add(planetOfSize(220, 350+i, 30));
                }
                for(int i = 0; i < 1000; i+=20){
                    if(i<400||i>600)game.getPlanets().add(planetOfSize(820, 350+i, 30));
                }

                //3rd layer
                for(int i = 0; i < 600; i+=10){
                    game.getPlanets().add(planetOfSize(660, 550+i, 20));
                }
                for(int i = 0; i < 160; i+=10){
                    game.getPlanets().add(planetOfSize(370, 840+i, 20));
                }
                for(int i = 0; i < 420; i+=10){
                    game.getPlanets().add(planetOfSize(250+i, 1120, 20));
                }
                for(int i = 0; i < 300; i+=10){
                    game.getPlanets().add(planetOfSize(370+i, 840, 20));
                }




                game.getPlanets().add(planetOfSize(500, 960, 40, 1));

                /**/
                break;
            case 23:
                game.getMice().add(new Mouse(context, 1000, 1300));
                game.getPlanets().add(planetOfSize(500, 120, 105));
                game.getPlanets().add(planetOfSize(800, 250, 105));
                game.getPlanets().add(planetOfSize(400, 400, 105));
                game.getPlanets().add(planetOfSize(950, 550, 55, 1));
                game.getPlanets().add(planetOfSize(400, 850, 105));
                game.getPlanets().add(planetOfSize(600, 1000, 105));
                game.getPlanets().add(planetOfSize(200, 1150, 105));
                game.getPlanets().add(planetOfSize(800, 1450, 105));
                break;
            case 24:
                game.getMice().add(new Mouse(context, 0, 0));
                for(int i = 100 ; i < 800; i+=145){
                    game.getPlanets().add(planetOfSize(i, i, 85));
                }
                game.getPlanets().add(planetOfSize(880, 940, 45));
                for(int i = 0 ; i < 550; i+=155){
                    game.getPlanets().add(planetOfSize(1000-i, 1070+i, 85));
                }


                game.getPlanets().add(planetOfSize(100, 1550, 55, 1));

                /**/
                break;
            case 25:

                game.getMice().add(new Mouse(context, 0, 0));

                for(int i = 100 ; i < 700; i+=150){
                    game.getPlanets().add(planetOfSize(i/2+i, i/2+10, 35));
                }
                int dm = 0;
                for(int i = 100 ; i < 1100; i+=250){
                    dm+=10;
                    game.getPlanets().add(planetOfTorque(500, 300+i, 35+dm, 2));
                }
                game.getPlanets().add(planetOfSize(200, 1200, 85, 1));


                break;
            case 26:
                game.getMice().add(new Mouse(context,500, 800));

                game.getPlanets().add(planetOfTorque(500, 1100, 255, 15));

                game.getPlanets().add(planetOfSize(400, 100, 185, 1));

                break;
            case 27:
                game.getMice().add(new Mouse(context,500, 200));

                game.getPlanets().add(planetOfTorque(250, 500, 305, 16));

                game.getPlanets().add(planetOfSize(400, 1200, 85, 1));


                break;
            case 28:
                game.getMice().add(new Mouse(context,0,0));

                game.getPlanets().add(planetOfSize(475, 760, 40));
                game.getPlanets().add(planetOfSize(510, 760, 40));
                game.getPlanets().add(planetOfSize(545, 760, 40));

                for(int i = 0; i < 600; i+=35){
                    game.getPlanets().add(planetOfSize(360, 760+i, 40));
                }
                for(int i = 0; i < 600; i+=35){
                    game.getPlanets().add(planetOfSize(665, 760+i, 40));
                }
                int torque = 1;
                for(int i = 0 ; i < 1000; i+=300){
                    for(int j = 0; j < 1500; j+=300){
                        if(Math.random()<0.5)torque*=-1;
                        game.getPlanets().add(planetOfTorque(i, 100+j, 100, torque));
                    }
                }
                game.getPlanets().add(planetOfSize(500, 885, 50, 1));

                /**/
                break;
            case 29:
                game.getMice().add(new Mouse(context, 520, 60));

                game.getPlanets().add(planetOfSize(200, 200, 75));
                game.getPlanets().add(planetOfSize(500, 100, 75));
                game.getPlanets().add(planetOfSize(750, 200, 75));
                game.getPlanets().add(planetOfSize(400, 500, 75));
                game.getPlanets().add(planetOfSize(200, 1150, 75));
                game.getPlanets().add(planetOfSize(900, 200, 75));
                game.getPlanets().add(planetOfSize(200, 1450, 75, 1));
                game.getPlanets().add(planetOfSize(600, 1200, 75));


                game.getPlanets().add(planetOfSize(300, 700, 30));
                game.getPlanets().add(planetOfSize(400, 700, 30));
                game.getPlanets().add(planetOfSize(500, 700, 30));
                game.getPlanets().add(planetOfSize(600, 700, 30));
                game.getPlanets().add(planetOfSize(400, 800, 30));
                game.getPlanets().add(planetOfSize(500, 800, 30));
                game.getPlanets().add(planetOfSize(600, 800, 30));
                game.getPlanets().add(planetOfSize(700, 800, 30));
                game.getPlanets().add(planetOfSize(300, 900, 30));
                game.getPlanets().add(planetOfSize(400, 900, 30));
                game.getPlanets().add(planetOfSize(500, 900, 30));
                game.getPlanets().add(planetOfSize(600, 900, 30));

                /**/
                break;
            case 30:
                game.getMice().add(new Mouse(context, 0,0));

                game.getPlanets().add(planetOfSize(0,10, 150));
                game.getPlanets().add(planetOfSize(490,10, 110));
                game.getPlanets().add(planetOfSize(870,150, 85));
                game.getPlanets().add(planetOfSize(950,500, 60));
                game.getPlanets().add(planetOfSize(740,840, 50));
                game.getPlanets().add(planetOfSize(540,1000, 40));
                game.getPlanets().add(planetOfSize(350,1150, 30));
                game.getPlanets().add(planetOfSize(260,1290, 25));
                game.getPlanets().add(planetOfSize(340,1450, 20));
                game.getPlanets().add(planetOfSize(550,1500, 15));
                game.getPlanets().add(planetOfSize(740,1450, 100, 1));

                break;
            case 31:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 1000, 600));
                game.getPlanets().add(planetOfSize(100, 900, 75));
                game.getPlanets().add(planetOfSize(500, 1100, 75));
                game.getPlanets().add(planetOfSize(200, 1200, 75, 2));
                break;
            case 32:
                game.getMice().add(new Mouse(context, 0, 0));
                game.getMice().add(new Mouse(context, 1000, 1300));
                game.getPlanets().add(planetOfSize(100, 420, 75));
                game.getPlanets().add(planetOfSize(500, 700, 205, 1));
                game.getPlanets().add(planetOfSize(200, 1100, 75, 1));
                break;
            case 33:
                game.getMice().add(new Mouse(context, 0, 1200));
                game.getMice().add(new Mouse(context, 0, 1300));
                game.getPlanets().add(planetOfSize(100, 1100, 75));
                game.getPlanets().add(planetOfSize(400, 700, 205, 0));
                game.getPlanets().add(planetOfSize(200, 400, 75, 1));
                break;
            case 34:
                game.getMice().add(new Mouse(context, 0, 0));
                game.getMice().add(new Mouse(context, 1000, 1300));
                game.getPlanets().add(planetOfSize(500, 120, 75, 0));
                game.getPlanets().add(planetOfSize(800, 250, 75, 1));
                game.getPlanets().add(planetOfSize(400, 400, 75, 0));
                game.getPlanets().add(planetOfSize(800, 600, 75, 0));
                game.getPlanets().add(planetOfSize(400, 850, 75, 0));
                game.getPlanets().add(planetOfSize(600, 1000, 85, 0));
                game.getPlanets().add(planetOfSize(200, 1150, 75, 1));
                break;
            case 35:
                game.getMice().add(new Mouse(context, 0, 0));
                game.getMice().add(new Mouse(context, 1000, 1300));
                game.getPlanets().add(planetOfSize(500, 420, 75, 0));
                game.getPlanets().add(planetOfSize(800, 700, 75, 0));
                game.getPlanets().add(planetOfSize(400, 850, 75, 0));
                game.getPlanets().add(planetOfSize(600, 900, 85, 0));
                game.getPlanets().add(planetOfSize(200, 1100, 75, 1));
                break;
            case 36:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 1000, 0));
                game.getPlanets().add(planetOfSize(300, 120, 105, 0));
                game.getPlanets().add(planetOfSize(550, 250, 75, 1));
                game.getPlanets().add(planetOfSize(600, 500, 95, 0));
                game.getPlanets().add(planetOfSize(200, 600, 75, 0));
                game.getPlanets().add(planetOfSize(400, 850, 75, 0));
                game.getPlanets().add(planetOfSize(600, 1000, 85, 0));
                game.getPlanets().add(planetOfSize(800, 1150, 75, 0));
                game.getPlanets().add(planetOfSize(100, 1150, 55, 1));
                break;
            case 37:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 1000, 0));
                game.getPlanets().add(planetOfSize(200, 200, 85));
                game.getPlanets().add(planetOfSize(550, 250, 75));
                game.getPlanets().add(planetOfSize(700, 350, 95));
                game.getPlanets().add(planetOfSize(900, 650, 75));
                game.getPlanets().add(planetOfSize(950, 850, 75));
                game.getPlanets().add(planetOfSize(100, 1000, 85));
                game.getPlanets().add(planetOfSize(800, 1150, 75));
                game.getPlanets().add(planetOfSize(500, 850, 155, 2));
                break;
            case 38:
                game.changeBackGround();
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(350, 500, 105, 3));
                game.getPlanets().add(planetOfSize(350, 300, 75));
                game.getPlanets().add(planetOfSize(150, 500, 75));
                game.getPlanets().add(planetOfSize(650, 500, 75));
                break;
            case 39:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(400, 100, 75, 1));
                game.getPlanets().add(planetOfSize(400, 400, 75));
                game.getPlanets().add(planetOfSize(400, 700, 75, 1));
                game.getPlanets().add(planetOfSize(400, 1000, 75));
                game.getPlanets().add(planetOfSize(400, 1300, 75, 1));
                break;
            case 40:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(400, 100, 75, 1));
                game.getPlanets().add(planetOfSize(300, 400, 75));
                game.getPlanets().add(planetOfSize(500, 700, 75, 1));
                game.getPlanets().add(planetOfSize(300, 1000, 75));
                game.getPlanets().add(planetOfSize(400, 1300, 75, 1));
                break;
            case 41:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(400, 100, 75));
                game.getPlanets().add(planetOfSize(300, 400, 75));
                game.getPlanets().add(planetOfSize(500, 700, 75, 3));
                game.getPlanets().add(planetOfSize(300, 1000, 75));
                game.getPlanets().add(planetOfSize(400, 1300, 75));

                break;
            case 42:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(400, 100, 75, 0));
                game.getPlanets().add(planetOfSize(300, 400, 55, 1));
                game.getPlanets().add(planetOfSize(500, 700, 85, 0));
                game.getPlanets().add(planetOfSize(300, 1000, 65, 1));
                game.getPlanets().add(planetOfSize(400, 1300, 75, 0));
                break;
            case 43:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(800, 100, 75));
                game.getPlanets().add(planetOfSize(670, 240, 85));
                game.getPlanets().add(planetOfSize(200, 400, 55, 1));
                game.getPlanets().add(planetOfSize(500, 700, 105));
                game.getPlanets().add(planetOfSize(200, 1000, 65, 2));
                break;
            case 44:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(0, 100, 75));
                game.getPlanets().add(planetOfSize(300, 100, 75));
                game.getPlanets().add(planetOfSize(600, 100, 75));
                game.getPlanets().add(planetOfSize(900, 100, 75));
                game.getPlanets().add(planetOfSize(0, 400, 75));
                game.getPlanets().add(planetOfSize(300, 400, 75));
                game.getPlanets().add(planetOfSize(600, 400, 75, 3));
                break;
            case 45:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(100, 100, 100));
                game.getPlanets().add(planetOfSize(500, 100, 100));
                game.getPlanets().add(planetOfSize(300, 400, 100));
                game.getPlanets().add(planetOfSize(750, 300, 100, 2));
                game.getPlanets().add(planetOfSize(550, 650, 100));
                game.getPlanets().add(planetOfSize(600, 900, 75, 1));
                break;
            case 46:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(100, 100, 100, 0));
                game.getPlanets().add(planetOfSize(500, 100, 100, 0));
                game.getPlanets().add(planetOfSize(300, 400, 100, 0));
                game.getPlanets().add(planetOfSize(750, 300, 100, 0));
                game.getPlanets().add(planetOfSize(550, 650, 100, 0));
                game.getPlanets().add(planetOfSize(600, 900, 75, 1));
                game.getPlanets().add(planetOfSize(100, 900, 100, 1));
                game.getPlanets().add(planetOfSize(500, 1100, 100, 0));
                game.getPlanets().add(planetOfSize(700, 1220, 100, 0));
                break;
            case 47:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 500, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(50, 250, 100, 1));
                game.getPlanets().add(planetOfSize(550, 120, 50));
                game.getPlanets().add(planetOfSize(365, 440, 130));
                game.getPlanets().add(planetOfSize(750, 330, 60));
                game.getPlanets().add(planetOfSize(550, 650, 70));
                game.getPlanets().add(planetOfSize(600, 900, 75, 1));
                game.getPlanets().add(planetOfSize(100, 900, 100));
                game.getPlanets().add(planetOfSize(500, 1100, 100));
                game.getPlanets().add(planetOfSize(700, 1220, 100, 1));
                break;
            case 48:
                game.changeBackGround();
                game.getMice().add(new Mouse(context, 0, 0));
                game.getMice().add(new Mouse(context, 800, 0));
                game.getMice().add(new Mouse(context, 0, 1000));
                game.getMice().add(new Mouse(context, 900, 900));
                game.getPlanets().add(planetOfSize(350, 450, 250, 4));
                game.getPlanets().add(planetOfSize(120, 100, 90));
                game.getPlanets().add(planetOfSize(900, 100, 130));
                game.getPlanets().add(planetOfSize(100, 1050, 100));
                game.getPlanets().add(planetOfSize(900, 1050, 100));
                break;
            case 49:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 300, 0));
                game.getMice().add(new Mouse(context, 600, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(100, 100, 100));
                game.getPlanets().add(planetOfSize(420, 100, 90));
                game.getPlanets().add(planetOfSize(800, 100, 130));
                game.getPlanets().add(planetOfSize(100, 450, 60, 2));
                game.getPlanets().add(planetOfSize(800, 450, 70, 2));
                break;
            case 50:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 300, 0));
                game.getMice().add(new Mouse(context, 600, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(100, 100, 100));
                game.getPlanets().add(planetOfSize(420, 200, 90));
                game.getPlanets().add(planetOfSize(800, 300, 130, 1));
                game.getPlanets().add(planetOfSize(100, 450, 60, 1));
                game.getPlanets().add(planetOfSize(800, 750, 70, 1));
                game.getPlanets().add(planetOfSize(600, 500, 75, 1));
                break;
            case 51:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 300, 0));
                game.getMice().add(new Mouse(context, 600, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(150, 200, 100, 0));
                game.getPlanets().add(planetOfSize(425, 310, 90, 0));
                game.getPlanets().add(planetOfSize(850, 420, 130, 0));
                game.getPlanets().add(planetOfSize(160, 530, 60, 0));
                game.getPlanets().add(planetOfSize(840, 740, 70, 2));
                game.getPlanets().add(planetOfSize(620, 650, 75, 0));
                break;
            case 52:
                game.getMice().add(new Mouse(context, 0, 600));
                game.getMice().add(new Mouse(context, 300, 0));
                game.getMice().add(new Mouse(context, 600, 0));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(150, 200, 100, 0));
                game.getPlanets().add(planetOfSize(425, 310, 90, 0));
                game.getPlanets().add(planetOfSize(850, 420, 130, 1));
                game.getPlanets().add(planetOfSize(160, 530, 60, 0));
                game.getPlanets().add(planetOfSize(840, 740, 70, 0));
                game.getPlanets().add(planetOfSize(620, 650, 75, 1));
                break;
            case 53:
                game.getMice().add(new Mouse(context, 50, 200));
                game.getMice().add(new Mouse(context, 300, 0));
                game.getMice().add(new Mouse(context, 600, 1400));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(50, 200, 100));
                game.getPlanets().add(planetOfSize(300, 400, 100));
                game.getPlanets().add(planetOfSize(600, 300, 100));
                game.getPlanets().add(planetOfSize(900, 200, 100));
                game.getPlanets().add(planetOfSize(0, 600, 100));
                game.getPlanets().add(planetOfSize(900, 1200, 100));
                game.getPlanets().add(planetOfSize(0, 1300, 100));
                game.getPlanets().add(planetOfSize(900, 900, 100));
                game.getPlanets().add(planetOfSize(500, 600, 100, 4));
                break;
            case 54:
                game.getMice().add(new Mouse(context, 50, 200));
                game.getMice().add(new Mouse(context, 300, 0));
                game.getMice().add(new Mouse(context, 600, 1400));
                game.getMice().add(new Mouse(context, 900, 600));
                game.getPlanets().add(planetOfSize(50, 200, 75));
                game.getPlanets().add(planetOfSize(300, 600, 75));
                game.getPlanets().add(planetOfSize(600, 300, 100));
                game.getPlanets().add(planetOfSize(900, 200, 75));
                game.getPlanets().add(planetOfSize(1, 600, 100));
                game.getPlanets().add(planetOfSize(600, 1200, 75));
                game.getPlanets().add(planetOfSize(0, 1200, 200, 1));
                game.getPlanets().add(planetOfSize(900, 900, 75, 1));
                game.getPlanets().add(planetOfSize(500, 600, 100, 2));
                break;
            case 55:
                break;
            case 56:
                break;
            case 57:
                break;
            case 58:
                break;
            case 59:
                break;
            case 60:
                break;
            case 61:
                break;
            case 62:
                break;
            case 63:
                break;
            case 65:
                break;
            case 66:
                break;
            case 67:
                break;
            case 68:
                break;
            case 69:
                break;
            case 70:
                break;
            case 71:
                break;
            case 72:
                break;
            case 73:
                break;
            case 74:
                break;
            case 75:
                break;
            case 76:
                break;
            case 77:
                break;
            case 78:
                break;
            case 79:
                break;
            case 80:
                break;
            case 81:
                break;
            case 82:
                break;
            case 83:
                break;
            case 84:
                break;
            case 85:
                break;
            case 86:
                break;
            case 87:
                break;
            case 88:
                break;
            case 89:
                break;
            case 90:
                break;
            case 91:
                break;
            case 92:
                break;
            case 93:
                break;
            case 94:
                break;
            case 95:
                break;
            case 96:
                break;
            case 97:
                break;
            case 98:
                break;
            case 99:
                break;
            case 100:
                break;
            case 101:
                break;
            case 102:
                break;
            case 103:
                break;
            case 104:
                break;
            case 105:
                break;
            case 106:
                break;
            case 107:
                break;
            case 108:
                break;
            case 109:
                break;
            case 110:
                break;
            case 111:
                break;
            case 112:
                break;
            case 113:
                break;
            case 114:
                break;
            case 115:
                break;
            case 116:
                break;
            case 117:
                break;
            case 118:
                break;
            case 119:
                break;
            case 120:
                break;
            case 121:
                break;
            case 122:
                break;
            case 123:
                break;
            case 124:
                break;
            case 125:
                break;
            case 126:
                break;
            case 127:
                break;
            case 128:
                break;
            case 129:
                break;
            case 130:
                break;
            case 131:
                break;
            case 132:
                break;
            case 133:
                break;
            case 134:
                break;
            case 135:
                break;
            case 136:
                break;
            case 137:
                break;
            case 138:
                break;
            case 139:
                break;
            case 140:
                break;
            case 141:
                break;
            case 142:
                break;
            case 143:
                break;
            case 144:
                break;
            case 145:
                break;
            case 146:
                break;
            case 147:
                break;
            case 148:
                break;
            case 149:
                break;
            case 150:
                break;

        }
    }

    public void setNextLevel(){
        currentLevel++;
        resetCurrentLevel();
        updateCurrentLevelInMemory();
        game.getGamePanel().setLevelNumber(currentLevel);
    }

    private void updateCurrentLevelInMemory(){
        SharedPreferences sharedPref = context.getSharedPreferences("preference_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("current_level", currentLevel);
        editor.commit();

        int defaultLevel = 1;
        int highestLevel = sharedPref.getInt("highest_level", defaultLevel);
        if(currentLevel+1 > highestLevel){
            editor.putInt("highest_level", currentLevel);//change to R.string.current_level somehow "current_level"
            editor.commit();
        }
    }

    private Planet planetOfSize(int x, int y, int size){
        Planet p = new Planet(context,x , y);
        p.setR((int)(size* GamePanel.scaleFactor));
        return p;
    }
    private Planet planetOfTorque(int x, int y, int size, int torque){
        Planet p = new Planet(context,x , y);
        p.setR((int)(size* GamePanel.scaleFactor));
        p.setTorque(torque);
        return p;
    }
    private Planet planetOfSize(int x, int y, int size, int miceNeeded){
        Planet p = new Planet(context, x , y, miceNeeded);
        p.setR((int)(size* GamePanel.scaleFactor));
        return p;
    }

    public void decLevel(){
        currentLevel--;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
