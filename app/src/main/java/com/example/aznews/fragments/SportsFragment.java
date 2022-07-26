package com.example.aznews.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aznews.Adapter.Adapter;
import com.example.aznews.Model.Article;
import com.example.aznews.Model.News;
import com.example.aznews.R;
import com.example.aznews.Retrofit.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SportsFragment extends Fragment {

    private String API_KEY = "b8b9efef7aef450594d58dc3c26ade07";
    ArrayList<Article> newsArrayList;
    Adapter adapter;
    String country = "in";

    private RecyclerView recyclerViewSports;
    private String category = "sports";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sports, container, false);
        recyclerViewSports = view.findViewById(R.id.recyclerviewSports);
        newsArrayList = new ArrayList<>();
        recyclerViewSports.setLayoutManager( new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), newsArrayList);
        recyclerViewSports.setAdapter(adapter);

        findNews();


        return view;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country, category, 100, API_KEY).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsArrayList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
}