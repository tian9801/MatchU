package com.example.matchu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<College> likedList;
    LayoutInflater inflater;
    public CustomBaseAdapter(Context context, List<College> likedList){
        this.context = context;
        this.likedList = likedList;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return likedList.size();
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
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtView = (TextView)convertView.findViewById(R.id.textView);
        txtView.setText(likedList.get(i).getCollegeName());
        TextView hi = (TextView)convertView.findViewById(R.id.state);
        hi.setText(likedList.get(i).getState());

            return convertView;
    }
}
