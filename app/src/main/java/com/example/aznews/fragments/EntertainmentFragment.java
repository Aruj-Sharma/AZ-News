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

public class EntertainmentFragment extends Fragment {

    private String API_KEY = "b8b9efef7aef450594d58dc3c26ade07";
    ArrayList<Article> newsArrayList;
    Adapter adapter;
    String country = "in";

    private RecyclerView recyclerViewEntertainment;
    private String category = "entertainment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entertainment, container, false);
        recyclerViewEntertainment = view.findViewById(R.id.recyclerviewEntertainment);
        newsArrayList = new ArrayList<>();
        recyclerViewEntertainment.setLayoutManager( new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), newsArrayList);
        recyclerViewEntertainment.setAdapter(adapter);

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