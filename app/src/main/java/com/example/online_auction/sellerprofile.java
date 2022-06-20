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

public class sellerprofile extends AppCompatActivity {

    ListView sellerlistview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<User> sellerArrayList;
    User user;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellerprofile);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Sellers");
        sellerlistview = findViewById(R.id.retriveddata_seller);
        sellerArrayList = new ArrayList<>();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        getData();

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
                        startActivity(new Intent(getApplicationContext(), bidrequests.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.smenu_profile :
                        return true;


                }

                return false;
            }
        });


    }

    private void getData () {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        user = new User(
                                dataSnapshot.child(firebaseUser.getUid()).child("name").getValue().toString(),
                                dataSnapshot.child(firebaseUser.getUid()).child("email").getValue().toString(),
                                dataSnapshot.child(firebaseUser.getUid()).child("phoneno").getValue().toString(),
                                dataSnapshot.child(firebaseUser.getUid()).child("address").getValue().toString());



                    }
                    sellerArrayList.add(user);

                    //  Log.v("DS","listsize"+contributorArrayList.size());

                    SellerProfileAdapter sellerProfileAdapter = new SellerProfileAdapter(sellerprofile.this,
                            sellerArrayList);
                    sellerlistview.setAdapter(sellerProfileAdapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}