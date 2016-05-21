package com.example.myuser.remotejson3;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;


public class Quetion_One extends Activity {


    private TextView surveyhedding;
    private LinearLayout dynamiclayout;
    private TextView radioTextView;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private TextView tv1=null;
    private Survey survey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrolllayoutlist);
        new Remote().execute();
        surveyhedding = (TextView) findViewById(R.id.suravey);
        dynamiclayout = (LinearLayout) findViewById(R.id.dynmicLayout);


        //Radio Group
        radioTextView = (TextView) findViewById(R.id.redioTextView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        //RadioButton
        radioButton1 = (RadioButton) findViewById(R.id.radio1);
        radioButton2 = (RadioButton) findViewById(R.id.radio2);

       /* radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id=radioGroup.getCheckedRadioButtonId();
                View radiobutton=radioGroup.findViewById(id);

            }
        });
*/
    }

    private class Remote extends AsyncTask<String, Void, Boolean> {

        private ResponseBean respone;

        @Override
        protected Boolean doInBackground(String... params) {
            String url1 = "http://api.buzz.ninja/index.php?method=getSurvey&survey_id=1";


            URL url = null;
            try {
                url = new URL(url1);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection connection = null;
            if (url != null) try {
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            int mConnectionCode = 0;
            try {
                mConnectionCode = connection.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (mConnectionCode == HttpURLConnection.HTTP_OK) {

                InputStream is = null;
                try {
                    is = connection.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BufferedReader rd = null;
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    rd = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);

                    String line = null;
                    while ((line = rd.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    is.close();
                    String json = stringBuilder.toString();

                } catch (IOException e) {
                    Log.e("Error", "Error result " + e.toString());
                }
                    survey = new Survey();
                    QuetionBean qb = null;
                respone = new ResponseBean();
                try {
                    //survey
                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    survey.setSurveyId(jsonObject.getString("survey_id"));
                    survey.setSurveyName(jsonObject.getString("survey_name"));
                    survey.setSurveyCategory(jsonObject.getString("survey_category"));
                    survey.setSurveyBase(jsonObject.getString("survey_base"));
                    survey.setSurveyStartdate(jsonObject.getString("survey_startdate"));
                    survey.setSurveyEnddate(jsonObject.getString("survey_enddate"));
                    survey.setSurveyActive(jsonObject.getString("survey_active"));
                    survey.setSurveyAward(jsonObject.getString("survey_award"));


                    //questions
                    survey.setQuetionBeanArrayList(new ArrayList<QuetionBean>());
                    JSONArray jsonArrayProperty = jsonObject.getJSONArray("questions");
                    for (int i = 0; i < jsonArrayProperty.length(); i++) {

                        JSONObject jsonObjectProperty = jsonArrayProperty.getJSONObject(i);
                        String id = jsonObjectProperty.getString("id");
                        String questionorder = jsonObjectProperty.getString("question_order");
                        String question = jsonObjectProperty.getString("question");
                        String bas = jsonObjectProperty.getString("base");
                        String response = jsonObjectProperty.getString("response_type");
                        String rendomize = jsonObjectProperty.getString("randomize");
                        String other = jsonObjectProperty.getString("other");
                        String none = jsonObjectProperty.getString("none");
                        String notsure = jsonObjectProperty.getString("notsure");
                        String dicline = jsonObjectProperty.getString("decline");

                        qb = new QuetionBean();
                        qb.setQuestionsId(id);
                        qb.setQuestionOrder(questionorder);
                        qb.setQuestionsQuestion(question);
                        qb.setQuestionBase(bas);
                        qb.setQuestionResponses(response);
                        qb.setQuestionRandomize(rendomize);
                        qb.setQuestionOther(other);
                        qb.setQuestionNone(none);
                        qb.setQuestionNotsure(notsure);
                        qb.setQuestionDecline(dicline);

                        survey.getQuetionBeanArrayList().add(qb);

                        //Response(.....questions........)
                        qb.setResponseBeanslist(new ArrayList<ResponseBean>());
                        JSONArray jsonArrayResponse = jsonObjectProperty.getJSONArray("responses");
                        for (int k = 0; k < jsonArrayResponse.length(); k++) {
                            JSONObject responseObjectProperty = jsonArrayResponse.getJSONObject(k);
                            String code = responseObjectProperty.getString("code");
                            String wording = responseObjectProperty.getString("wording");
                            String next = responseObjectProperty.getString("next");

                            ResponseBean responseBean = new ResponseBean();
                            responseBean.setResponseBeanCode(code);
                            responseBean.setResponseBeanWording(wording);
                            responseBean.setResponseBeanNext(next);
                            qb.getResponseBeanslist().add(responseBean);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("survey " + survey);


            }
            return true;
        }


        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            surveyhedding.setText(survey.getSurveyName());
            ArrayList<QuetionBean> list = survey.getQuetionBeanArrayList();
            TextView tv1 = null;
            TextView tv = null;
            for (int i = 0; i < list.size(); i++) {
                QuetionBean obj = list.get(i);

                if (Integer.parseInt(obj.getQuestionResponses()) == 1)

                {
                    tv = new TextView(Quetion_One.this);

                    RadioGroup radiogrp = new RadioGroup(Quetion_One.this);
                    //get Arraylist of Response
                    ArrayList<ResponseBean>list1=obj.getResponseBeanslist();
                    for (int j = 0; j < obj.getResponseBeanslist().size(); j++) {
                        ResponseBean rb=list1.get(j);

                        RadioButton rb1 = new RadioButton(Quetion_One.this);

                        //Name Changing in dynamically
                        rb1.setText(rb.getResponseBeanWording());
                        radiogrp.addView(rb1);
                    }
                    dynamiclayout.addView(tv);
                    dynamiclayout.addView(radiogrp);
                    tv.setText(list.get(i).getQuestionsQuestion());
                }
            }
                   Intent intent = new Intent(Quetion_One.this, Second_Activity.class);
                    startActivityForResult(intent, 2);
                }
            }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==2) {

            Toast.makeText(this, "okk", Toast.LENGTH_SHORT).show();
        }
        else if (requestCode == RESULT_CANCELED) {
            Toast.makeText(this, "canceled", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}