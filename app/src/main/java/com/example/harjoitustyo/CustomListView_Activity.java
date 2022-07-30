package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CustomListView_Activity extends AppCompatActivity {
    // custom listview to display title and reviews nicely in ReviewList-Activity class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
    }
}