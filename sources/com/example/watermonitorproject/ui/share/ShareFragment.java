package com.example.watermonitorproject.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.watermonitorproject.R;

public class ShareFragment extends Fragment {
    private ShareViewModel shareViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.shareViewModel = ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        final TextView textView = (TextView) root.findViewById(R.id.text_share);
        this.shareViewModel.getText().observe(this, new Observer<String>() {
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
