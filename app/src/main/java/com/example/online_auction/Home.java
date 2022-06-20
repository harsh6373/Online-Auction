package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ListView auctionlistview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Auction> auctionArrayList;
    Auction auction;
    FirebaseUser firebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseDatabase = FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getReference("Auctions");
        auctionlistview = findViewById(R.id.listview);
        auctionArrayList = new ArrayList<>();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        getData();



        BottomNavigationView bnv = findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.menu_home);
        bnv.setOnNavigationItemSelectedListener(item -> {
            switch(item.getItemId()){

                case R.id.menu_home :
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
                    startActivity(new Intent(getApplicationContext(), navprofile.class));
                    overridePendingTransition(0,0);
                    return true;


            }

            return false;
        });
    }
    private void getData () {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        auction = new Auction(
                                dataSnapshot.child("auction_name").getValue().toString(),
                                dataSnapshot.child("description").getValue().toString(),
                                dataSnapshot.child("hostname").getValue().toString(),
                                dataSnapshot.child("date").getValue().toString(),
                                dataSnapshot.child("category").getValue().toString());

                    }
                }
                    auctionArrayList.add(auction);

                    //  Log.v("DS","listsize"+contributorArrayList.size());

                    Auctionadapter auctionadapter = new Auctionadapter(Home.this,
                            auctionArrayList);
                    auctionlistview.setAdapter(auctionadapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}