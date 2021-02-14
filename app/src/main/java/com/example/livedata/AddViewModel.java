package com.example.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddViewModel extends ViewModel {

    private MutableLiveData <Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number == null){

            number = new MutableLiveData<>();
            number.setValue(0);
        }

        return number;
    }

    public void addNum () {

       number.setValue(number.getValue() + 1);
    }

    public void resetNum () {

        number.setValue(0);
    }
}
