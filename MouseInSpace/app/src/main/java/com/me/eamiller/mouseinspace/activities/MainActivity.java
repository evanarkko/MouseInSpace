package com.me.eamiller.mouseinspace.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.me.eamiller.mouseinspace.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void playGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        System.out.println("gameplaybutton pressed");
        startActivity(intent);
    }

    public void levelSelect(View view){
        Intent intent = new Intent(this, LevelSelectActivity.class);
        System.out.println("gameplaybutton pressed");
        startActivity(intent);
    }

    public void tutorial(View view){
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }

    public void highScores(View view){
        Intent intent = new Intent(this, HighscoreActivity.class);
        startActivity(intent);
        System.out.println("highscorebutton pressed");

    }

    public void settings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
