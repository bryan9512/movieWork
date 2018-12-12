package org.bryan95.taekyulee;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView moviename;
        ImageView rating;
        TextView year;
        TextView director;
        TextView actor;

        MyViewHolder(View view){
            super(view);
            poster = view.findViewById(R.id.poster);
            moviename = view.findViewById(R.id.moviename);
            rating=view.findViewById(R.id.rating);
            year=view.findViewById(R.id.year);
            director=view.findViewById(R.id.director);
            actor=view.findViewById(R.id.actor);
        }
    }

    private ArrayList<FoodInfo> foodInfoArrayList;
    MyAdapter(ArrayList<FoodInfo> foodInfoArrayList){
        this.foodInfoArrayList = foodInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

       // myViewHolder.poster.setImageURI(foodInfoArrayList.get(position).Movieposter);
        myViewHolder.moviename.setText(foodInfoArrayList.get(position).MovieName);
        //myViewHolder.rating.setImageURI(foodInfoArrayList.get(position).userrating);
        //myViewHolder.year.setText(foodInfoArrayList.get(position).pubdate);
        myViewHolder.director.setText(foodInfoArrayList.get(position).director);
        myViewHolder.actor.setText(foodInfoArrayList.get(position).actor);

    }

    @Override
    public int getItemCount() {

        return foodInfoArrayList.size();
    }
}
