package com.example.watermonitorproject.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.watermonitorproject.R;

public class SlideshowFragment extends Fragment {
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = (TextView) root.findViewById(R.id.text_slideshow);
        this.slideshowViewModel.getText().observe(this, new Observer<String>() {
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
