package com.example.watermonitorproject.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.watermonitorproject.R;

public class ToolsFragment extends Fragment {
    private ToolsViewModel toolsViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.toolsViewModel = ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = (TextView) root.findViewById(R.id.text_tools);
        this.toolsViewModel.getText().observe(this, new Observer<String>() {
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
