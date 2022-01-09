package com.example.watermonitorproject.ui.gallery;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.watermonitorproject.R;

public class Complaint extends Fragment {
    private GalleryViewModel galleryViewModel;
    public WebView webview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.complaint, container, false);
        this.galleryViewModel.getText().observe(this, new Observer<String>() {
            public void onChanged(String s) {
            }
        });
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Complaint.super.onViewCreated(view, savedInstanceState);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.webview = (WebView) view.findViewById(R.id.complaintWebview);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.setOverScrollMode(2);
        this.webview.loadUrl("file:///android_asset/complaint.html");
    }
}
