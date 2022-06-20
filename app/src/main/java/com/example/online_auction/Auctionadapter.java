package com.example.online_auction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Auctionadapter extends BaseAdapter {

    private Context context;
    private ArrayList<Auction> auctionArrayList;
    public Auctionadapter(Context context, ArrayList<Auction> auctionArrayList) {
        this.context = context;
        this.auctionArrayList = auctionArrayList;
    }

    @Override
    public int getCount() {
        return auctionArrayList.size();
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
        view = LayoutInflater.from(context).inflate(R.layout.auctionlist_recycle, viewGroup, false);

        TextView auction_name = view.findViewById(R.id.auctionnametext);
        TextView auction_description = view.findViewById(R.id.descriptiontext);
        TextView host_name = view.findViewById(R.id.hostauctiontext);




        auction_name.setText(auctionArrayList.get(i).getAuction_name());
        auction_description.setText(auctionArrayList.get(i).getDescription());
        host_name.setText(auctionArrayList.get(i).getHostname());


        return view;
    }
}
