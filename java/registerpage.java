package com.pro.mindgrove;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pro.mindgrove.facultybox.R;

public class registerpage extends AppCompatActivity {
    public Button signup;
    public void initY() {
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy2 = new Intent(registerpage.this, homepage.class);
                startActivity(toy2);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        initY();
        Typeface myTypeface=Typeface.createFromAsset(getAssets(),"fontf.ttf");
        TextView myTextview=(TextView)findViewById(R.id.textView6);
        myTextview.setTypeface(myTypeface);
    }
}
