package com.example.watermonitorproject.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {
    private MutableLiveData<String> mText = new MutableLiveData<>();

    public SlideshowViewModel() {
        this.mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}
