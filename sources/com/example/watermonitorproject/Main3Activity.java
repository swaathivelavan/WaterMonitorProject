package com.example.watermonitorproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {
    WebView webview;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        Main3Activity.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.webview = (WebView) findViewById(R.id.view);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.setOverScrollMode(2);
        this.webview.setBackgroundColor(0);
        this.webview.setBackgroundResource(R.drawable.blueback);
        this.webview.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return event.getAction() == 2;
            }
        });
        this.webview.loadUrl("file:///android_asset/load.html");
        runOnUiThread(new Runnable() {
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Main3Activity.this.startActivity(new Intent(Main3Activity.this.getApplicationContext(), Main2Activity.class));
                    }
                }, 4000);
            }
        });
    }
}
