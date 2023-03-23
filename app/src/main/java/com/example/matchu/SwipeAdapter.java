package com.example.matchu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackView;

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

        void setData(College college) {
            Picasso.get()
                    .load(college.getImage())
                    .fit()
                    .centerCrop()
                    .into(image);

            name.setText(college.getCollegeName());
            location.setText(college.getLocation());
            price.setText(college.getMula());
        }
    }

    public List<College> getItems() {
        return items;
    }

    public void setItems(List<College> items) {
        this.items = items;
    }
}
