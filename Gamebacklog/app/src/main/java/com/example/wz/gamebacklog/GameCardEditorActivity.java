package com.example.wz.gamebacklog;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameCardEditorActivity extends AppCompatActivity {

    private TextInputEditText title;
    private TextInputEditText platform;
    private TextInputEditText notes;
    private Spinner spinner;
    private String status;
    private DateFormat dateFormat;
    private Date date = new Date();
    private String dateString;
    private MainActivity.GameCardAsyncTask async;
    private Intent intent;

    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_card_editor);


        title = findViewById(R.id.titleInput);
        platform = findViewById(R.id.platformInput);
        notes = findViewById(R.id.notesInput);
        spinner = findViewById(R.id.spinner);


        FloatingActionButton fabsave = findViewById(R.id.saveBtn);
        fabsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                status = spinner.getSelectedItem().toString();

                dateFormat = new SimpleDateFormat("dd/MM/yyy");
                dateString =  dateFormat.format(date);

                if(!title.getText().toString().isEmpty() && !platform.getText().toString().isEmpty()) {
                    GameCard gameCard = new GameCard(title.getText().toString(), platform.getText().toString(),
                            notes.getText().toString(), status, dateString);

                    async = new MainActivity.GameCardAsyncTask(MainActivity.TASK_INSERT_REMINDER);
                    async.execute(gameCard);
                    returnToMain();
                }else{
                    Toast.makeText(GameCardEditorActivity.this,"'Title' and 'platform' are required",Toast.LENGTH_SHORT).show();
                }



            }
        });

    }

    private void returnToMain(){
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}