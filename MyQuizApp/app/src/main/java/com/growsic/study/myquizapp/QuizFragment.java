package com.growsic.study.myquizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

=======
import android.widget.Toast;

>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
/**
 * Created by a13918 on 2015/04/30.
 */
public class QuizFragment extends Fragment {


    int selectedButton_id;
    View view;
    Button[] buttonArray;
<<<<<<< HEAD
=======
    String[] choiceArray;
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
    Button chosenButton;
    Button checkAnswerButton;
    String chosenString;

<<<<<<< HEAD
    String mDescription;
    String mChoices;
    String mAnswer;
    String mCommentary;
    TextView description;

=======
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        int counter = bundle.getInt("correct counter");
<<<<<<< HEAD

=======
        //Button button = (Button) getView().findViewById(R.id.choice1);
        //button.setText("てすと");






/*
        button.setText(Integer.toString(counter));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //some code
            }
        });
        */
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
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
<<<<<<< HEAD
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

=======

        //strings.xmlから取得したい。答えと解説も。
        choiceArray = new String[] {"福沢諭吉",
                                    "野口英世",
                                    "樋口一葉",
                                    "安倍晋三"
                                    };
        final String answerString = choiceArray[1];
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb


        OnClickListener myListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                for(Button button : buttonArray) {
                    button.setTextColor(Color.BLACK);
                }
                chosenButton =(Button) view.findViewById(v.getId());
                chosenButton.setTextColor(Color.RED);
                chosenString = chosenButton.getText().toString();
<<<<<<< HEAD
=======
                //Log.e("tag", string);
                //choiceArray[0].setText(string);
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb

            }
        };
        checkAnswerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD

                if(chosenString.equals(mAnswer)) {
=======
                if(chosenString == answerString) {
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb
                    Toast.makeText(getActivity(), "正解です！", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(), "不正解です。", Toast.LENGTH_LONG).show();
                }
            }
        });



        for(Button button : buttonArray) {
            button.setOnClickListener(myListener);
        }

<<<<<<< HEAD

=======
        for(int i = 0; i < buttonArray.length;i++) {
            buttonArray[i].setText(choiceArray[i]);
        }
>>>>>>> d758304cbe46a2cc70be1fcf492072cae45fc4fb

        return view;
    }

}
