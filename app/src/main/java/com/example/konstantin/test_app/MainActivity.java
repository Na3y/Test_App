package com.example.konstantin.test_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    private ListView listview;
    private SwipeRefreshLayout swipeContainer;
    private RequestData requestData;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        category = getString(R.string.tech);

        //ToolBar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        requestData = new RequestData(getApplicationContext(), getString(R.string.token));

        //Spinner
        Spinner spinner_title = (Spinner) findViewById(R.id.spinner_nav);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_title.setAdapter(adapter);
        spinner_title.setOnItemSelectedListener(this);

        //SwipeContainer
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Действие во время обновления
                fetchTimelineAsync();
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        //ListView
        listview = (ListView)findViewById(R.id.list_view);
        try {
            listview.setAdapter(requestData.getAdapter(category));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        listview.setOnItemClickListener(this);

    }

    public void fetchTimelineAsync() {
        try {
            listview.setAdapter(requestData.getAdapter(category));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        swipeContainer.setRefreshing(false);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Запрос на загрузку данных по выбранной теме
        category = getResources().getStringArray(R.array.category)[position].toLowerCase();
        try {
            listview.setAdapter(requestData.getAdapter(category));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, InfoActyvity.class);
        intent.putExtra("post_id",requestData.getItems().get(position).getId_post());
        startActivity(intent);
    }
}
