package com.pro.mindgrove;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pro.mindgrove.facultybox.R;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.ErrorListener;

public class signinpage extends AppCompatActivity {

    public Button sign;
    public void initXX() {
        sign = (Button) findViewById(R.id.btn_login);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy3 = new Intent(signinpage.this,homepage.class);
                startActivity(toy3);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinpage);
        initXX();
        Typeface myTypeface=Typeface.createFromAsset(getAssets(),"fontf.ttf");
        TextView myTextview=(TextView)findViewById(R.id.textView14);
        myTextview.setTypeface(myTypeface);
    }


    }

