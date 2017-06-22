package com.example.am8_adam.test8;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * Created by Am8_Adam on 6/13/2017.
 */

public class MoviesFragment extends android.support.v4.app.Fragment {

    MyAdapter adapter;
    List<movie> moviesList;
    private static String Url = "http://api.themoviedb.org/3/movie/top_rated?api_key=56536955eb801e9c1dda9c04497ea5a5";

    private final static String MDB_RESULTS = "results";
    private final static String MDB_POSTER_PATH = "poster_path";
    private final static String MDB_TITLE = "title";
    private final static String MDB_OVERVIEW = "overview";
    private final static String MDB_RELEASE_DATE = "release_date";
    private final static String MDB_RATING = "vote_average";
    private static String ImageLink = "http://image.tmdb.org/t/p/w185";
    private MainActivity nameListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moviesList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movie_fragment, container, false);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onStart() {

        loadRecycleviewData();
    }

    public void loadRecycleviewData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("loading data....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url
                , new Response.Listener<String>() {
            private Context applicationContext;

            public Context getApplicationContext() {
                return applicationContext;
            }

            @Override
            public void onResponse(String response) {
                adapter = new MyAdapter(moviesList, getApplicationContext());
                //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));


                RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
                recyclerView.hasFixedSize();
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject o = jsonArray.getJSONObject(i);
                        movie item = new movie(
                                o.getString("id"),
                                o.getString("title"),
                                o.getString("overview"),
                                o.getString("poster_path"), o.getString("release_date"), o.getString("vote_average")
                        );
                        moviesList.add(item);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

}


