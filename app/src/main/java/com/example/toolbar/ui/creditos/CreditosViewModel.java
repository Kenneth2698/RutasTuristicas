package com.example.toolbar.ui.creditos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreditosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CreditosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Estudiantes: \n \n Kenneth López Porras B74281\n Byron Ortiz Rojas B65186 ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}