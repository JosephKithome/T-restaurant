package com.example.t_foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.t_foodies.Adapters.MainAdapter;
import com.example.t_foodies.Models.AllCategories;
import com.example.t_foodies.Models.CategoryContent;

import java.util.ArrayList;
import java.util.List;

public class ActivityDetails extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

    List<CategoryContent> categoryContent3 = new ArrayList<>();
        categoryContent3.add(new CategoryContent(1,R.drawable.fruit1));
        categoryContent3.add(new CategoryContent(2,R.drawable.fruit2));
        categoryContent3.add(new CategoryContent(3,R.drawable.fruit3));
        categoryContent3.add(new CategoryContent(4,R.drawable.fruit4));
        categoryContent3.add(new CategoryContent(5,R.drawable.fruit5));


    List<AllCategories> allCategoriesList = new ArrayList<>();
        allCategoriesList.add(new AllCategories("Most Popular",categoryContent3));

    setMainCategoryRecycler(allCategoriesList);



}
    public  void setMainCategoryRecycler(List<AllCategories> allCategoriesList ){
        recyclerView =findViewById(R.id.recDetails);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this,allCategoriesList);
        recyclerView.setAdapter(adapter);

    }
}