package com.mobiverse.launcher.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiverse.launcher.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private SearchManager searchManager;
    private SearchResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchManager = new SearchManager(this);

        EditText searchInput = findViewById(R.id.et_search_input);
        RecyclerView recyclerView = findViewById(R.id.rv_search_results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SearchResultsAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchManager.performSearch(s.toString(), results -> {
                    adapter.updateResults(results);
                });
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}