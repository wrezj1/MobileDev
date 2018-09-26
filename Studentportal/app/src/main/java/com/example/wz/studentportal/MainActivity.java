package com.example.wz.studentportal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        //disables to navigate back directly to the app..
    }

    private void showPortals() {
        LinearLayout linLay = (LinearLayout) findViewById(R.id.layoutLin);
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
                linLay.addView(btn);
            }
        }

    }

    private void loadWebView(String url) {
        browserIntent = new Intent(this, PortalWebView.class);
        browserIntent.putExtra("uri", url);
        startActivity(browserIntent);
    }

    protected void addNewPortal(View view) {
        Intent intent = new Intent(this, AddPortal.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        saveData(portals);
    }

    @Override
    public void onPause(){
        super.onPause();
        saveData(portals);
    }

    private void saveData(ArrayList<PortalObject> list){
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(PREFERENCES_KEY, json);
        editor.apply();
    }

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
