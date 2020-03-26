package com.example.infs3634app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.NumberFormat;


public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Restaurants mRest;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mRest = Restaurants.getRestaurant(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(mRest.getName());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_detail, container, false);


        if (mRest != null) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            ((TextView) rootView.findViewById(R.id.tvRestName)).setText(mRest.getName());
            //change this
            ((TextView) rootView.findViewById(R.id.tvMyRating)).setText(String.valueOf(mRest.getMyRating()));
            //
            ((RatingBar) rootView.findViewById(R.id.ratingBar2)).setRating(mRest.getMyRating());
            ((TextView) rootView.findViewById(R.id.tvACField)).setText(String.valueOf("$" +mRest.getAverageCost()));
            ((TextView) rootView.findViewById(R.id.tvLocationField)).setText(mRest.getLocation());
            ((TextView) rootView.findViewById(R.id.tvAddressField)).setText(mRest.getAddress());
            ((TextView) rootView.findViewById(R.id.tvCusineField)).setText(mRest.getCuisine());
            ((TextView) rootView.findViewById(R.id.tvARField)).setText(String.valueOf(mRest.getAverageRating()));
            ((Button) rootView.findViewById(R.id.ChangeReviewButton)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //change the myRating on the front end
                    System.out.println(((RatingBar) rootView.findViewById(R.id.changeRating)).getRating());

                    ((TextView) rootView.findViewById(R.id.tvMyRating)).setText(String.valueOf(((RatingBar) rootView.findViewById(R.id.changeRating)).getRating()));
                    ((RatingBar) rootView.findViewById(R.id.ratingBar2)).setRating(((RatingBar) rootView.findViewById(R.id.changeRating)).getRating());

                }
            });
            ((ImageView) rootView.findViewById(R.id.ivSearch)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchRestaurant(mRest.getName());
                }
            });
        }

        // Inflate the layout for this fragment
        return rootView;
    }

    private void searchRestaurant(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }


}
