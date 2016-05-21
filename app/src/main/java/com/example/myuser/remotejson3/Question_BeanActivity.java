package com.example.myuser.remotejson3;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by myuser on 5/21/2016.
 */
public class Question_BeanActivity extends Activity implements View.OnClickListener {
    private TextView surveyhedding;
    private LinearLayout dynamiclayout;
    private TextView radioTextView;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private TextView tv1 = null;
    String jsonString="";
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrolllayoutlist);
        surveyhedding = (TextView) findViewById(R.id.suravey);
        dynamiclayout = (LinearLayout) findViewById(R.id.dynmicLayout);
        Button button=(Button)findViewById(R.id.submit_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


    }


}