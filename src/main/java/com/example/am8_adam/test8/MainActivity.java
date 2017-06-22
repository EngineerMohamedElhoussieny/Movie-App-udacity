package com.example.am8_adam.test8;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String Url="http://api.themoviedb.org/3/movie/popular?api_key=56536955eb801e9c1dda9c04497ea5a5";
    List<movie> listItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    boolean mTwoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout flPanel2 = (FrameLayout) findViewById(R.id.flPanel_Two);
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", "DEFAULT");
        bundle.putString("DESCRIPTION", "DEFAULT");
        bundle.putString("DATE", "DEFAULT");
        bundle.putString("RATING", "DEFAULT");
        bundle.putString("POSTER", "DEFAULT");
        bundle.putString("ID", "DEFAULT");
        bundle.putString("Type", "DEFAULT");
        if (null == flPanel2) {
            mTwoPane = false;
        } else {
            mTwoPane = true;
        }

        if (null == savedInstanceState) {
            MoviesFragment listFragment = new MoviesFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.flPanel_One, listFragment).commit();
        }

        //Case Two Pane UI
        if (mTwoPane) {
            DetailsFragment detailsFragment= new DetailsFragment();
            detailsFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.flPanel_Two,detailsFragment).commit();
        } else {
            //Case Single Pane UI
            Intent i = new Intent(this, detail_activity.class);
            startActivity(i);
        }
    }









}
