package com.growsic.study.myquizapp;

import android.content.Intent;
<<<<<<< HEAD
import android.content.res.AssetManager;
=======
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
<<<<<<< HEAD
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

=======
import android.view.View;
import android.widget.Button;

>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
/**
 * Created by a13918 on 2015/04/30.
 */
public class QuizActivity extends FragmentActivity {
<<<<<<< HEAD
    private int quizIndex = 0;
    private QuestionHandler questionHandler;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    QuizFragment fragment;
    /**
     * jsonFileを読み込み、読み取った問題を配列に格納
     * 問題１問取り出しFragmentを生成
     * １問終わったらActivityに処理が映り、次の問題を取り出しまたFragmentを生成
     * 問題がすべて終わったら終了のActivityに処理がうつる
     */
=======
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_show_fragment);

<<<<<<< HEAD
        //jsonファイルからクイズを読み込みquestionHandlerに保持
        AssetManager assetManager = getResources().getAssets();
        questionHandler = new QuestionHandler("jsonExample.json", assetManager);



        if (savedInstanceState == null) {
            launchQuizFragment(quizIndex);
        }


        Button exitButton = (Button)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
=======
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
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
<<<<<<< HEAD
        Button nextButton = (Button)findViewById(R.id.exitButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction.remove(fragment).commit();
                launchQuizFragment(1);

            }
        });

    }

    private void launchQuizFragment(int index) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        QuizFragment fragment = new QuizFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("correct counter", 0);
        JSONObject tmpQuestionJSONObject;

        try {
            tmpQuestionJSONObject = questionHandler.getQuestionJSONArray(index);
            bundle.putString("description", tmpQuestionJSONObject.getString("description"));
            Log.e("description",tmpQuestionJSONObject.getString("description"));
            bundle.putString("choices", tmpQuestionJSONObject.getString("choices"));
            bundle.putString("Answer", tmpQuestionJSONObject.getString("answer"));
            bundle.putString("commentary", tmpQuestionJSONObject.getString("commentary"));

            fragment.setArguments(bundle);
            fragmentTransaction.add(R.id.quizShowFragment, fragment);
            fragmentTransaction.commit();

        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

=======


        /*
        getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new QuizFragment())
                    .commit();
         */



    }
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
}
