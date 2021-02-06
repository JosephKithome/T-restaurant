package com.example.t_foodies.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t_foodies.ActivityDetails;
import com.example.t_foodies.MainActivity;
import com.example.t_foodies.Models.AllCategories;
import com.example.t_foodies.Models.CategoryContent;
import com.example.t_foodies.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CategoryViewHolder> {
    private Context context;
    private List<AllCategories> allCategoriesList;

    public MainAdapter(Context context, List<AllCategories> allCategoriesList) {
        this.context = context;
        this.allCategoriesList = allCategoriesList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_title_item,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position)  {
        holder.catTextTitle.setText(allCategoriesList.get(position).getCategoryTitle());
       setContentRecycler(holder.recyclerView,allCategoriesList.get(position).getCategoryContentList());

    }

    @Override
    public int getItemCount() {
        return allCategoriesList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView catTextTitle;
        private RecyclerView recyclerView;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            catTextTitle =itemView.findViewById(R.id.cat_title);
            recyclerView=itemView.findViewById(R.id.contentRec);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = getAdapterPosition();
                    Context context1=v.getContext();
                    Log.d("Click", String.valueOf(i));
                    //gets the book from the arrayList
                    Intent intent = new Intent(context1, ActivityDetails.class);
                    context.startActivity(intent);

                }
            });

        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            Context context1=v.getContext();
            Log.d("Click", String.valueOf(i));
            //gets the book from the arrayList
            Intent intent = new Intent(context1, ActivityDetails.class);
            context.startActivity(intent);

        }
    }
    private void setContentRecycler(RecyclerView recycler, List<CategoryContent> categoryContentList){
        CategoryRecyclerAdapter categoryRecyclerAdapter = new CategoryRecyclerAdapter(context,categoryContentList);
        recycler.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recycler.setAdapter(categoryRecyclerAdapter);

    }

}
