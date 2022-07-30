package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieManager movieManager;
    private MovieDataLoader movieDataLoader;
    private static ArrayList<String> currentMovieNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieManager = MovieManager.getInstance();
        movieDataLoader = MovieDataLoader.getInstance();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // we load the current movies from Finnkino with movieDataLoader into ArrayList<String>
        currentMovieNames = movieDataLoader.getCurrentMovieNames(currentMovieNames);

        // we make list out of current movies found
        ListView listView = findViewById(R.id.listViewID);
        ArrayAdapter arrayAdapter = new ArrayAdapter
                (getApplicationContext(), android.R.layout.simple_list_item_1, currentMovieNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // on click we open MovieReviewWindow where user can review the movie
                String movieTitle = currentMovieNames.get(i);
                Intent intent = new Intent(MainActivity.this,
                        MovieReviewWindow_Activity.class);
                intent.putExtra("MOVIETITLE", movieTitle);
                startActivity(intent);
            }
        });
    }

    public void openReviewedMovies(View view){
        // this opens a new activity where user can browse movies
        Intent intent = new Intent(MainActivity.this, ReviewList_Activity.class);
        startActivity(intent);
    }
}