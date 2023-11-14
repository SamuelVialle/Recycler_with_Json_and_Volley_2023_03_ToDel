package com.samuelvialle.a_2023_03_recyclerwithjsonandvolley;

import static com.samuelvialle.a_2023_03_recyclerwithjsonandvolley.Nodes.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(JSON_IMAGE_URL);
        String creator = intent.getStringExtra(JSON_USER);
        int likes = intent.getIntExtra(JSON_LIKES, 0);

        ImageView ivImage = findViewById(R.id.iv_image);
        TextView tvCreator = findViewById(R.id.tv_creator);
        TextView tvLikes = findViewById(R.id.tv_likes);

        tvCreator.setText(creator);
        tvLikes.setText("Likes: " + likes);

        Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivImage);



    }
}