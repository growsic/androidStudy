package com.growsic.study.myquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

/**
 * Created by a13918 on 2015/04/30.
 */
public class QuizActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_show_fragment);

        if (savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            QuizFragment fragment = new QuizFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("correct counter", 0);
            fragment.setArguments(bundle);
            fragmentTransaction.add(R.id.quizShowFragment, fragment);
            fragmentTransaction.commit();



        }


        Button button = (Button)findViewById(R.id.exitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        /*
        getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new QuizFragment())
                    .commit();
         */



    }
}
