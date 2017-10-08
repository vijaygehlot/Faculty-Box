package com.pro.mindgrove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pro.mindgrove.facultybox.R;
import com.pro.mindgrove.facultybox.institute;

public class homepage extends AppCompatActivity {
    public Button work;
    public void initXY() {
        work = (Button) findViewById(R.id.work);
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy3 = new Intent(homepage.this, facultypage.class);
                startActivity(toy3);
            }
        });
    }
    public Button hire;
    public void initWY() {
        hire = (Button) findViewById(R.id.hire);
        hire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy3 = new Intent(homepage.this,institute.class);
                startActivity(toy3);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        initXY();
        initWY();
    }
}
