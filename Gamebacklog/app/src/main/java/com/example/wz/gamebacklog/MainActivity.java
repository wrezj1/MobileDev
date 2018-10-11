package com.example.wz.gamebacklog;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GameCardAdapter.GameCardClickListener{

    private static List<GameCard> mGameCards = new ArrayList<>();
    private static GameCardAdapter mAdapter;

    private static RecyclerView mRecyclerView;

    private Intent intent;

    private static AppDatabase db;

    private int mModifyPosition;
    public static final String EXTRA_CARD = "thisCard";
    public static final int REQUESTCODE = 1234;

    public final static int TASK_GET_ALL_REMINDERS = 0;
    public final static int TASK_DELETE_REMINDER = 1;
    public final static int TASK_UPDATE_REMINDER = 2;
    public final static int TASK_INSERT_REMINDER = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this);

        setUpRecycleView();
        updateUI();


        new GameCardAsyncTask(TASK_GET_ALL_REMINDERS).execute();


        setUpBtn();
        swipeToDelete();

    }

    private void swipeToDelete(){
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
                        new GameCardAsyncTask(TASK_DELETE_REMINDER).execute(mGameCards.get(position));
                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

    private void setUpRecycleView(){
        mRecyclerView = findViewById(R.id.recycView);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new GameCardAdapter(mGameCards, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setUpBtn(){
        intent = new Intent(this, GameCardEditorActivity.class);
        FloatingActionButton fabAdd = findViewById(R.id.addBtn);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }


    public static void onReminderDbUpdated(List list) {
        mGameCards = list;
        updateUI();
    }

    private static void updateUI() {
        if (mAdapter == null) {
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.swapList(mGameCards);
        }
    }

    @Override
    public void gameCardOnClick(int i) {
        Intent intent = new Intent(MainActivity.this, UpdateCardActivity.class);
        mModifyPosition = i;
        intent.putExtra(EXTRA_CARD, mGameCards.get(i));
        startActivityForResult(intent, REQUESTCODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUESTCODE) {
            if (resultCode == RESULT_OK) {
                GameCard updatedGameCard = data.getParcelableExtra(MainActivity.EXTRA_CARD);
                // New timestamp: timestamp of update
                //      mReminders.set(mModifyPosition, updatedReminder);
                new GameCardAsyncTask(TASK_UPDATE_REMINDER).execute(updatedGameCard);
                updateUI();
            }
        }
    }

    public static class GameCardAsyncTask extends AsyncTask<GameCard, Void, List> {

        private int taskCode;

        public GameCardAsyncTask(int taskCode) {
            this.taskCode = taskCode;
        }



        @Override
        protected List doInBackground(GameCard... gameCard) {
            switch (taskCode) {
                case TASK_DELETE_REMINDER:
                    db.gameCardDao().deleteGameCard(gameCard[0]);
                    break;

                case TASK_UPDATE_REMINDER:
                    db.gameCardDao().updateGameCard(gameCard[0]);
                    break;

                case TASK_INSERT_REMINDER:
                    db.gameCardDao().insertGameCard(gameCard[0]);
                    break;
            }


            //To return a new list with the updated data, we get all the data from the database again.
            return db.gameCardDao().getAllGameCards();
        }


        @Override
        protected void onPostExecute(List list) {
            super.onPostExecute(list);
            onReminderDbUpdated(list);
        }

    }


}
