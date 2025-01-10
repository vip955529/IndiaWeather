package com.vyzasolutions.indiaweather;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vyzasolutions.indiaweather.adapters.NewsAdapter;
import com.vyzasolutions.indiaweather.models.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private RecyclerView rvNews;
    private NewsAdapter adapter;
    private static final String API_KEY = "R0YnsvGAXft8HdVQ6ks9qnzewlTSjUTV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvNews = findViewById(R.id.rvNews);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsAdapter(this);
        rvNews.setAdapter(adapter);

        setupViews();
        loadDummyData(); // For testing layout
    }
    private void setupViews() {
        rvNews = findViewById(R.id.rvNews);
        adapter = new NewsAdapter(this);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        rvNews.setAdapter(adapter);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }

    private void loadDummyData() {
        List<NewsModel> dummyNews = new ArrayList<>();
        // Add dummy data
        adapter.setNewsList(dummyNews);
    }
}