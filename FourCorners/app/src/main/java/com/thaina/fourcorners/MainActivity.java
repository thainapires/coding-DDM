package com.thaina.fourcorners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener{

    Button mButtonTopLeftCorner, mButtonTopRightCorner, mButtonBottomLeftCorner, mButtonBottomRightCorner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_corners);

        init();
    }//onCreate

    /*
    is where we will do two things:
    1- to associate Java variables to the XML elements that matter to the app
    2- to give behaviour to the XML elements of relevance, via the Java variables
     */

    void init(){

        //to do associations
        mButtonBottomLeftCorner = findViewById(R.id.idButtonBottomLeftCorner);
        mButtonBottomRightCorner = findViewById(R.id.idButtonBottomRightCorner);
        mButtonTopLeftCorner = findViewById(R.id.idButtonTopLeftCorner);
        mButtonTopRightCorner = findViewById(R.id.idButtonTopRightCorner);

        //to set behavior

        mButtonBottomLeftCorner.setOnClickListener(this);
        mButtonBottomRightCorner.setOnClickListener(this);
        mButtonTopLeftCorner.setOnClickListener(this);
        mButtonTopRightCorner.setOnClickListener(this);

    }//init

    @Override
    public void onClick(View v) {
        int iWitchButtonWasClicked = v.getId();
        switch(iWitchButtonWasClicked){
            case R.id.idButtonBottomLeftCorner:
                showMessage("BLC");
                break;
            case R.id.idButtonBottomRightCorner:
                showMessage("BRC");
                break;
            case R.id.idButtonTopLeftCorner:
                showMessage("TLC");
                break;
            case R.id.idButtonTopRightCorner:
                showMessage("TRC");
                break;
        }
    }//onClick

    void showMessage(String pMessage){
        Toast t = Toast.makeText(this, pMessage, Toast.LENGTH_SHORT);
        t.show();
    }
}
