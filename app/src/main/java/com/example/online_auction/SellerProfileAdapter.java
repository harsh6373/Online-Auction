package com.example.online_auction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SellerProfileAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> sellerArrayList;
    public SellerProfileAdapter(Context context, ArrayList<User> arrayList) {
        this.context = context;
        this.sellerArrayList = arrayList;
    }
    @Override
    public int getCount() {
        return sellerArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.sellerprofilelist, viewGroup, false);
        TextView name = view.findViewById(R.id.namesellerretrive);
        TextView email = view.findViewById(R.id.emailsellerretrive);
        TextView phone = view.findViewById(R.id.phonenosellerretrive);
        TextView address = view.findViewById(R.id.addresssellerretrive);




        name.setText(" Name :"+sellerArrayList.get(i).getName());
        email.setText("Email :"+sellerArrayList.get(i).getEmail());
        phone.setText("Phone No :"+sellerArrayList.get(i).getPhoneno());
        address.setText("Address :"+sellerArrayList.get(i).getAddress());


        return view;
    }
}
