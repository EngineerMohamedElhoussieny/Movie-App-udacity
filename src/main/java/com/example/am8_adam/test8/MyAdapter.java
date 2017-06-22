package com.example.am8_adam.test8;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Moh Pele on 29/04/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<movie> listItems;
    private Context context;
    private static String ImageLink ="http://image.tmdb.org/t/p/w185" ;

    public MyAdapter(List<movie> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        final movie listItem=listItems.get(position);
       // holder.textviewHead.setText(listItem.getHead());
      // holder.textviewdescription.setText(listItem.getDescription());
        Picasso.with(context).load(ImageLink+listItem.getImageUrl()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

      class ViewHolder extends RecyclerView.ViewHolder
    {




        public TextView textviewHead;
        public TextView textviewdescription;
        public ImageView imageView;
        public LinearLayout linearLayout;
        public ViewHolder(final View itemView) {
            super(itemView);

        imageView=(ImageView)itemView.findViewById(R.id.imageview);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.linearlayout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos =getAdapterPosition();
                       Intent intent = new Intent(context, detail_activity.class);
intent.putExtra("title",listItems.get(pos).getDescription());
                    intent.putExtra("desc",listItems.get(pos).getHead());

                    intent.putExtra("iamge",listItems.get(pos).getImageUrl());

                    intent.putExtra("release_date",listItems.get(pos).getRelase_data());
                    intent.putExtra("vote_average",listItems.get(pos).getVote_average());
                    intent.putExtra("id",listItems.get(pos).getId());


                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

}
