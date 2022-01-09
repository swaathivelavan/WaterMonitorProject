package com.example.watermonitorproject.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> mText = new MutableLiveData<>();

    public HomeViewModel() {
        this.mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}
