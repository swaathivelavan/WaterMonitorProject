package com.example.watermonitorproject.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {
    private MutableLiveData<String> mText = new MutableLiveData<>();

    public ToolsViewModel() {
        this.mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}
