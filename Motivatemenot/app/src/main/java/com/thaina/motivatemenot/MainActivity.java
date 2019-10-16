package com.thaina.motivatemenot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String TAG_MAINACTIVITY = "TAG_MAINACTIVITY";

    //identify the relevant XML Objects
    SeekBar mSbProbabilityOfPosMsg;
    Button mBtnGetMsg;
    TextView mTVMsgs;
    Button.OnClickListener mMyButtonClickHandler = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Here we write how to respond to clicks
            generateRandomSentenceAndDisplayIt();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivate_me_not_rl2);
        init(); //Always call init
    }//onCreate

    void init(){
        mSbProbabilityOfPosMsg = findViewById(R.id.idSbProbabilityOfPosMsg);
        mBtnGetMsg= findViewById(R.id.idBtnGetMsg);
        mTVMsgs=findViewById(R.id.idTvMsgs);

        //optional code starts here
        Object[] setOfRelevantObjects = {
                mSbProbabilityOfPosMsg,
                mBtnGetMsg,
                mTVMsgs
        };
        Boolean bArteAllRelevantObjectsOK = true;
        for(Object o: setOfRelevantObjects){
            bArteAllRelevantObjectsOK = bArteAllRelevantObjectsOK && (o!=null);
        }

        if(!bArteAllRelevantObjectsOK){
            Log.e(TAG_MAINACTIVITY,"1+object(s) is(are) null.");
            finish();
        }

        //Optional code ends here
        mBtnGetMsg.setOnClickListener(mMyButtonClickHandler);


    }//init

    void generateRandomSentenceAndDisplayIt(){

        //Write the solution
        // 1 generating random sentene, respecting the user set probability
        String strSentence = "";
        /*String[] setOfPositiveMessages = {
                "p1", "p2"
        };
        String[] setOfNegativeMessages = {
                "n1", "n2"
        };*/

        //The java arrays now get their value from XML resources, and not from literals as above, that gives us much elasticity
        String[] setOfPositiveMessages = getResources().getStringArray(R.array.aPosMsgs);
        String[] setOfnegativeMessages = getResources().getStringArray(R.array.aNegMsgs);



        //the math to decide if the user gets a + or - message
        //not so relevant to android dev, but to this particular app

        int iUserChoosenProbabilityOfPositiveMessage = mSbProbabilityOfPosMsg.getProgress();

        int iRandomValue = AmUtil.randomInt(0,100);
        Boolean bGenPositiveMsg = iRandomValue <= iUserChoosenProbabilityOfPositiveMessage;

        if (bGenPositiveMsg){
            //strSentence = "some positive message";
            strSentence = setOfPositiveMessages[
                    //adress one random +msg
                    AmUtil.randomInt(0,setOfPositiveMessages.length-1)
            ];
        }else{
            //strSentence = "some negative message";
            strSentence = setOfnegativeMessages[
                    //adress one random -msg
                    AmUtil.randomInt(0,setOfnegativeMessages.length-1)
            ];
        }//else

        // 2 display the sentence
        String strPreviousSentences = mTVMsgs.getText().toString();
        mTVMsgs.setText(strSentence + "\n" + strPreviousSentences);
        //mTVMsgs.setText(strSentence); //would only give us 1 sentence

    }//generateRandomSentenceAndDisplayIt
}//MainActivity
