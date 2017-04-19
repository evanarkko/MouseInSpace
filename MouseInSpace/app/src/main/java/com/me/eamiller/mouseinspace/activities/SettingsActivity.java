package com.me.eamiller.mouseinspace.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.me.eamiller.mouseinspace.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void resetGame(View view){
        AlertDialog.Builder resetWarningBuilder = new AlertDialog.Builder(this);
        resetWarningBuilder.setMessage("Reset all progress?");
        resetWarningBuilder.setCancelable(true);

        resetWarningBuilder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences sharedPref = getSharedPreferences("preference_file", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("current_level", 1);
                        editor.putInt("highest_level", 1);
                        editor.commit();
                        dialog.cancel();
                    }
                });

        resetWarningBuilder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = resetWarningBuilder.create();
        alert11.show();
    }

    public void setZeroGravity(View view){
        AlertDialog.Builder lockedButtonAlertBuilder = new AlertDialog.Builder(this);
        lockedButtonAlertBuilder.setMessage("Zero Gravity feature locked\n(complete World 5 to unlock)");
        lockedButtonAlertBuilder.setCancelable(true);

        lockedButtonAlertBuilder.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = lockedButtonAlertBuilder.create();
        alert11.show();
    }

}
