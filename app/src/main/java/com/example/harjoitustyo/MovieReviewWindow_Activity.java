package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MovieReviewWindow_Activity extends AppCompatActivity {

    TextView movieTitle;
    RatingBar ratingBar;
    EditText textReview;
    String movieTitleString;
    ArrayList<MovieReview> reviewArrayList;
    MovieManager movieManager = MovieManager.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        movieTitle = findViewById(R.id.movieTitleID);

        // here we get the movie title for review
        movieTitleString = getIntent().getStringExtra("MOVIETITLE");
        movieTitle.setText(movieTitleString);

        ratingBar = findViewById(R.id.ratingBarID);
        textReview = findViewById(R.id.textReviewID);

    }

    public void saveReview (View view) {

        //here we make all the variables needed for review to strings
        String starRating = String.valueOf(ratingBar.getRating());
        String textRating = String.valueOf(textReview.getText());
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String dateString = date.toString();


        // we read the latest reviewList first so we can add to it
        reviewArrayList = movieManager.getReviewArrayList();
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream(getFilesDir() + "objects.ser"));
            reviewArrayList = (ArrayList<MovieReview>) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // we add the review to list
        MovieReview movieReview = new MovieReview
                (movieTitleString, starRating, textRating, dateString);
        reviewArrayList.add(movieReview);
        movieManager.setMovieReviewsList(reviewArrayList);

        // here we write the updated list
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream
                    (getFilesDir() + "objects.ser"));
            out.writeObject(reviewArrayList);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Toast toast = Toast.makeText(getApplicationContext(),
                "Review saved", Toast.LENGTH_SHORT);
        toast.show();

        // back to MainActivity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);


    }

}