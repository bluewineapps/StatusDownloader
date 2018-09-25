package com.bluewine.statusdownloader;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluewine.statusdownloader.adapter.StatusImageAdapter;
import com.bluewine.statusdownloader.utill.Loader;

import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageFragment extends Fragment{

    RecyclerView recyclerView;

    public ImageFragment() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_image, container, false);

            setupView(root);
            return  root;
        }

    public void setupView(ViewGroup root) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerViewImage);
        setUPList();
    }

    private void setUPList() {

        List<Integer> images = new ArrayList<Integer>();

        Log.i("LOAD","------------- "+Environment.getExternalStorageDirectory());
        Log.i("LOAD","------------- "+Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.i("LOAD","------------- "+Environment.getExternalStorageDirectory().getAbsolutePath()+"/WhatsApp/Media/.Statuses/");

        File hiddenpath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsApp/Media/.Statuses/");

        Log.i("LOAD","------------- "+hiddenpath.getAbsolutePath());
        String[] files = hiddenpath.list();
        for(String f : files){
            Log.i("LOAD","------------- "+f);
        }

        Log.i("LOAD","------------- ? "+hiddenpath.canRead());



        new Loader().loadImages(Environment.getExternalStorageState());

        for (int i=0;i<20;i++)
            images.add(i);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        StatusImageAdapter statusImageAdapter = new StatusImageAdapter(files,hiddenpath.getAbsolutePath());
        recyclerView.setAdapter(statusImageAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

}
