package com.example.odibetssuretips;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private MyListData[] listdata;

    // RecyclerView recyclerView;
    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_march_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView time;
        public TextView border;
        public TextView matchOne;
        public TextView matchTwo;
        public TextView scoreOne;
        public TextView scoreTwo;
        public TextView border1;
        public TextView tips;
        public TextView border2;
        public TextView odds;
        public RelativeLayout relativeLayout;
        public TextView textView;


        public ViewHolder(View itemView) {
            super(itemView);
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.border = (TextView) itemView.findViewById(R.id.border);
            this.matchOne= (TextView) itemView.findViewById(R.id.matchOne);
            this.matchTwo = (TextView) itemView.findViewById(R.id.matchTwo);
            this.scoreOne = (TextView) itemView.findViewById(R.id.scoreOne);
            this.scoreTwo = (TextView) itemView.findViewById(R.id.scoreTwo);
            this.border1 = (TextView) itemView.findViewById(R.id.border1);
            this.tips = (TextView) itemView.findViewById(R.id.tips);
            this.border2 = (TextView) itemView.findViewById(R.id.border2);
            this.odds = (TextView) itemView.findViewById(R.id.odds);
            LinearLayoutCompat linearLayoutcompat = (LinearLayoutCompat) itemView.findViewById(R.id.linearLayout);
        }
    }
}