package com.example.wz.studentportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PortalWebView extends AppCompatActivity {

    private WebView portalView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal_web_view);
        startWebView();
    }

    private void startWebView(){
        intent = getIntent();
        portalView = findViewById(R.id.portalWebView);
        portalView.getSettings().setJavaScriptEnabled(true);
        portalView.loadUrl("https://"+intent.getStringExtra("uri"));
        portalView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(portalView.canGoBack()) {
            portalView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}

