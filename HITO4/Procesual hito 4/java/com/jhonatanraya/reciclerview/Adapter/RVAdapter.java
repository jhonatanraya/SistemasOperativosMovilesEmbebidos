package com.jhonatanraya.reciclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jhonatanraya.reciclerview.R;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "RVAdapter";

    private Context context;
    private ArrayList<String> imgNames;
//    private ArrayList<Integer> imagesID;
    private ArrayList<String> imagesURL;

    public RVAdapter(@NonNull Context context, ArrayList<String> imageNames, ArrayList<String> imagesURL) {
        this.context = context;
        this.imgNames = imageNames;
        this.imagesURL = imagesURL;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rl_list_item, viewGroup, false);
        ViewHolder vHolder = new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        String URL = "https://i.imgur.com/";

        Glide
                .with(context)
                .asBitmap()
                .load(URL + imagesURL.get(position) + ".png")
                .into(holder.getCircleImage());
//        Set text
        holder.getTvImage().setText(imgNames.get(position));
//        Onclick RVContainer
        holder.getTvImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, imgNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        holder.getBtnListen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Playlist.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgNames.size();
    }
}
