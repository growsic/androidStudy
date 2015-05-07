package com.growsic.study.myquizapp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by a13918 on 2015/04/30.
 */
public class QuizActivity extends FragmentActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_show_fragment);

        //jsonファイルからクイズを読み込みquestionHandlerに保持
        AssetManager assetManager = getResources().getAssets();
        questionHandler = new QuestionHandler("jsonExample.json", assetManager);



        if (savedInstanceState == null) {
            launchQuizFragment(quizIndex);
        }


        Button exitButton = (Button)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
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

}
