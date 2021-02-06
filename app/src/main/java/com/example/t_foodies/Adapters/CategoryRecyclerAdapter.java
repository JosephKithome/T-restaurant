package com.example.t_foodies.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t_foodies.Models.CategoryContent;
import com.example.t_foodies.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryContentViewHolder> {
    private List<CategoryContent> categoryContentArrayList;
    private Context context;

    public CategoryRecyclerAdapter(Context context, List<CategoryContent> categoryContentList) {
        this.context = context;
        this.categoryContentArrayList = categoryContentList;
    }

    @NonNull
    @Override
    public CategoryContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_offers,parent,false);
        return new CategoryContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryContentViewHolder holder, int position) {
        holder.imageView.setImageResource(categoryContentArrayList.get(position).getImageUrl());


    }

    @Override
    public int getItemCount() {
        return categoryContentArrayList.size();
    }

    public class CategoryContentViewHolder extends RecyclerView.ViewHolder{
        public TextView txtName, txtOffer, txtPrice;
        public ShapeableImageView imageView;
        public CategoryContentViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.name);
            txtOffer = itemView.findViewById(R.id.offer);
            txtPrice = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
