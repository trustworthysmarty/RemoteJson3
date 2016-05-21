package com.example.myuser.remotejson3;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class Second_Activity extends Activity {
    EditText editText1;
    Button button1;
    private RadioGroup radioGroup;
    private  RadioButton radioButton1,radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioButton1=(RadioButton)findViewById(R.id.radio0);
        radioButton2=(RadioButton)findViewById(R.id.radio2);
        button1 = (Button) findViewById(R.id.submit_button);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String message = editText1.getText().toString();
                Intent intent = new Intent(Second_Activity.this,Quetion_One.class);
                intent.putExtra("Success", message);
                setResult(2, intent);
                finish();
            }
        });
    }


}