package com.example.wz.ns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.wz.ns.Database.AppDatabase;
import com.example.wz.ns.model.UserJourney;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SavedJourneyActivity extends AppCompatActivity implements UserJourneyAdapter.UserJourneyClickListener {

    private static List<UserJourney> saveList = new ArrayList<>();

    private static AppDatabase db;
    private static RecyclerView mRecyclerView;
    private static UserJourneyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_journey);
        ButterKnife.bind(this);
        setUpRecycleView();
        getIntent();

        db = AppDatabase.getInstance(getApplicationContext());
        saveList = db.userJourney().getAllUserJourney();
        updateUI();
        swipeToDelete();

    }


    //forcing to refresh the recyclerView
    private static void updateUI() {
        if (mAdapter == null) {
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.swapList(saveList);
        }
    }

    private void setUpRecycleView() {
        mRecyclerView = findViewById(R.id.recyclerViewSaved);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new UserJourneyAdapter(saveList, this);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void userJourneyOnClick(int i) {
        Intent intent = new Intent(SavedJourneyActivity.this, ResultActivity.class);
        intent.putExtra("from", saveList.get(i).getFrom());
        intent.putExtra("to", saveList.get(i).getTo());
        startActivity(intent);
    }

    private void refreshAllFromDb(){
        saveList.clear();
        saveList = db.userJourney().getAllUserJourney();
        updateUI();
    }

    @OnClick(R.id.btn_removeAll)
    public void deleteAll(){
        db.userJourney().deleteAll(saveList);
        refreshAllFromDb();
        finish();
    }

    private void swipeToDelete() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }

                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        db.userJourney().deleteUserJourney(saveList.get(position));

                        refreshAllFromDb();

                        if(db.userJourney().getAllUserJourney().size() == 0){
                            finish();
                        }
                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
}
