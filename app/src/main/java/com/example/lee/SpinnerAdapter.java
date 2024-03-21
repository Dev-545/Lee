package com.example.lee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Activity> {
    LayoutInflater layoutInflater;
    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Activity> Activity) {
        super(context, resource, Activity);
        layoutInflater= LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowview = layoutInflater.inflate(R.layout.custom_spinner, null, true );
        Activity Activity = getItem(position);
        TextView textView =(TextView)rowview.findViewById(R.id.spinner_text);
        ImageView imageView =(ImageView) rowview.findViewById(R.id.spinner_icon);
        textView.setText(Activity.getName());
        imageView.setImageResource(Activity.getImage());
        return rowview;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null) {
            convertView = layoutInflater.inflate(R.layout.custom_spinner, parent, false );
        }
        Activity Activity = getItem(position);
        TextView textView =(TextView)convertView.findViewById(R.id.spinner_text);
        ImageView imageView =(ImageView) convertView.findViewById(R.id.spinner_icon);
        textView.setText(Activity.getName());
        imageView.setImageResource(Activity.getImage());
        return convertView;
    }
}
