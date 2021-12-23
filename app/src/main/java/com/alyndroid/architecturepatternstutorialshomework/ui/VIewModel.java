package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;

public class VIewModel extends ViewModel {
    DataBase dataBase = new DataBase();
    MutableLiveData <Integer> multiplicationMutableLiveData= new MutableLiveData<>();

    public void getDivision(){
        multiplicationMutableLiveData.setValue(dataBase.getNumbers().getFirstNum()*dataBase.getNumbers().getSecondNum());
    }
}
