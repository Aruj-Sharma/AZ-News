package com.example.aznews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aznews.Model.Article;
import com.example.aznews.R;
import com.example.aznews.Activities.NewsWebView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Article> newsArrayList;


    public Adapter(Context context, ArrayList<Article> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int pos = position;

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, NewsWebView.class);
                intent.putExtra("url", newsArrayList.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(intent);


            }
        });

        holder.time.setText("Published At:- " + newsArrayList.get(position).getPublishedAt());
        holder.author.setText(newsArrayList.get(position).getAuthor());
        holder.heading.setText(newsArrayList.get(position).getTitle());
        holder.content.setText(newsArrayList.get(position).getDescription());

        Glide.with(context).load(newsArrayList.get(position).getUrlToImage()).into(holder.imageView);




    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading, content, author, time;
        CardView cardView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.mainHeading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }
}
