package com.bluewine.statusdownloader.adapter;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bluewine.statusdownloader.R;

import java.io.File;
import java.util.ArrayList;

public class StatusVideoAdapter extends RecyclerView.Adapter<StatusVideoAdapter.MyViewHolder> {


    private ArrayList<String> videos;
    private String path;
    private Context context;

    public StatusVideoAdapter(ArrayList<String> videos, String path, Context context){
        this.videos=videos;
        this.path=path;
        this.context=context;
    }


    @NonNull
    @Override
    public StatusVideoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, null);
        StatusVideoAdapter.MyViewHolder viewHolder = new StatusVideoAdapter.MyViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StatusVideoAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.videoView.setVideoPath(path+"/"+videos.get(i));
        myViewHolder.videoView.setMediaController(new MediaController(context));
        myViewHolder.videoView.pause();

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.statusItem_videoView);
        }
    }
}
