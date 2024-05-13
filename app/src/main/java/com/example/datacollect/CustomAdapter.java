package com.example.datacollect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    String[] countryNames;
    int[] flags;
    Context context;
    String[] countryDetails;
    LayoutInflater layoutInflater;

    CustomAdapter(Context context, String[] countryNames, int[] flags, String[] countryDetails){
        this.context = context;
        this.countryNames = countryNames;
        this.flags = flags;
        this.countryDetails = countryDetails;
    }

    @Override
    public int getCount() {
        return countryNames.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.sample_view, viewGroup, false);
        }

        ImageView imageView = view.findViewById(R.id.imageViewId);
        TextView textView = view.findViewById(R.id.countryNameId);

        imageView.setImageResource(flags[i]);
        textView.setText(countryNames[i]);


        return view;
    }


}

