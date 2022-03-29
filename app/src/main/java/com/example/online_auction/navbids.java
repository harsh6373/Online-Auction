package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class navbids extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbids);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.menu_bids);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.menu_home :
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_cat :
                        startActivity(new Intent(getApplicationContext(), navcategory.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_bids :

                        return true;

                    case R.id.menu_profile :
                        startActivity(new Intent(getApplicationContext(), navprofile.class));
                        overridePendingTransition(0,0);
                        return true;


                }

                return false;
            }
        });

    }
}