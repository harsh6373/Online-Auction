package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        tabLayout = findViewById(R.id.tabLayout1);
        viewPager = findViewById(R.id.viewpager1);

        tabLayout.setupWithViewPager(viewPager);

        Tab_Adapter tab_adapter = new Tab_Adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        tab_adapter.addFragment(new LiveFragment(), "UPCOMMING");
        tab_adapter.addFragment(new UpcommingFragment(), "LIVE");
        tab_adapter.addFragment(new ClosedFragment(), "CLOSED");
        viewPager.setAdapter(tab_adapter);



        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.menu_home);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            }
        });
    }
}