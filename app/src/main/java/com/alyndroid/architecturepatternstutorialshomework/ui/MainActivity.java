package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.data.NumberModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MVPInterface {
    TextView plusText,div_result_textView,mul_result_textView;
    DataBase dataBase;
    Button plus_button,div_button,mul_button;
    Presenter presenter;
    VIewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MVC
        plus_button= findViewById(R.id.plus_button);
        plusText= findViewById(R.id.plus_result_textView);
        plus_button.setOnClickListener(this);
        dataBase= new DataBase();

        //MVP
        div_button= findViewById(R.id.div_button);
        div_result_textView= findViewById(R.id.div_result_textView);
        div_button.setOnClickListener(this);
        presenter= new Presenter(this);
        //MVVM
        mul_button= findViewById(R.id.mul_button);
        mul_result_textView= findViewById(R.id.mul_result_textView);
        mul_button.setOnClickListener(this);
        viewModel= ViewModelProviders.of(this).get(VIewModel.class);
        viewModel.multiplicationMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mul_result_textView.setText(String.valueOf(integer));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.plus_button:
            int  Somme = dataBase.getNumbers().getFirstNum() + dataBase.getNumbers().getSecondNum();
            plusText.setText(String.valueOf(Somme));
            break;
            case R.id.div_button:
             presenter.getDivision();

                break;
            case R.id.mul_button:
                viewModel.getDivision();
                break;
        }
    }

    @Override
    public void onGetDivision(int div) {
        div_result_textView.setText(String.valueOf(div));
    }
}
