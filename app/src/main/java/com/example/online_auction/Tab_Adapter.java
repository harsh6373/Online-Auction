package com.example.online_auction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Tab_Adapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentArrayList  = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    public Tab_Adapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }
    public void addFragment(Fragment fragment,String title){
        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {


        return fragmentTitle.get(position);



    }
}
