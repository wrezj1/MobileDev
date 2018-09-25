package com.example.wz.geoguesswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mGeoRecyclerView;
    private List<GeoImage> mGeoObjects;
    GeoImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillListWithImages();
        setUpRecycleView();
        swipeDetection();
    }

    private void setUpRecycleView(){
        mGeoRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new GeoImageAdapter( mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);
    }

    private void fillListWithImages(){
        mGeoObjects = new ArrayList<>();
        for (int i = 0; i < GeoImage.IN_EUROPE.length; i++) {
            mGeoObjects.add(new GeoImage(GeoImage.IN_EUROPE[i],
                    GeoImage.IMAGE_NAME[i]));
        }
    }
    private void swipeDetection(){
        //Detects swipe
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }

                    //Called when a user swipes left or right on a ViewHolder
                    //Compares user swipes with the boolean of the images
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        int position = (viewHolder.getAdapterPosition());

                        if(swipeDir == 4 && mGeoObjects.get(position).getmInEurope() == true) {
                            Toast.makeText(MainActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                        }
                        else if(swipeDir == 8 && mGeoObjects.get(position).getmInEurope() == false){
                            Toast.makeText(MainActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this,"Incorrect",Toast.LENGTH_SHORT).show();
                        }

                        //Get the index corresponding to the selected position
                        mGeoObjects.remove(position);
                        mAdapter.notifyItemRemoved(position);
                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);
    }

}
