package com.example.wz.bucketlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BucketAdapter.ItemClickListener {

    List<BucketItem> bucketItems = new ArrayList<>();
    private BucketAdapter mAdapter;

    @BindView(R.id.text_new_bucket)
    EditText addTextBucket;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRecyclerView();

    }

    @OnClick(R.id.btn_add_bucketItem)
    public void addBucketItemBtn(){
        bucketItems.add(new BucketItem(addTextBucket.getText(), false));
        mAdapter.notifyDataSetChanged();

    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new BucketAdapter(bucketItems, this);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void itemOnClick(int position, boolean checked) {
        bucketItems.get(position).setDone(checked);
    }
}
