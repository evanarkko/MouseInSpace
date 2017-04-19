package com.me.eamiller.mouseinspace.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.me.eamiller.mouseinspace.game.drawing.GamePanel;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GamePanel gp = new GamePanel(this);
        setLevelFromMemory(gp);
        setContentView(gp);
    }

    private void setLevelFromMemory(GamePanel gp){
        SharedPreferences sharedPref = getSharedPreferences("preference_file", Context.MODE_PRIVATE);
        int defaultLevel = 1;
        int level = sharedPref.getInt("current_level", defaultLevel);
        gp.setLevel(level);
    }
}
