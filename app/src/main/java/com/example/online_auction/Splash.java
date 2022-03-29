package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        new Handler().postDelayed(new Runnable() {


            @Override

            public void run() {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(i);



                finish();

            }

        }, 4000);


        final TypeWriter tw = (TypeWriter) findViewById(R.id.tv);

        tw.setText("");
        
        
        tw.setCharacterDelay(150);
        tw.animateText("ONLINE AUCTION");


    }

}












