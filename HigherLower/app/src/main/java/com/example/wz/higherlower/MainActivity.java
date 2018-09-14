package com.example.wz.higherlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button buttonHigher;
    Button buttonLower;

    TextView textViewScore;
    TextView textViewHighScore;
    ImageView imageViewDice;
    ListView scoreList;

    ArrayList<String> scoreListArray = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> a;


     int currentRoll;
     int diceRoll = 0;
     int scoreCounter = 0;
     int highScoreCounter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(currentRoll == 0){
            currentRoll = roll();
            setImage(currentRoll);


        }

        buttonHigher = (Button) findViewById(R.id.buttonHigher);
        buttonLower = (Button) findViewById(R.id.buttonLower);

        scoreList = (ListView) findViewById(R.id.scoreList);

        textViewScore = (TextView) findViewById(R.id.textViewScore);
        textViewHighScore = (TextView) findViewById(R.id.textViewHighScore);

        imageViewDice = (ImageView) findViewById(R.id.imageViewDice);

        textViewScore = (TextView) findViewById(R.id.textViewScore);
        textViewHighScore = (TextView) findViewById(R.id.textViewHighScore);




        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                scoreListArray);

        View.OnClickListener myClickLIstener= new View.OnClickListener() {
            String outcome;
            public void onClick(View v) {


                diceRoll = roll();

                String buttonInput = (String) v.getTag();

                outcome = startRoll(currentRoll,diceRoll,buttonInput);
                scoreCounter(outcome);
                setImage(diceRoll);
                currentRoll = diceRoll;

                Toast.makeText(MainActivity.this,outcome,Toast.LENGTH_SHORT).show();

                textViewScore.setText("Score: "+scoreCounter);
                textViewHighScore.setText("Highscore: "+highScoreCounter);
                scoreList.setAdapter(arrayAdapter);
            }
        };


        buttonLower.setTag("LOWER");
        buttonLower.setOnClickListener(myClickLIstener);
        buttonHigher.setTag("HIGHER");
        buttonHigher.setOnClickListener(myClickLIstener);

    }


    private void setImage(int diceRoll){
        imageViewDice = (ImageView) findViewById(R.id.imageViewDice);
        switch (diceRoll){
            case 1:
                imageViewDice.setImageResource(R.drawable.dice1);
                break;

            case 2:
                imageViewDice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.dice6);
                break;
        }



    }

    private void scoreCounter(String outcome){
        if (outcome.equals("Winner!")) {
            scoreCounter ++;
        }else if(outcome.equals("LOSER! BURN")){
            scoreCounter = 0;
        }

        if (scoreCounter> highScoreCounter){
            highScoreCounter = scoreCounter;
        }
    }

    private String startRoll(int currentRoll,int diceRoll, String buttonInput) {
        String result;

        if(buttonInput.equals("HIGHER") && currentRoll < diceRoll
                || buttonInput.equals("LOWER") && currentRoll > diceRoll){
            result = "Winner!";
        }else if(buttonInput.equals("HIGHER") && currentRoll > diceRoll
                || buttonInput.equals("LOWER") && currentRoll < diceRoll){
            result = "LOSER! BURN";
        }else{
            result = "No Winners, No Losers";
        }


        scoreListArray.add("Throw is: " + diceRoll);

        return result;
    }

    private int roll() {
        int SIDES = 6;
        int roll = (int) (Math.random() * SIDES) + 1;


        return roll;
    }



}

