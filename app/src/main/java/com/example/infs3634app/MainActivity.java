package com.example.infs3634app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Restaurants> items = Restaurants.getRestaurants();
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (findViewById(R.id.detail_container) != null)    {
            mTwoPane = true;
        }



        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        final RecyclerView.Adapter mAdapter = new RestaurantsAdapter(this, Restaurants.getRestaurants(), mTwoPane);
        mRecyclerView.setAdapter(mAdapter);

        //creating filters by location,cuisine,rating and name
        Button locationButton = (Button) findViewById(R.id.checkBoxLocation);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(items, Restaurants.ByLocation);
                mAdapter.notifyDataSetChanged();
                System.out.println(mAdapter);
            }
        });

        Button ratingButton = (Button) findViewById(R.id.checkBoxRating);
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(items, Restaurants.ByRating);
                mAdapter.notifyDataSetChanged();
                System.out.println(mAdapter);

            }
        });

        Button cuisineButton = (Button) findViewById(R.id.checkBoxCuisine);
        cuisineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(items, Restaurants.ByCuisine);
                mAdapter.notifyDataSetChanged();
                System.out.println(mAdapter);

            }
        });

        Button nameButton = (Button) findViewById(R.id.checkBoxName);
        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("start");
                Collections.sort(items, Restaurants.ByName);
                mAdapter.notifyDataSetChanged();
                System.out.println(mAdapter);
                System.out.println(items);
                System.out.println("finish");
                mRecyclerView.setAdapter(mAdapter);

            }
        });

        //creating a search filter on the main activity
        SearchView searchView = (SearchView) findViewById(R.id.search_function);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((RestaurantsAdapter) mAdapter).getFilter().filter(newText);
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }



}
