package com.example.malek.assignment1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random mRandom = new Random();
    int mNumber_stored,mNumber_entered,mduration,mtemp;
    String mAnswer_Smaller,mAnswer_Greater,mAnswer_veryclose;
    Context mcontext;
    Toast mtoast;
    EditText meditText_answer;
    private static final String TAG = MainActivity.class.getSimpleName();

    public void check()
    {
        meditText_answer = (EditText) findViewById(R.id.mAnswer_txt);
        mNumber_entered = Integer.parseInt( meditText_answer.getText().toString() );
        //Log.d(TAG, " My Value is : "+ (val+5) ); FOR TEST
        mtemp = mNumber_entered - mNumber_stored;



        if(mtemp<0)
            mtemp*=-1;

        if(mtemp <= 5 && mtemp>=0)
        {
            mtoast = Toast.makeText(mcontext, mAnswer_veryclose, mduration);
            mtoast.show();
        }
        else if(mNumber_entered > mNumber_stored)
        {
            mtoast = Toast.makeText(mcontext, mAnswer_Greater, mduration);
            mtoast.show();
        }
        else if(mNumber_entered < mNumber_stored)
        {
            mtoast = Toast.makeText(mcontext, mAnswer_Smaller, mduration);
            mtoast.show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumber_stored = mRandom.nextInt(1001);
        Log.d(TAG, " My Random Number is : "+ mNumber_stored ); //For Test
        mAnswer_Smaller = "Smaller";
        mAnswer_Greater = "Greater";
        mAnswer_veryclose = "Very Close";
        mcontext = getApplicationContext();
        mduration = Toast.LENGTH_SHORT;
        //check();
    }

    public void Guess(View view) {
        check();
    }
}
