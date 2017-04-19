package com.me.eamiller.mouseinspace.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.me.eamiller.mouseinspace.R;
import com.me.eamiller.mouseinspace.levelSelect.LevelSelectPanel;

public class LevelSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LevelSelectPanel panel = new LevelSelectPanel(this, returnCurrentWorld());
        setContentView(panel);
    }

    private int returnCurrentWorld(){
        SharedPreferences sharedPref = getSharedPreferences("preference_file", Context.MODE_PRIVATE);
        int defaultWorld = 1;
        return sharedPref.getInt("current_world", defaultWorld);
    }
}
