package com.example.wz.geoguesswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


/**
 * author: Wrezj Kebabdji
 */
public class GeoImageAdapter extends RecyclerView.Adapter<GeoImageAdapter.GeoImageViewHolder> {

    private List<GeoImage> mImageList;

    public GeoImageAdapter(List<GeoImage> imageList) {
        this.mImageList = imageList;
    }

    /**
     * return a view holder with the right image_layout from layout
     */
    @NonNull
    @Override
    public GeoImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       Context context = parent.getContext();
       LayoutInflater inflater = LayoutInflater.from(context);
       View v = inflater.inflate(R.layout.image_layout,parent,false);
       return new GeoImageViewHolder(v);
    }

    /**
     * sets the image resource on the basis of the position
     */
    @Override
    public void onBindViewHolder(@NonNull GeoImageViewHolder holder, int position) {
    GeoImage image = mImageList.get(position);
    holder.geoImage.setImageResource(image.getmGeoImageName());
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }

    /**
     * Custom view holder class for our image View
     */
    public class GeoImageViewHolder extends RecyclerView.ViewHolder {

        public ImageView geoImage;

        public GeoImageViewHolder(View itemView) {
            super(itemView);
            geoImage =  itemView.findViewById(R.id.geoImageView);
        }
    }

}
