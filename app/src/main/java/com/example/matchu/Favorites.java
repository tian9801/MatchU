package com.example.matchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.matchu.databinding.ActivityFavoritesBinding;

public class Favorites extends AppCompatActivity {

    ActivityFavoritesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoritesBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_favorites);
        binding.bottomNavigationView.setOnClickListener(item -> {

           switch (item.getItemId()){
               case R.id.favorites:

           }
            return true;
        });
    }
}