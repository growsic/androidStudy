package com.growsic.study.myquizapp;

import android.content.res.AssetManager;
import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by a13918 on 2015/05/07.
 */
public class QuestionHandler {
    ArrayList<String> questionJsonArray;
    private JSONObject questionJSONObject;
    private JSONArray questionJSONArray;
    private AssetManager mAssetManager;

    public QuestionHandler(String jsonFileName, AssetManager assetManager) {
        this.mAssetManager = assetManager;
        readQuizData(jsonFileName);

    }

    /**
     * get question data from json file.
     * @param jsonFileName
     */
    public void readQuizData(String jsonFileName) {
        StrictMode.ThreadPolicy policy = new StrictMode.
                ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

        try {
            // read jsonFile to inputStream
            inputStream = mAssetManager.open(jsonFileName);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder jsonInfo = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonInfo.append(line);
            }

            //convert String to JSONObject
            questionJSONObject = new JSONObject(new String(jsonInfo));

            // JSONObject を文字列に変換してログ出力します
            Log.d("result", questionJSONObject.toString());

            questionJSONArray = questionJSONObject.getJSONArray("questions");
            String loudScreaming = questionJSONObject.getJSONArray("questions").getJSONObject(1).getString("description");
            Log.d("description", loudScreaming);


            inputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public JSONObject getQuestionJSONArray(int index) throws JSONException {

        if(index <= questionJSONArray.length()) {
            return questionJSONArray.getJSONObject(index);
        }else {
            Log.d("JSON NUll pointer log", "index is out of range");
            return null;
        }
    }

}
