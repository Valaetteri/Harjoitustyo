package com.example.harjoitustyo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SorterClass {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void sortReviews(int i, ArrayList<MovieReview> movieReviewArrayList,
                                   ArrayList<String> titleList, ArrayList<String> starList) {
        // Here we sort the reviewlist and sort the title- and starList based on the new order
        titleList.clear();
        starList.clear();

        if (i == 0) {
            Collections.sort(movieReviewArrayList, Comparator.comparing(MovieReview::getTitle));
            for (int movie = 0; movie < movieReviewArrayList.size(); movie++) {
                titleList.add(movieReviewArrayList.get(movie).getTitle());
                starList.add(movieReviewArrayList.get(movie).getStars());
            }
        }
        if (i == 1) {
            Collections.sort(movieReviewArrayList,
                    Comparator.comparing(MovieReview::getTitle).reversed());
            for (int movie = 0; movie < movieReviewArrayList.size(); movie++) {
                titleList.add(movieReviewArrayList.get(movie).getTitle());
                starList.add(movieReviewArrayList.get(movie).getStars());
            }
        }
        if (i == 2) {
            Collections.sort(movieReviewArrayList, Comparator.comparing(MovieReview::getStars));
            for (int movie = 0; movie < movieReviewArrayList.size(); movie++) {
                titleList.add(movieReviewArrayList.get(movie).getTitle());
                starList.add(movieReviewArrayList.get(movie).getStars());
            }
        }        if (i == 3) {
            Collections.sort(movieReviewArrayList,
                    Comparator.comparing(MovieReview::getStars).reversed());
            for (int movie = 0; movie < movieReviewArrayList.size(); movie++) {
                titleList.add(movieReviewArrayList.get(movie).getTitle());
                starList.add(movieReviewArrayList.get(movie).getStars());
            }
        }
    }
}
