package com.example.watermonitorproject;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    WebView webview;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        Main2Activity.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.webview = (WebView) findViewById(R.id.webview);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.setOverScrollMode(2);
        this.webview.loadUrl("file:///android_asset/activity2.html");
    }
}
