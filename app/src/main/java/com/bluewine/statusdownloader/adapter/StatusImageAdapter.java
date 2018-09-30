package com.bluewine.statusdownloader.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bluewine.statusdownloader.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StatusImageAdapter extends RecyclerView.Adapter<StatusImageAdapter.MyViewHolder> {

    private ArrayList<String> images;
    private String path;

    public StatusImageAdapter(ArrayList<String> images, String path){
        this.images=images;
        this.path=path;
    }

    @NonNull
    @Override
    public StatusImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, null);
        StatusImageAdapter.MyViewHolder viewHolder = new StatusImageAdapter.MyViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StatusImageAdapter.MyViewHolder myViewHolder, int i) {


        Bitmap bitmap = BitmapFactory.decodeFile(path+"/"+images.get(i));
        myViewHolder.imageView.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.statusItem_imageView);
        }
    }
}
