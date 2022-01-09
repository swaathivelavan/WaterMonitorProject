package com.example.watermonitorproject.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {
    private MutableLiveData<String> mText = new MutableLiveData<>();

    public SendViewModel() {
        this.mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}
