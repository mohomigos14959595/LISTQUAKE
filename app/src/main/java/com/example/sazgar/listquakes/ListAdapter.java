package com.example.sazgar.listquakes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

/**
 *
 */

public class ListAdapter extends ArrayAdapter<Event> {
    public ListAdapter(Context context, List<Event> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view==null){
            view=LayoutInflater.from(getContext()).inflate(R.layout.quake_item,parent,false);
        }
        Event event=getItem(position);
        TextView magTextView=(TextView)view.findViewById(R.id.textmag);
        TextView feltTextView=(TextView)view.findViewById(R.id.textfelt);

        magTextView.setText(Double.toString(event.getMag()));
        feltTextView.setText(Integer.toString(event.getFelt()));

        return view;
    }
}
