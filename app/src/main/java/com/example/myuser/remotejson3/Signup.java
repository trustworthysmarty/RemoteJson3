package com.example.myuser.remotejson3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by myuser on 5/20/2016.
 */
public class Signup extends Activity implements View.OnClickListener{
    Button signe,facebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_ui_layout);

        signe=(Button)findViewById(R.id.btnSignup);
        signe.setOnClickListener(Signup.this);
        /*facebook=(Button)findViewById(R.id.btnFacebook);
        facebook.setOnClickListener(Signup.this);*/
   }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSignup:
                Intent sign=new Intent(this,Quetion_One.class);
                startActivity(sign);
                break;
        /*    case R.id.btnFacebook:
                Intent facebook= new Intent(this,ImageSlider.class);
                startActivity(facebook);
                break;
        */    default:
                break;

        }

    }
}
