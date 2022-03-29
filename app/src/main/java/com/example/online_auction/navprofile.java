package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class navprofile extends AppCompatActivity {

    ListView lvAvaialbleContributors;
    FirebaseDatabase mDatabase;
    DatabaseReference mGetReference;
    ArrayList<User> buyerArrayList;
    User user;
    FirebaseUser user1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navprofile);

        mDatabase = FirebaseDatabase.getInstance();
        mGetReference = mDatabase.getReference("Buyers");
        lvAvaialbleContributors = findViewById(R.id.retriveddata);
        buyerArrayList = new ArrayList<>();

        user1 = FirebaseAuth.getInstance().getCurrentUser();

        getData();

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.menu_profile);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.menu_home :
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_cat :
                        startActivity(new Intent(getApplicationContext(), navcategory.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_bids :
                        startActivity(new Intent(getApplicationContext(),navbids.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_profile :

                        return true;


                }

                return false;
            }
        });

    }

    private void getData () {

        mGetReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        user = new User(
                                child.child("name").getValue().toString(),
                                child.child("email").getValue().toString(),
                                child.child("phoneno").getValue().toString(),
                                child.child("address").getValue().toString());
                    }
                    buyerArrayList.add(user);

                    //  Log.v("DS","listsize"+contributorArrayList.size());

                    BuyerProfileAdapter buyerProfileAdapter = new BuyerProfileAdapter(navprofile.this,
                            buyerArrayList);
                    lvAvaialbleContributors.setAdapter(buyerProfileAdapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}