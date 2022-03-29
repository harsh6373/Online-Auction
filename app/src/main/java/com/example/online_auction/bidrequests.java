package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bidrequests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidrequests);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.smenu_bidrequests);
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
                        return true;

                    case R.id.smenu_profile :
                        startActivity(new Intent(getApplicationContext(),sellerprofile.class));
                        overridePendingTransition(0,0);
                        return true;


                }

                return false;
            }
        });




    }
}