package com.example.wz.gamebacklog;

import android.app.Activity;
import android.arch.persistence.room.Update;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateCardActivity extends AppCompatActivity {

    private TextInputEditText title;
    private TextInputEditText platform;
    private TextInputEditText notes;
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_card_editor);

        final GameCard gameCardToUpdate = getIntent().getParcelableExtra(MainActivity.EXTRA_CARD);

        prepareCardToEdit(gameCardToUpdate);

        FloatingActionButton fabsave = findViewById(R.id.saveBtn);
        fabsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the input en prepare to be updated
                String textTitle = title.getText().toString();
                String textPlatform = platform.getText().toString();
                String textNote = notes.getText().toString();
                String spinnerItem = spinner.getSelectedItem().toString();

                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
                String dateString = dateFormat.format(date);

                if (!textTitle.isEmpty() && !textPlatform.isEmpty()) {
                    //updating the object
                    gameCardToUpdate.setTitle(textTitle);
                    gameCardToUpdate.setPlatform(textPlatform);
                    gameCardToUpdate.setNotes(textNote);
                    gameCardToUpdate.setStatus(spinnerItem);

                    //Prepare the return parameter and return
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(MainActivity.EXTRA_CARD, gameCardToUpdate);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                } else {
                    Toast.makeText(UpdateCardActivity.this,"'Title' and 'platform' are required",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /**
     *
     * @param gameCardToUpdate filling the card view with the current information
     */
    private void prepareCardToEdit(GameCard gameCardToUpdate){
        title = findViewById(R.id.titleInput);
        platform = findViewById(R.id.platformInput);
        notes = findViewById(R.id.notesInput);
        spinner =  findViewById(R.id.spinner);

        //filling the view
        title.setText(gameCardToUpdate.getTitle());
        platform.setText(gameCardToUpdate.getPlatform());
        notes.setText(gameCardToUpdate.getNotes());

        //setup spinner to edit
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.game_status,
                R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        int spinnerItemId = arrayAdapter.getPosition(gameCardToUpdate.getStatus());
        spinner.setSelection(spinnerItemId);
    }


}
