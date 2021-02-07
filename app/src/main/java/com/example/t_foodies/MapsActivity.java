package com.example.t_foodies;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.t_foodies.Adapters.MainAdapter;
import com.example.t_foodies.Models.AllCategories;
import com.example.t_foodies.Models.CategoryContent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private RecyclerView recyclerView;
    private MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        List<CategoryContent> categoryContent3 = new ArrayList<>();
        categoryContent3.add(new CategoryContent(1,R.drawable.fruit1));
        categoryContent3.add(new CategoryContent(2,R.drawable.fruit2));
        categoryContent3.add(new CategoryContent(3,R.drawable.fruit3));
        categoryContent3.add(new CategoryContent(4,R.drawable.fruit4));
        categoryContent3.add(new CategoryContent(5,R.drawable.fruit5));

        List<CategoryContent> categoryContents = new ArrayList<>();
        categoryContents.add(new CategoryContent(1,R.drawable.food1));
        categoryContents.add(new CategoryContent(2,R.drawable.food2));
        categoryContents.add(new CategoryContent(3,R.drawable.food3));
        categoryContents.add(new CategoryContent(4,R.drawable.food4));
        categoryContents.add(new CategoryContent(5,R.drawable.food5));


        List<AllCategories> allCategoriesList = new ArrayList<>();
        allCategoriesList.add(new AllCategories("Today's best offer",categoryContents));
        allCategoriesList.add(new AllCategories("Most Popular",categoryContent3));

        setMainCategoryRecycler(allCategoriesList);



    }
    public  void setMainCategoryRecycler(List<AllCategories> allCategoriesList ){
        recyclerView =findViewById(R.id.recDetails);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this,allCategoriesList);
        recyclerView.setAdapter(adapter);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}