package com.example.harjoitustyo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MovieManager {
    // this class main function was planned to be the brains of the movie data handling. Currently
    // it is quite useless since the reading and writing happens in activities and it only passes
    // the reviewlist

    static MovieManager movieManager = null;
    static ArrayList<MovieReview> reviewArrayList = new ArrayList<>();

    public static MovieManager getInstance() {
        if (movieManager == null) {
            movieManager = new MovieManager();
        }
        return movieManager;
    }

    public ArrayList<MovieReview> getReviewArrayList() {
        return reviewArrayList;
    }

    public void setMovieReviewsList(ArrayList<MovieReview> movieReviewArrayList) {
        reviewArrayList = movieReviewArrayList;
    }
}