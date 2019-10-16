package com.thaina.motivatemenot;

/*A placeholder for methods that have a tendency to be needed, project after project */

import android.content.Context;
import android.widget.Toast;

import java.util.Random;

public class AmUtil {

    Context mContext;

    public AmUtil( Context pContext){
        this.mContext = pContext;
    }//AmUtil

    public void displayMessage(String pStrMsg){
        Toast t = Toast.makeText(mContext, pStrMsg, Toast.LENGTH_SHORT);
        t.show();
    }
    public static int randomInt(
            int piMin,
            int piMax
    ){
        Random r = new Random();
        int iAmplitude = piMax - piMin + 1; //e.g [0,2] = 3 = {0, 1, 2}
        int iJump = r.nextInt(iAmplitude); //pick something inside the amplitude (picking a portion of the range
        int iDestination = piMin + iJump; //make it specifically
        return iDestination;

    }//randomInt

    //example of how to call a static method
    //AmUtil.randomInt(1, 100);
}//AmUtil
