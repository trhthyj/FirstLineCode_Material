package com.mi.www.material.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.CardView;

import com.bumptech.glide.Glide;
import com.mi.www.material.FruitActivity;
import com.mi.www.material.R;
import com.mi.www.material.bean.Fruit;

import java.util.List;

/**
 * Created by wm on 2017/12/1.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{
    private List<Fruit> mList;
    private Context mContext;

    public FruitAdapter(List<Fruit> list) {
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if(mContext == null){
           mContext = parent.getContext();
       }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fruit,parent,false);
       final ViewHolder holder =new ViewHolder(view);
       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int position = holder.getAdapterPosition();
               Fruit fruit = mList.get(position);
               FruitActivity.actionStart(mContext,fruit.getFuitId(),fruit.getFruitName());
           }
       });
       return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mList.get(position);
        holder.fruitName.setText(fruit.getFruitName());
        Glide.with(mContext).load(fruit.getFuitId()).into(holder.fruitPicture);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitPicture;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            fruitPicture = itemView.findViewById(R.id.iv_fruit);
            fruitName = itemView.findViewById(R.id.tv_fruit_name);
        }
    }
}
