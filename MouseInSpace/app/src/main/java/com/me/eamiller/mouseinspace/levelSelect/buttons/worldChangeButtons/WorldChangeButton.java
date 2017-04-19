package com.me.eamiller.mouseinspace.levelSelect.buttons.worldChangeButtons;

import com.me.eamiller.mouseinspace.game.buttons.Button;
import com.me.eamiller.mouseinspace.levelSelect.LevelSelectPanel;
import com.me.eamiller.mouseinspace.levelSelect.World;

/**
 * Created by eamiller on 22.2.2017.
 */
public class WorldChangeButton extends Button{
    protected World world;
    protected static boolean activeLeft = false;
    protected static boolean activeRight = true;

    public WorldChangeButton(World world){
        this.world = world;
        this.context = world.getContext();
        this.width = (int)(300*LevelSelectPanel.xFactor);
        this.height = (int)(150*LevelSelectPanel.yFactor);
        this.y = (int)((LevelSelectPanel.initialScreenHeight - 120)*LevelSelectPanel.yFactor-height);
    }

    @Override
    public void buttonAction() {
    }

    public void setActiveLeft(boolean active) {
        this.activeLeft = active;
    }
    public void setActiveRight(boolean active) {
        this.activeRight = active;
    }
}
