package com.me.eamiller.mouseinspace.game.buttons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.Game;
import com.me.eamiller.mouseinspace.game.drawing.GamePanel;

/**
 * Created by eamiller on 5.2.2017.
 */
public class ResetButton extends InGameButton {
    public ResetButton(Game g) {
        super(g);
        y -= (int)(60* GamePanel.yFactor);
        x += (int)(25* GamePanel.xFactor);
        height *= 2.1;
        width *= 1.1;
        this.image = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.reset_button), width, height, false);
    }

    @Override
    public void buttonAction() {
        game.resetCurrentLevel();
    }
}
