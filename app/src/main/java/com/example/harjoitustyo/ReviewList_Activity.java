package com.example.harjoitustyo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReviewList_Activity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    ListView listView;
    ArrayList<String> titleList = new ArrayList<>();
    ArrayList<String> starList = new ArrayList<>();
    ArrayList<MovieReview> movieReviewArrayList;
    MovieManager movieManager = MovieManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        // dropdown menu for sorting list
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.sortTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // here we read the list from device into a list. And yes the reading into a list should be
        // done just once, not everytime we open the activity
        movieReviewArrayList = movieManager.getReviewArrayList();
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream(getFilesDir() + "objects.ser"));
            movieReviewArrayList = (ArrayList<MovieReview>) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // Here we sort the reviewlist based on the index of the dropdown menu, and add the correct
        // values in order to title- and starList
        SorterClass.sortReviews(i, movieReviewArrayList, titleList, starList);

        // Here we create the list with new order
        listView = null;
        listView = (ListView) findViewById(R.id.ReviedListViewID);
        CustomBaseAdapter customBaseAdapter =
                new CustomBaseAdapter(getApplicationContext(), titleList, starList);
        listView.setAdapter(customBaseAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}