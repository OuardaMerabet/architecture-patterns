package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;

public class Presenter {
    MVPInterface mvpInterface;
    DataBase dataBase = new DataBase();

    public Presenter(MVPInterface mvpInterface) {
        this.mvpInterface = mvpInterface;
    }

    public void getDivision(){
        mvpInterface.onGetDivision(dataBase.getNumbers().getFirstNum()/dataBase.getNumbers().getSecondNum());
    }
}
