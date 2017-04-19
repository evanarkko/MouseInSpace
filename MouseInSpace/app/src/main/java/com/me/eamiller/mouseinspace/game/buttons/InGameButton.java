package com.me.eamiller.mouseinspace.game.buttons;

import com.me.eamiller.mouseinspace.game.Game;
import com.me.eamiller.mouseinspace.game.drawing.GamePanel;

/**
 * Created by eamiller on 21.2.2017.
 */
public class InGameButton extends Button {
    protected Game game;

    public InGameButton(Game g) {
        super();
        this.game = g;
        this.context = g.getGamePanel().getContext();
        this.x = (int)(650* GamePanel.xFactor);
        this.y = (int)(70*GamePanel.yFactor);
        width = (int)(200 * GamePanel.xFactor);
        height = (int)(90 * GamePanel.yFactor);
    }
}
