package com.example.harjoitustyo;

import java.io.Serializable;
import java.sql.Date;

public class MovieReview  implements Serializable {
    // here we make reviews for each movie with attributes below. Title and star rating are only
    // used in current version

    private String title;
    private String starRating;
    private String textReview;
    private String date;

    public MovieReview(String title, String starRating, String textReview, String date) {
        this.title = title;
        this.starRating = starRating;
        this.textReview = textReview;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getStars() {
        return starRating;
    }
}
