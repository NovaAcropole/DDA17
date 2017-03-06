package br.na.dda17;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 349059 on 20/06/16.
 */
public class SplashActivity extends Activity {

    private static final int duracao = 2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onStart() {
        super.onStart();
        TimerTask t = new TimerTask() {
            // Esse método será executado sempre que o timer acabar e chamar a  activity principal
            @Override
            public void run() {
                Intent in = new Intent().setClass(SplashActivity.this, MainActivity.class);
                startActivity(in);
                finish();

            }

        };

    }
}

