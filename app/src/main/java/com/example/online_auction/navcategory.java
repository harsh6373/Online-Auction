package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class navcategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navcategory);

        ImageView imageView;
        imageView = findViewById(R.id.cat1);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),products.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.menu_cat);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.menu_home :
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_cat :

                        return true;

                    case R.id.menu_bids :
                        startActivity(new Intent(getApplicationContext(),navbids.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_profile :
                        startActivity(new Intent(getApplicationContext(),navprofile.class));
                        overridePendingTransition(0,0);
                        return true;


                }

                return false;
            }
        });

    }
}