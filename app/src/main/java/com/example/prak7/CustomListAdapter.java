package com.example.prak7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Parfum> Parfum;
    public CustomListAdapter(Activity activity, List<Parfum>
            Parfum) {
        this.activity = activity;
        this.Parfum = Parfum;
    }
    @Override
    public int getCount() {
        return Parfum.size();
    }
    @Override
    public Object getItem(int location) {
        return Parfum.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView jenis = (TextView)
                convertView.findViewById(R.id.text_jenis);
        TextView pengertian = (TextView)
                convertView.findViewById(R.id.text_pengertian);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Parfum m = Parfum.get(position);
        jenis.setText("Jenis : "+ m.get_jenis());
        pengertian.setText("Pengertian : "+ m.get_pengertian());
        return convertView;
    }
}