package com.example.wz.studentportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddPortal extends AppCompatActivity {

    TextView url;
    TextView title;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        url = findViewById(R.id.editTextUrl);
        title = findViewById(R.id.editTextTitle);


    }

    //onclick defined in xml activity_main
    public void addPortalToList(View view) {
        if(!url.getText().toString().isEmpty() && !title.getText().toString().isEmpty()) {
            MainActivity.portals.add(new PortalObject(url.getText().toString()
                    , title.getText().toString()));
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"FIll everything first."
                    ,Toast.LENGTH_SHORT).show();
        }
    }
}
