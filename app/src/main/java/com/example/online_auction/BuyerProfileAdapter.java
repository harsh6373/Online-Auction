package com.example.online_auction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BuyerProfileAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> buyerArrayList;
    public BuyerProfileAdapter(Context context, ArrayList<User> arrayList) {
        this.context = context;
        this.buyerArrayList = arrayList;
    }
    @Override
    public int getCount() {
        return buyerArrayList.size();
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
    public View getView(int i,View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.buyerprofilelist, parent, false);
        TextView name = convertView.findViewById(R.id.namebuyerretrive);
        TextView email = convertView.findViewById(R.id.emailbuyerretrive);
        TextView phone = convertView.findViewById(R.id.phonenobuyerretrive);
        TextView address = convertView.findViewById(R.id.addressbuyerretrive);




        name.setText(" Name :"+buyerArrayList.get(i).getName());
        email.setText("Email :"+buyerArrayList.get(i).getEmail());
        phone.setText("Phone No :"+buyerArrayList.get(i).getPhoneno());
        address.setText("Address :"+buyerArrayList.get(i).getAddress());


        return convertView;
    }
}
