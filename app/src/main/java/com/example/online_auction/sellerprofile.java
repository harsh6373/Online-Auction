package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sellerprofile extends AppCompatActivity {
    public TextView bidrequests,sellhistory,aboutus,contactus,terms,feedback;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellerprofile);


        logout=(Button)findViewById(R.id.logoutt);
        bidrequests=(TextView) findViewById(R.id.bidrequest);
       sellhistory=(TextView) findViewById(R.id.sellhisoryy);
        aboutus=(TextView) findViewById(R.id.aboutuss);
        contactus=(TextView) findViewById(R.id.contactuss);
        terms=(TextView) findViewById(R.id.termsconditionss);
        feedback=(TextView) findViewById(R.id.feedbackk);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


        bidrequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), com.example.online_auction.bidrequests.class);
                startActivity(i);
            }
        });

        sellhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), sellhistory.class);
                startActivity(i);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), About_Us.class);
                startActivity(i);
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Contact_Us.class);
                startActivity(i);
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), terms_and_condition.class);
                startActivity(i);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Feedback.class);
                startActivity(i);
            }
        });

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.smenu_profile);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.smenu_home :
                        startActivity(new Intent(getApplicationContext(),sellerhome.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.smenu_sellproduct :
                        startActivity(new Intent(getApplicationContext(),sellproduct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.smenu_bidrequests :
                        startActivity(new Intent(getApplicationContext(), com.example.online_auction.bidrequests.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.smenu_profile :
                        return true;


                }

                return false;
            }
        });


    }
}