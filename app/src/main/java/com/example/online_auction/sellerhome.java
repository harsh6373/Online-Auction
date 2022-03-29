package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sellerhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellerhome);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.smenu_home);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.smenu_home :
                        return true;

                    case R.id.smenu_sellproduct :
                        startActivity(new Intent(getApplicationContext(), sellproduct.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.smenu_bidrequests :
                        startActivity(new Intent(getApplicationContext(), bidrequests.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.smenu_profile :
                        startActivity(new Intent(getApplicationContext(), sellerprofile.class));
                        overridePendingTransition(0,0);
                        return true;


                }

                return false;
            }
        });







    }
}


