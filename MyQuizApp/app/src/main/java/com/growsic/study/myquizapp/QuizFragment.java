package com.growsic.study.myquizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by a13918 on 2015/04/30.
 */
public class QuizFragment extends Fragment {


    int selectedButton_id;
    View view;
    Button[] buttonArray;
    Button chosenButton;
    Button checkAnswerButton;
    String chosenString;

    String mDescription;
    String mChoices;
    String mAnswer;
    String mCommentary;
    TextView description;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        int counter = bundle.getInt("correct counter");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.quizfragment, container, false);

        buttonArray = new Button[] {(Button) view.findViewById(R.id.choice1),
                                    (Button) view.findViewById(R.id.choice2),
                                    (Button) view.findViewById(R.id.choice3),
                                    (Button) view.findViewById(R.id.choice4),
                                   };
        checkAnswerButton = (Button)view.findViewById(R.id.checkAnswerButton);
        description = (TextView)view.findViewById(R.id.description);

        Bundle bundle = this.getArguments();
        mDescription =  bundle.getString("description", mDescription);
        mChoices = bundle.getString("choices", mChoices);
        mAnswer = bundle.getString("Answer", mAnswer);
        mCommentary = bundle.getString("commentary", mCommentary);

        description.setText(mDescription);
        JSONArray choicesJSONArray = null;
        try {
            choicesJSONArray = new JSONArray(mChoices);
            Log.e("choices", mChoices);
            for(int i = 0; i < buttonArray.length;i++) {
                Log.e("debuggggg", choicesJSONArray.getString(i));
               buttonArray[i].setText(choicesJSONArray.getString(i));
            }

        }catch(JSONException e) {
            e.printStackTrace();
        }



        OnClickListener myListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                for(Button button : buttonArray) {
                    button.setTextColor(Color.BLACK);
                }
                chosenButton =(Button) view.findViewById(v.getId());
                chosenButton.setTextColor(Color.RED);
                chosenString = chosenButton.getText().toString();

            }
        };
        checkAnswerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chosenString.equals(mAnswer)) {
                    Toast.makeText(getActivity(), "正解です！", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(), "不正解です。", Toast.LENGTH_LONG).show();
                }
            }
        });



        for(Button button : buttonArray) {
            button.setOnClickListener(myListener);
        }



        return view;
    }

}
