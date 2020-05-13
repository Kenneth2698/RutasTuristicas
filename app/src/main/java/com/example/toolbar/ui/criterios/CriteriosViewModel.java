package com.example.toolbar.ui.criterios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CriteriosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CriteriosViewModel() {
        mText = new MutableLiveData<>();



    }

    public LiveData<String> getText() {
        return mText;
    }


}