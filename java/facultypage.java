package com.pro.mindgrove;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pro.mindgrove.facultybox.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class facultypage extends AppCompatActivity {
    EditText edit_name;
    EditText edit_age;
    EditText edit_number;
    EditText edit_pan;
    MaterialBetterSpinner spinner_stream;
    MaterialBetterSpinner spinner_subject;
    EditText edit_email;
    EditText edit_pass;
    Button btn_reg;
    public Button button_reg;
    private static final String REGISTER_URL="http://vjtecho.esy.es/UserRegistration/fac_register.php";
    public void initYY() {
        button_reg = (Button) findViewById(R.id.btn_reg);
        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy3 = new Intent(facultypage.this,navigation.class);
                startActivity(toy3);
            }
        });
    }
    String[] stream= {"select stream", "Engineering", "Medical", "junior(foundation)", "CA/ICWA/CS", "CLAT", "IAS", "CAT-MBA Entrance"};
    String[] subject= {"select subject","physics","Mathematics","chemistry","biology","Botany","Zoology","Social Science","English","Tax","Law"
            ,"Audit","Financial Accounting","Corporate Finance","Verbal","Aptitude","Polity","Geography","History","Science","Economics","Public Administration","Environment & Ecology"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultypage);
        edit_name = (EditText) findViewById(R.id.id_name);
        edit_age = (EditText)findViewById(R.id.id_age);
        edit_number=(EditText)findViewById(R.id.id_number);
        edit_pan=(EditText)findViewById(R.id.id_pan);
        spinner_stream=(MaterialBetterSpinner)findViewById(R.id.id_stream);
        spinner_subject=(MaterialBetterSpinner)findViewById(R.id.id_subject);
        edit_email = (EditText) findViewById(R.id.id_email);
        edit_pass = (EditText) findViewById(R.id.id_pass);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regiseterUser();
            }
        });
        initYY();
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, subject);
        MaterialBetterSpinner betterSpinner2 = (MaterialBetterSpinner) findViewById(R.id.id_subject);
        betterSpinner2.setAdapter(arrayAdapter2);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, stream);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.id_stream);
        betterSpinner.setAdapter(arrayAdapter);

    }

    private void regiseterUser() {
        String name = edit_name.getText().toString().trim().toLowerCase();
        String age=edit_age.getText().toString().trim().toLowerCase();
        String number=edit_number.getText().toString().trim().toLowerCase();
        String pan=edit_pan.getText().toString().trim().toLowerCase();
        String stream=spinner_stream.getText().toString().toLowerCase();
        String subject=spinner_subject.getText().toString().toLowerCase();
        String email = edit_email.getText().toString().trim().toLowerCase();
        String password = edit_pass.getText().toString().trim().toLowerCase();
        register(name,age,number,pan,stream,subject,email,password);
    }
    private void register(String name, String password, String email,String age,String number,String pan,String stream,String subject){
        String urlSuffix = "?name=" + name  + "&age="+ age + "&number"+number+ "&password=" + password + "&email=" + email + "&pan"+pan+"&stream"+stream+"subject"+subject;
        class RegisterUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(facultypage.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),"Registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(REGISTER_URL+s);
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    bufferReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferReader.readLine();
                    return  result;

                }catch (Exception e){
                    return null;
                }
            }

        }
        RegisterUser ur=new RegisterUser();
        ur.execute(urlSuffix);
    }
}

