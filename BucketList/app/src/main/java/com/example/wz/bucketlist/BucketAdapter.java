package com.example.wz.bucketlist;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import java.util.List;

public class BucketAdapter extends RecyclerView.Adapter<BucketAdapter.BucketViewHolder> {

    List<BucketItem> mBucketItems;
    private ItemClickListener mItemClickListener;


    public BucketAdapter(List<BucketItem> mBucketItems, ItemClickListener click) {
        this.mBucketItems = mBucketItems;
        this.mItemClickListener = click;
    }

    @NonNull
    @Override
    public BucketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.bucket_item,viewGroup,false);
        return new BucketViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketViewHolder bucketViewHolder, final int i) {
        final BucketItem bucketItem = mBucketItems.get(i);
        bucketViewHolder.bucketItem.setOnCheckedChangeListener(null);

        bucketViewHolder.bucketItem.setText(bucketItem.getText());
        bucketViewHolder.bucketItem.setChecked(bucketItem.getDone());

        if (bucketViewHolder.bucketItem.isChecked()) {
            bucketViewHolder.bucketItem.setPaintFlags(bucketViewHolder.bucketItem.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            bucketViewHolder.bucketItem.setPaintFlags(0);
        }


        bucketViewHolder.bucketItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mItemClickListener.itemOnClick(i,isChecked);

                notifyDataSetChanged();
            }
        });

    }

    public interface ItemClickListener {
        void itemOnClick(int position, boolean checked);
    }

    @Override
    public int getItemCount() {
        return mBucketItems.size();
    }

    public class BucketViewHolder extends RecyclerView.ViewHolder {

        public CheckBox bucketItem;

        public BucketViewHolder(View itemView) {
            super(itemView);
            bucketItem =  itemView.findViewById(R.id.bucket_checkbox);

        }
    }
}
