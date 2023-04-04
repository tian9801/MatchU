package com.example.matchu;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.ViewHolder>{
    private List<College> items;

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
        holder.setData(items.get(position));
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
        int pic = drawableFromUrl(College.getPhoto());
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.collegeName);
            location = itemView.findViewById(R.id.location);
            price = itemView.findViewById(R.id.price);
        }

        void setData(College college) {
            Integer hi = college.getTuition();
            String text =  Integer.valueOf(hi).toString();

            Picasso.get()
                    .load(pic)
                    .fit()
                    .centerCrop()
                    .into(image);

            name.setText(college.getCollegeName());
            location.setText(college.getState());
            price.setText(text);
        }
    }

    public List<College> getItems() {
        return items;
    }

    public void setItems(List<College> items) {
        this.items = items;
    }
}
