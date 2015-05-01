package com.growsic.study.myquizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by a13918 on 2015/04/30.
 */
public class QuizFragment extends Fragment {


    int selectedButton_id;
    View view;
    Button[] buttonArray;
    String[] choiceArray;
    Button chosenButton;
    Button checkAnswerButton;
    String chosenString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();

        int counter = bundle.getInt("correct counter");
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

        //strings.xmlから取得したい。答えと解説も。
        choiceArray = new String[] {"福沢諭吉",
                                    "野口英世",
                                    "樋口一葉",
                                    "安倍晋三"
                                    };
        final String answerString = choiceArray[1];


        OnClickListener myListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                for(Button button : buttonArray) {
                    button.setTextColor(Color.BLACK);
                }
                chosenButton =(Button) view.findViewById(v.getId());
                chosenButton.setTextColor(Color.RED);
                chosenString = chosenButton.getText().toString();
                //Log.e("tag", string);
                //choiceArray[0].setText(string);

            }
        };
        checkAnswerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chosenString == answerString) {
                    Toast.makeText(getActivity(), "正解です！", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(), "不正解です。", Toast.LENGTH_LONG).show();
                }
            }
        });



        for(Button button : buttonArray) {
            button.setOnClickListener(myListener);
        }

        for(int i = 0; i < buttonArray.length;i++) {
            buttonArray[i].setText(choiceArray[i]);
        }

        return view;
    }

}
