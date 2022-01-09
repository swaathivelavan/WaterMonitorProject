package com.example.watermonitorproject.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.watermonitorproject.R;

public class SendFragment extends Fragment {
    private SendViewModel sendViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.sendViewModel = ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        final TextView textView = (TextView) root.findViewById(R.id.text_send);
        this.sendViewModel.getText().observe(this, new Observer<String>() {
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
