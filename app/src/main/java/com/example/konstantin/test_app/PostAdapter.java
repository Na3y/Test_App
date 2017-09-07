package com.example.konstantin.test_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class PostAdapter extends ArrayAdapter<Item> {

    private final Context context;
    private final ArrayList<Item> itemsArrayList;

    public PostAdapter(Context context, ArrayList<Item> itemsArrayList) {

        super(context, R.layout.custom_item, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.custom_item, parent, false);

        // 3. Get the two text view from the rowView
        TextView nameView = (TextView) rowView.findViewById(R.id.name);
        TextView descrView = (TextView) rowView.findViewById(R.id.descr);
        TextView upvotesView = (TextView) rowView.findViewById(R.id.upvotes);
        ImageView iconView = (ImageView) rowView.findViewById(R.id.icon);

        // 4. Set the text for textView
        nameView.setText(itemsArrayList.get(position).getName());
        descrView.setText(itemsArrayList.get(position).getDescription());
        upvotesView.setText(itemsArrayList.get(position).getUpvote());
        Picasso.with(context).load(itemsArrayList.get(position).getImageurl()).into(iconView);

        // 5. retrn rowView
        return rowView;
    }

}
