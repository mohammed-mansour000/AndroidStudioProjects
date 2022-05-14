package com.example.practice_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyCatViewHolder> {

    ArrayList<Cat> cats;

    public Adapter(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    @NonNull
    @Override
    public MyCatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {   //implemented method

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item,null,false);
        MyCatViewHolder viewHolder = new MyCatViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCatViewHolder holder, int position) {    //implemented method
        Cat c = cats.get(position);
        holder.iv_image.setImageResource(c.getImg());
        holder.tv_name.setText(c.getName());
    }

    @Override
    public int getItemCount() {     //implemented method
        return cats.size();
    }

    //holder class for recyclerview
class MyCatViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        ImageView iv_image;

    public MyCatViewHolder(@NonNull View itemView) {
        super(itemView);

        tv_name = itemView.findViewById(R.id.text1);
        iv_image = itemView.findViewById(R.id.img1);
    }
}
}
