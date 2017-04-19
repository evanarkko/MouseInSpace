package com.me.eamiller.mouseinspace.game.buttons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.game.Game;
import com.me.eamiller.mouseinspace.game.drawing.GamePanel;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Direction;
import com.me.eamiller.mouseinspace.game.entities.characters.Mice.Mouse;

/**
 * Created by eamiller on 5.2.2017.
 */
public class SwitchDirectionsButton extends InGameButton{

    public SwitchDirectionsButton(Game g) {
        super(g);
        y -= (int)(10* GamePanel.yFactor);
        this.x += this.width + (int)(15* GamePanel.xFactor);
        height *= 1.3;
        this.image = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.switch_button), width, height, false);
    }

    @Override
    public void buttonAction() {
        changeMouseDirection();
        for(Mouse m : game.getMice()){
            m.createAnimator();
        }
    }
    private void changeMouseDirection(){
        if(Mouse.mouseDirection==Direction.LEFT){
            Mouse.mouseDirection = Direction.RIGHT;
        }else{
            Mouse.mouseDirection=Direction.LEFT;
        }
        //createAnimator();
    }
}
