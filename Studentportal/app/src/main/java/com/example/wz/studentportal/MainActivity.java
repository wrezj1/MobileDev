package com.example.wz.studentportal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    protected static ArrayList<PortalObject> portals = new ArrayList<>();
    private final String PREFERENCES_NAME = "savedPortals";
    private final String PREFERENCES_KEY = "portals";
    private Button btn;
    private Intent browserIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(portals.isEmpty()){
        loadData();
        }

        showPortals();
    }

    public void onBackPressed(){
        //disables to navigate back directly to the app
    }

    private void showPortals() {
        LinearLayout linLay = (LinearLayout) findViewById(R.id.layoutLin);

        //add button form arraylist
        if(portals.size() != 0) {
            for (int i = 0; i < portals.size(); i++) {
                btn = new Button(this);
                btn.setText(portals.get(i).getTitle());

                final int y = i;
                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        loadWebView(portals.get(y).getUri());
                    }
                });

                //Remove button long press
                btn.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        portals.remove(y);
                        Intent i = getBaseContext().getPackageManager()
                                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        return true;
                    }
                });

                linLay.addView(btn);
            }
        }

    }

    //onclick defined in xml activity_main
    public void addNewPortal(View view) {
        Intent intent = new Intent(this, AddPortal.class);
        startActivity(intent);
    }

    private void loadWebView(String url) {
        browserIntent = new Intent(this, PortalWebView.class);
        browserIntent.putExtra("uri", url);
        startActivity(browserIntent);
    }

    //save the list before closing the app
    @Override
    public void onDestroy(){
        super.onDestroy();
        saveData(portals);
    }

    //save the list when no activity
    @Override
    public void onPause(){
        super.onPause();
        saveData(portals);
    }

    /**
     *
     * @param list requires list of PortalObject's
     *        converst the list into json object and saves it in a sharedPreferences object
     */
    private void saveData(ArrayList<PortalObject> list){
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(PREFERENCES_KEY, json);
        editor.apply();
    }

    /**
     * Loads sharedPreference data
     */
    private void loadData(){
        SharedPreferences prefs =  getSharedPreferences(PREFERENCES_NAME,MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(PREFERENCES_KEY, null);
        Type type = new TypeToken<ArrayList<PortalObject>>() {}.getType();
        if(prefs.contains(PREFERENCES_KEY)){
        portals = gson.fromJson(json, type);
        }

    }


}
