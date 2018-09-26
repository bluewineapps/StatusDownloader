package com.bluewine.statusdownloader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView =findViewById(R.id.detail_imageViews);
        final Intent intent = getIntent();
        String imageUrl =intent.getStringExtra("path");

        Bitmap bitmap = BitmapFactory.decodeFile(imageUrl);
        imageView.setImageBitmap(bitmap);


    }
}
