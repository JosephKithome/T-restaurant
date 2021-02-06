package com.example.t_foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t_foodies.Adapters.MainAdapter;
import com.example.t_foodies.Models.AllCategories;
import com.example.t_foodies.Models.CategoryContent;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private ImageView imageView,imageSort;
    private MaterialCardView materialCardView;
    private TextView textNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.search);
        imageSort=findViewById(R.id.sort);
        materialCardView=findViewById(R.id.materialCardView);
        textNav =findViewById(R.id.nav);

        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,ActivityDetails.class);
            startActivity(intent);
        });
        imageSort.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,ActivityDetails.class);
            startActivity(intent);
        });
        materialCardView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,ActivityDetails.class);
            startActivity(intent);
        });
        textNav.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,ActivityDetails.class);
            startActivity(intent);
        });




        recyclerView =findViewById(R.id.recycler);
        List<CategoryContent> categoryContents = new ArrayList<>();
        categoryContents.add(new CategoryContent(1,R.drawable.food1));
        categoryContents.add(new CategoryContent(2,R.drawable.food2));
        categoryContents.add(new CategoryContent(3,R.drawable.food3));
        categoryContents.add(new CategoryContent(4,R.drawable.food4));
        categoryContents.add(new CategoryContent(5,R.drawable.food5));

        List<CategoryContent> categoryContent2 = new ArrayList<>();
        categoryContent2.add(new CategoryContent(1,R.drawable.hotel1));
        categoryContent2.add(new CategoryContent(2,R.drawable.hotel2));
        categoryContent2.add(new CategoryContent(3,R.drawable.hotel3));
        categoryContent2.add(new CategoryContent(4,R.drawable.hotel4));
        categoryContent2.add(new CategoryContent(5,R.drawable.hotel5));

        List<CategoryContent> categoryContent3 = new ArrayList<>();
        categoryContent3.add(new CategoryContent(1,R.drawable.fruit1));
        categoryContent3.add(new CategoryContent(2,R.drawable.fruit2));
        categoryContent3.add(new CategoryContent(3,R.drawable.fruit3));
        categoryContent3.add(new CategoryContent(4,R.drawable.fruit4));
        categoryContent3.add(new CategoryContent(5,R.drawable.fruit5));


        List<AllCategories> allCategoriesList = new ArrayList<>();
        allCategoriesList.add(new AllCategories("Today's best offer",categoryContents));
        allCategoriesList.add(new AllCategories("Restaurants &amp; Bars near me",categoryContent2));
        allCategoriesList.add(new AllCategories("Most Popular",categoryContent3));

        setMainCategoryRecycler(allCategoriesList);



    }
public  void setMainCategoryRecycler(List<AllCategories> allCategoriesList ){

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this,allCategoriesList);
        recyclerView.setAdapter(adapter);

}

}