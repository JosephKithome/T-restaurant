package com.example.t_foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private DatabaseReference mDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private List<Foods> foodsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
//        initFrag();
//        hotels();
    }
    private void initView() {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mDatabase = mFirebaseInstance.getReference("accessories");
        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        DividerItemDecoration  mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(mDividerItemDecoration);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                foodsArrayList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Foods foods = dataSnapshot1.getValue(Foods.class);
                    foodsArrayList.add(foods);
                }
                adapter = new RecyclerAdapter(MainActivity.this, foodsArrayList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
//    private void hotels() {
//
//        RecyclerView hotels = findViewById(R.id.hotelRec);
//        mFirebaseInstance = FirebaseDatabase.getInstance();
//        mDatabase = mFirebaseInstance.getReference("accessories");
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
//        DividerItemDecoration  mDividerItemDecoration = new DividerItemDecoration(hotels.getContext(),
//                linearLayoutManager.getOrientation());
//        hotels.addItemDecoration(mDividerItemDecoration);
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                foodsArrayList.clear();
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    Foods foods = dataSnapshot1.getValue(Foods.class);
//                    foodsArrayList.add(foods);
//                }
//                adapter = new RecyclerAdapter(MainActivity.this, foodsArrayList);
//                hotels.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
//    private  void initFrag(){
//        Hotels homeFragment = new Hotels();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.main_content_frame,homeFragment,getString(R.string.home_tag));
//        transaction.addToBackStack(getString(R.string.home_tag));
//        transaction.commit();
//
//    }

}