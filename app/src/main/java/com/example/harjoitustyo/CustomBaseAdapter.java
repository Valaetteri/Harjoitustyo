package com.example.harjoitustyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    // here we create the list for ReviewList_Activity

    Context context;
    ArrayList<String> titleList;
    ArrayList<String> starList;
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, ArrayList<String> titleList, ArrayList<String> starList){
        this.context = ctx;
        this.titleList = titleList;
        this.starList = starList;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        // we create listing based on the length of the titleList. We add the elements from the
        // title- and starList one by one
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(titleList.get(i));
        TextView textViewRating = (TextView) convertView.findViewById(R.id.textViewRatingID);
        textViewRating.setText(starList.get(i));

        return convertView;
    }
}
