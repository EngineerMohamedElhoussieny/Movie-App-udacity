package com.example.am8_adam.test8;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.squareup.picasso.Picasso;

/**
 * Created by Moh Pele on 30/04/2017.
 */

public class detail_activity extends AppCompatActivity {
    View fragment;
TextView head,desc,relasedata,vote;
    ImageView image;
    private Context activity;
    private static String ImageLink ="http://image.tmdb.org/t/p/w185" ;
    private DatabaseHelper favoriteDbHelper;
    private movie favorite;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.details_activity);

        Bundle bundle = getIntent().getExtras();



        DetailsFragment dFragment = new DetailsFragment();
        dFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.detailsLayout, dFragment, "Movie")
                .commit();


    }
}