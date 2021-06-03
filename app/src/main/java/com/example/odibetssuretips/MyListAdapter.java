package com.example.odibetssuretips;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;



public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    private Context context;
    private List<MyListData> list;

    public MyListAdapter(Context context, List<MyListData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_march_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyListData myListData = list.get(position);

        holder.time.setText(myListData.getTime());
        holder.matchOne.setText(myListData.getHome_team());
        holder.matchTwo.setText(myListData.getAway_team());
        holder.tips.setText(myListData.getPrediction());
        holder.odds.setText(myListData.getOdds());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView time;
        public TextView matchOne;
        public TextView matchTwo;
        public TextView scoreOne;
        public TextView scoreTwo;
        public TextView tips;
        public TextView odds;

        public ViewHolder(View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.time);
            matchOne = itemView.findViewById(R.id.matchOne);
            matchTwo = itemView.findViewById(R.id.matchTwo);
            scoreOne = itemView.findViewById(R.id.scoreOne);
            scoreTwo = itemView.findViewById(R.id.scoreTwo);
            tips = itemView.findViewById(R.id.tips);
            odds = itemView.findViewById(R.id.odds);
        }
    }
}



/*
public class  MyListAdapter extends RecyclerView.Adapter< MyListAdapter.ViewHolder> {

    private Context context;
    private List<MyListData> list;

    public MyListAdapter(Context context, List<MyListData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_march_item, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MyListData myListData= list.get(position);
        holder.time.setText(myListData.getTime());
        holder.matchOne.setText(myListData.getHome_team());
        holder.matchTwo.setText(myListData.getAway_team());
        holder.tips.setText(myListData.getPrediction());
        holder.odds.setText(myListData.getOdds());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView time;
        public TextView matchOne;
        public TextView matchTwo;
        public TextView scoreOne;
        public TextView scoreTwo;
        public TextView tips;
        public TextView odds;


        public ViewHolder(View itemView) {
            super(itemView);
           time = itemView.findViewById(R.id.time);
           matchOne = itemView.findViewById(R.id.matchOne);
           matchTwo= itemView.findViewById(R.id.matchTwo);
           scoreOne= itemView.findViewById(R.id.scoreOne);
           scoreTwo = itemView.findViewById(R.id.scoreTwo);
           tips= itemView.findViewById(R.id.tips);
           odds= itemView.findViewById(R.id.odds);

        }
    }

}

 */













//public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
//    private MyListData[] listdata;
//
//    // RecyclerView recyclerView;
//    public MyListAdapter(MyListData[] listdata) {
//        this.listdata = listdata;
//    }

//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View listItem= layoutInflater.inflate(R.layout.custom_march_item, parent, false);
//        ViewHolder viewHolder = new ViewHolder(listItem);
//        return viewHolder;
//    }


//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//    }

//    @Override
//    public int getItemCount() {
//        return listdata.length;
//    }

//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView time;
//        public TextView border;
//        public TextView matchOne;
//        public TextView matchTwo;
//        public TextView scoreOne;
//        public TextView scoreTwo;
//        public TextView border1;
//        public TextView tips;
//        public TextView border2;
//        public TextView odds;
//        public RelativeLayout relativeLayout;
//        public TextView textView;

//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            this.time = (TextView) itemView.findViewById(R.id.time);
//            this.border = (TextView) itemView.findViewById(R.id.border);
//            this.matchOne= (TextView) itemView.findViewById(R.id.matchOne);
//            this.matchTwo = (TextView) itemView.findViewById(R.id.matchTwo);
//            this.scoreOne = (TextView) itemView.findViewById(R.id.scoreOne);
//            this.scoreTwo = (TextView) itemView.findViewById(R.id.scoreTwo);
//            this.border1 = (TextView) itemView.findViewById(R.id.border1);
//            this.tips = (TextView) itemView.findViewById(R.id.tips);
//            this.border2 = (TextView) itemView.findViewById(R.id.border2);
//            this.odds = (TextView) itemView.findViewById(R.id.odds);
//            LinearLayoutCompat linearLayoutcompat = (LinearLayoutCompat) itemView.findViewById(R.id.linearLayout);
//        }
//    }
//}







