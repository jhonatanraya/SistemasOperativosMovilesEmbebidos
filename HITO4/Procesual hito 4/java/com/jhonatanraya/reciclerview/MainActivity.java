package com.jhonatanraya.reciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jhonatanraya.reciclerview.Adapter.RVAdapter;
import com.jhonatanraya.reciclerview.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;
    private ArrayList<String> imgNames = new ArrayList<>();
//    private ArrayList<Integer> imagesID = new ArrayList<>();
    private ArrayList<String> imagesID = new ArrayList<>();

    private final String imgURL = "V4OgA4O,yB3d2qH,9jMbaX2,rYndmdq,sypYnSP,HBeK1ot,YCqbt8r,eLk31XX," +
            "4ZHp7FO,XzffKgy,DJabk5C";
    private final String imgName = "Playlist 1,Playlist 2,Playlist 3,Playlist 4,Playlist 5," +
            "Playlist 6,Playlist 7,Playlist 8,Playlist 9,Playlist 10,Playlist 11";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIMagebitMaps();
        initRecyclerView();
    }

    public void initIMagebitMaps(){
        imagesID.addAll(Arrays.asList(imgURL.split(",")));
        imgNames.addAll(Arrays.asList(imgName.split(",")));
    }

    public void initRecyclerView(){
        recyclerView = findViewById(R.id.rvContainer);
        rvAdapter = new RVAdapter(this, imgNames, imagesID);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
