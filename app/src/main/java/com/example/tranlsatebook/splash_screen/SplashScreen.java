package com.example.tranlsatebook.splash_screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.tranlsatebook.R;
import com.example.tranlsatebook.activity.LoginActivity;

public class SplashScreen extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 2000;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, LoginActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
