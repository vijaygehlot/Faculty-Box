package com.pro.mindgrove.facultybox;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pro.mindgrove.loginpage;

public class welcomepage extends AppCompatActivity {
private static int SPASH_TIME_OUT=10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent HIntent=new Intent(welcomepage.this,loginpage.class);
                startActivity(HIntent);
                finish();
            }
        },SPASH_TIME_OUT);
    }
}
