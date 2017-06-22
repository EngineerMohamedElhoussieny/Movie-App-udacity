package com.example.am8_adam.test8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.squareup.picasso.Picasso;

/**
 * Created by Am8_Adam on 6/13/2017.
 */

public class DetailsFragment extends Fragment {


    View fragment;
    TextView head,desc,relasedata,vote;
    ImageView image;
    private Context activity;
    private static String ImageLink ="http://image.tmdb.org/t/p/w185" ;
    private DatabaseHelper favoriteDbHelper;
    private movie favorite;
    private Context application;
    String Title,Description,Date,Rating,Poster,id,type ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment =  inflater.inflate(R.layout.single_list_item,container,false) ;

        return fragment ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        relasedata = (TextView) getView().findViewById(R.id.textView3);
        head = (TextView) getView().findViewById(R.id.head);
        desc = (TextView) getView().findViewById(R.id.textView);
        image = (ImageView) getView().findViewById(R.id.imageview3);
        vote = (TextView) getView().findViewById(R.id.textView5);


          final Bundle bundle = getArguments();
        desc.setText(bundle.getString("title"));
        head.setText(bundle.getString("desc"));
        relasedata.setText(bundle.getString("release_date"));
        vote.setText(bundle.getString("vote_average"));
        Picasso.with(getActivity()).load(ImageLink + bundle.getString("iamge")).into(image);
        Toast.makeText(getApplication(), bundle.getString("id") + bundle.getString("release_date"), Toast.LENGTH_LONG).show();



        Title = bundle.getString("desc");
        Description = bundle.getString("title");
        Date = bundle.getString("release_date");
        Rating = bundle.getString("vote_average");
        Poster = bundle.getString("iamge");
        id = bundle.getString("id");
        MaterialFavoriteButton materialFavoriteButtonNice =
                (MaterialFavoriteButton) getView().findViewById(R.id.favorite_button);
        materialFavoriteButtonNice.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if (favorite){

                            saveFavorite();
                        }
                        else{
                            //int movie_id = bundle.getInt("id");
                            int movie_id =bundle.getInt("id");
                            favoriteDbHelper = new DatabaseHelper(getActivity());
                            favoriteDbHelper.deleteFavorite(movie_id);
                        }}}
        );


    }
    public void saveFavorite(){
        favoriteDbHelper = new DatabaseHelper(getActivity());
        //SQLiteDatabase db = favoriteDbHelper.getWritableDatabase();
        String movie_id = id;
        String rate = Rating;
        String title =Title;
        String desc = Description;
        String iamge = Poster;
        String release_date = Date;

        //Toast.makeText(getApplication(), rate+title+desc+iamge+release_date , Toast.LENGTH_LONG).show();


        favorite = new movie(movie_id,desc,title,iamge,rate,release_date);
        long id=favoriteDbHelper.addFavorite(favorite);
        if(id>0)
        {
            Toast.makeText(getApplication(), "inster success", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(getApplication(), "inster unsuccess", Toast.LENGTH_LONG).show();

        }
    }


    public Context getApplication() {
        return application;
    }
}














