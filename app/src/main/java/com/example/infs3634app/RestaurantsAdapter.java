package com.example.infs3634app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.text.NumberFormat;
import java.util.ArrayList;


public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.RestaurantViewHolder> {
    private MainActivity mParentActivity;
    private ArrayList<Restaurants> mRestaurants;
    private boolean mTwoPane;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Restaurants rest = (Restaurants) v.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(DetailFragment.ARG_ITEM_ID, rest.getName());
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
            }
            else {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailFragment.ARG_ITEM_ID, rest.getName());
                context.startActivity(intent);
            }
        }
    };


    public RestaurantsAdapter(MainActivity parent, ArrayList<Restaurants> restaurants, boolean twoPane) {
        mParentActivity = parent;
        mRestaurants = restaurants;
        mTwoPane = twoPane;
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public TextView name, cuisine, location, rating;

        public RestaurantViewHolder (View v) {
            super(v);
            name = v.findViewById(R.id.restName);
            cuisine = v.findViewById(R.id.restCusine);
            location = v.findViewById(R.id.restLocation);
            rating = v.findViewById(R.id.restRating);
        }
    }

    @Override
    public RestaurantsAdapter.RestaurantViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_rows, parent, false);
        return new RestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        Restaurants rest = mRestaurants.get(position);
        holder.name.setText(rest.getName());
        holder.cuisine.setText(rest.getCuisine());
        holder.location.setText(rest.getLocation());
        holder.rating.setText(NumberFormat.getCurrencyInstance().format(rest.getMyRating()));
        holder.itemView.setTag(rest);
        holder.itemView.setOnClickListener(mOnClickListener);


    }

    @Override
    public int getItemCount() {return mRestaurants.size();}
}
