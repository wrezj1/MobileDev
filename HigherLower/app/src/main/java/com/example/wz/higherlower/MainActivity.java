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

    //declaration of object
    private Button buttonHigher;
    private Button buttonLower;

    private TextView textViewScore;
    private TextView textViewHighScore;
    private ImageView imageViewDice;
    private ListView scoreList;

    private ArrayList<String> scoreListArray = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    //declaration of variables
     private int currentRoll;
     private int diceRoll = 0;
     private int scoreCounter = 0;
     private int highScoreCounter = 0;
     //dice sides
     private final int SIDES = 6;


    /**
     *
     * @param savedInstanceState
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize first dice
        if(currentRoll == 0){
            currentRoll = roll();
            setImage(currentRoll);
        }

        //initializing objects with view
        buttonHigher = (Button) findViewById(R.id.buttonHigher);
        buttonLower = (Button) findViewById(R.id.buttonLower);

        textViewScore = (TextView) findViewById(R.id.textViewScore);
        textViewHighScore = (TextView) findViewById(R.id.textViewHighScore);



        textViewScore = (TextView) findViewById(R.id.textViewScore);
        textViewHighScore = (TextView) findViewById(R.id.textViewHighScore);

        scoreList = (ListView) findViewById(R.id.scoreList);

        //creating arrayAdapter linked to list with score history
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                scoreListArray);

        //General listener
        View.OnClickListener generalListener= new View.OnClickListener() {
            String outcome;
            public void onClick(View v) {

                //rolling the dice
                diceRoll = roll();
                setImage(diceRoll);

                //get the pressed button tag
                String buttonInput = (String) v.getTag();

                //linking score list with score listView
                scoreList.setAdapter(arrayAdapter);

                //start rolling
                outcome = startRoll(currentRoll,diceRoll,buttonInput);
                scoreCounter(outcome);

                //set currentRoll to skip first check
                currentRoll = diceRoll;

                //show message of the outcome
                Toast.makeText(MainActivity.this,outcome,Toast.LENGTH_SHORT).show();

                //initializing score & highscore view
                textViewScore.setText("Score: "+scoreCounter);
                textViewHighScore.setText("Highscore: "+highScoreCounter);


            }
        };

        //setting tags buttons & linking to our general listener
        buttonLower.setTag("LOWER");
        buttonLower.setOnClickListener(generalListener);
        buttonHigher.setTag("HIGHER");
        buttonHigher.setOnClickListener(generalListener);

    }

    /**
     *
     * @param diceRoll
     * setting the imageViewDice equal to the result of diceRoll
     */
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

    /**
     *
     * @param outcome
     * When guessed correct, scoreCounter +1
     * When highscore lower than score, replace highscore with score
     */
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

    /**
     *
     * @param currentRoll
     * @param diceRoll
     * @param buttonInput
     * @return message outcome guess
     */
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

        //adding result to score list
        scoreListArray.add("Throw is: " + diceRoll);

        return result;
    }

    /**
     *
     * @return number between 1 and 6
     */
    private int roll() {
        int i= (int) (Math.random() * SIDES) + 1;
        return i;
    }
}

