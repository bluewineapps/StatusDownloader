package com.bluewine.statusdownloader;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ImageViewActivity extends AppCompatActivity {

    ImageView imageView;
    FloatingActionButton floatingActionButton3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }


        imageView =findViewById(R.id.detail_imageViews);
        final Intent intent = getIntent();
        final String imageUrl =intent.getStringExtra("path");

        final Bitmap bitmap = BitmapFactory.decodeFile(imageUrl);
        imageView.setImageBitmap(bitmap);

        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);

        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addImageToGallery(getApplicationContext(),imageUrl);

            }
        });
    }



    public static void addImageToGallery(Context context,String source) {

        //
        Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show();
        File sourceFIle=new File(source);
        String destinationPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/statusDownloder/"+sourceFIle.getName();
        File destination = new File(destinationPath);

        try
        {
            FileUtils.copyFile(sourceFIle, destination);
            MediaStore.Images.Media.insertImage(context.getApplicationContext().getContentResolver(), BitmapFactory.decodeFile(destinationPath),"", "");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
