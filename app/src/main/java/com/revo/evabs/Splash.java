package com.revo.evabs;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    Animation slide_up_anim;
    Animation slide_down_anim;
    ImageView im;
    TextView tv;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        im = findViewById(R.id.imageViewsplash);
        tv = findViewById(R.id.textViewsplash);
        tv1 = findViewById(R.id.textViewsplash1);

        slide_up_anim = AnimationUtils.loadAnimation(this, R.anim.slide_up_anim);
        im.setAnimation(slide_up_anim);

        slide_down_anim = AnimationUtils.loadAnimation(this, R.anim.slide_down_anim);
        tv.setAnimation(slide_down_anim);
        tv1.setAnimation(slide_down_anim);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(com.revo.evabs.Splash.this, com.revo.evabs.ChallengeList.class);
                Splash.this.startActivity(i);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
