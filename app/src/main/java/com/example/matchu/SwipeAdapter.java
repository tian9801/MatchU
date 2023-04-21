package com.example.matchu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.ViewHolder>{
     List<College> items= Questionare.getCollegeDB();
    private Context context;


    public SwipeAdapter(List<College> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.swipe_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        context = holder.itemView.getContext();
        College c = items.get(position);
        holder.setData(items.get(position), holder);
        Glide.with(context).load(c.getPhoto()).placeholder(R.drawable.steph).
                error(R.drawable.steph).override(1000,1000).centerCrop().into(holder.image);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static Drawable drawableFromUrl(String url)  throws java.net.MalformedURLException, java.io.IOException {
        Bitmap x;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect(); InputStream input = connection.getInputStream();
        x = BitmapFactory.decodeStream(input); return new BitmapDrawable(Resources.getSystem(), x);
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, location, price;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.collegeName);
            location = itemView.findViewById(R.id.location);
            price = itemView.findViewById(R.id.price);
        }

        void setData(College college, SwipeAdapter.ViewHolder holder) {
            String url = college.getPhoto();
            Integer hi = college.getTuition();
            String money = hi.toString();






            name.setText(college.getCollegeName());
            location.setText(college.getState());
            price.setText("$" + money + "/yr");
        }
    }

    public List<College> getItems() {
        return items;
    }

    public void setItems(List<College> items) {
        this.items = items;
    }
}
