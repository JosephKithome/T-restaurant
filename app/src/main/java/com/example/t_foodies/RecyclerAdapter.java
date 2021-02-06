package com.example.t_foodies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Foods> foodsArrayList = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(Context context, List<Foods> foodsList) {
        this.context = context;
        this.foodsArrayList = foodsList;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext())
                .inflate(R.layout.activity_offers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Foods foods = foodsArrayList.get(position);
        holder.bind(foods);

    }

    @Override
    public int getItemCount() {
        return foodsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName, txtOffer, txtPrice;
        public ShapeableImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.name);
            txtOffer = itemView.findViewById(R.id.offer);
            txtPrice = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.image);
        }

        public void bind(Foods foods) {
            txtName.setText(foods.getTitle());
            txtPrice.setText(foods.getPrice());
            showImage(foods.getImageUrl());


        }

        private void showImage(String url) {
            if (url != null && url.isEmpty() == false) {
                Picasso.get()
                        .load(url)
                        .resize(160, 160)
                        .centerCrop()
                        .into(imageView);
            }
        }

    }
}
