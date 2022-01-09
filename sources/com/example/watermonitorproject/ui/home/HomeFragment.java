package com.example.watermonitorproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.watermonitorproject.R;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    public WebView webview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        this.homeViewModel.getText().observe(this, new Observer<String>() {
            public void onChanged(String s) {
            }
        });
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        HomeFragment.super.onViewCreated(view, savedInstanceState);
        this.webview = (WebView) view.findViewById(R.id.webview);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.setOverScrollMode(2);
        this.webview.loadUrl("file:///android_asset/activity2.html");
    }
}
